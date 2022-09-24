package(default_visibility = ["//visibility:public"])
load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "build_event_service",
    srcs = glob(["*.kt"]),
    deps = [
        "//src/main/protobuf:build_event_stream_grpc",
        "//src/main/kotlin/com/gette:build_event_service_grpc",
    ]
)
