package(default_visibility = ["//visibility:public"])
load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")
load("@io_grpc_grpc_java//:java_grpc_library.bzl", "java_grpc_library")
load("@rules_java//java:defs.bzl", "java_proto_library")

java_proto_library(
    name = "build_java_proto",
    deps = ["@googleapis//google/devtools/build/v1:build_proto"],
)

java_grpc_library(
    name = "build_event_service_grpc",
    srcs = ["@googleapis//google/devtools/build/v1:build_proto"],
    deps = [":build_java_proto"],
)
java_grpc_library(
    name = "build_event_stream_grpc",
    srcs = ["//src/main/protobuf:build_event_stream_proto"],
    deps = ["//src/main/protobuf:build_event_stream_java_proto"],
)

kt_jvm_library(
    name = "server_lib",
    srcs = ["Server.kt"],
    deps = ["//src/main/kotlin/com/gette/service:build_event_service"],
    runtime_deps = ["@io_grpc_grpc_java//netty"],
)
