load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")
load("@io_grpc_grpc_java//:java_grpc_library.bzl", "java_grpc_library")

java_grpc_library(
    name = "build_event_stream_grpc",
    srcs = ["//src/main/protobuf:build_event_stream_proto"],
    deps = ["//src/main/protobuf:build_event_stream_java_proto"],
)