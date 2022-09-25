package(default_visibility = ["//visibility:public"])
load("@rules_java//java:defs.bzl", "java_proto_library")
load("@rules_proto//proto:defs.bzl", "proto_library")
load("@com_github_grpc_grpc_kotlin//:kt_jvm_grpc.bzl", "kt_jvm_proto_library")
#Proto-files taken from bazel 5.3.1
kt_jvm_proto_library(
    name = "build_event_stream_kt_proto",
    deps = [":build_event_stream_proto"],
)

proto_library(
    name = "command_line_proto",
    srcs = ["command_line.proto"],
    deps = [":option_filters_proto"],
)

proto_library(
    name = "option_filters_proto",
    srcs = ["option_filters.proto"],
)

proto_library(
    name = "failure_details_proto",
    srcs = ["failure_details.proto"],
    deps = ["@com_google_protobuf//:descriptor_proto"],
)

proto_library(
    name = "invocation_policy_proto",
    srcs = ["invocation_policy.proto"],
)

proto_library(
    name = "build_event_stream_proto",
    srcs = ["build_event_stream.proto"],
    deps = [
        ":command_line_proto",
        ":failure_details_proto",
        ":invocation_policy_proto",
        "@com_google_protobuf//:duration_proto",
        "@com_google_protobuf//:timestamp_proto",
    ],
)
