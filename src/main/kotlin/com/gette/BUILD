package(default_visibility = ["//visibility:public"])
load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")
load("@com_github_grpc_grpc_kotlin//:kt_jvm_grpc.bzl", "kt_jvm_proto_library", "kt_jvm_grpc_library")
load("@io_grpc_grpc_java//:java_grpc_library.bzl", "java_grpc_library")
load("@rules_java//java:defs.bzl", "java_proto_library")

kt_jvm_proto_library(
    name = "build_kt_proto",
    deps = ["@googleapis//google/devtools/build/v1:build_proto"],
)

kt_jvm_grpc_library(
    name = "build_event_service_grpc",
    srcs = ["@googleapis//google/devtools/build/v1:build_proto"],
    deps = [":build_kt_proto"],
)

kt_jvm_library(
    name = "server_lib",
    srcs = ["Server.kt"],
    deps = ["//src/main/kotlin/com/gette/service:build_event_service"],
    runtime_deps = ["@io_grpc_grpc_java//netty"],
)

java_binary(
    name = "server",
    main_class = "com.gette.ServerKt",
    runtime_deps = [":server_lib"]
)
