load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

#Kotlin rules
#rules_kotlin_version = "1.6.0"
#rules_kotlin_sha = "a57591404423a52bd6b18ebba7979e8cd2243534736c5c94d35c89718ea38f94"
#http_archive(
#    name = "io_bazel_rules_kotlin",
#    urls = ["https://github.com/bazelbuild/rules_kotlin/releases/download/v%s/rules_kotlin_release.tgz" % rules_kotlin_version],
#    sha256 = rules_kotlin_sha,
#)

#load("@io_bazel_rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories")
#kotlin_repositories() # if you want the default. Otherwise see custom kotlinc distribution below

#load("@io_bazel_rules_kotlin//kotlin:core.bzl", "kt_register_toolchains")
#kt_register_toolchains() # to use the default toolchain, otherwise see toolchains below

http_archive(
    name = "rules_jvm_external",
    sha256 = "cd1a77b7b02e8e008439ca76fd34f5b07aecb8c752961f9640dea15e9e5ba1ca",
    strip_prefix = "rules_jvm_external-4.2",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/4.2.zip",
)


http_archive(
    name = "com_github_grpc_grpc_kotlin",
    strip_prefix = "grpc-kotlin-1.3.0",
    url = "https://github.com/grpc/grpc-kotlin/archive/refs/tags/v1.3.0.zip",
)

load(
    "@com_github_grpc_grpc_kotlin//:repositories.bzl",
    "IO_GRPC_GRPC_KOTLIN_ARTIFACTS",
    "IO_GRPC_GRPC_KOTLIN_OVERRIDE_TARGETS",
    "grpc_kt_repositories",
    "io_grpc_grpc_java",
)

io_grpc_grpc_java()

load(
    "@io_grpc_grpc_java//:repositories.bzl",
    "IO_GRPC_GRPC_JAVA_ARTIFACTS",
    "IO_GRPC_GRPC_JAVA_OVERRIDE_TARGETS",
    "grpc_java_repositories",
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "com.google.jimfs:jimfs:1.1",
        "com.google.truth.extensions:truth-proto-extension:1.0.1",
        "com.google.protobuf:protobuf-kotlin:3.18.0",
    ] + IO_GRPC_GRPC_KOTLIN_ARTIFACTS + IO_GRPC_GRPC_JAVA_ARTIFACTS,
    override_targets = dict(
        IO_GRPC_GRPC_KOTLIN_OVERRIDE_TARGETS.items() +
        IO_GRPC_GRPC_JAVA_OVERRIDE_TARGETS.items(),
    ),
    repositories = [
        "https://repo.maven.apache.org/maven2/",
    ],
    generate_compat_repositories = True,
)

load("@maven//:compat.bzl", "compat_repositories")

compat_repositories()

grpc_kt_repositories()

grpc_java_repositories()

# Protocol Buffers
load("@com_google_protobuf//:protobuf_deps.bzl", "protobuf_deps")

protobuf_deps()

# Kotlin
load("@io_bazel_rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories")

kotlin_repositories()

load("@io_bazel_rules_kotlin//kotlin:core.bzl", "kt_register_toolchains")

kt_register_toolchains()

# Needed for the googleapis protos.
# Version of googleapis is taken from remote-apis repository
# to ensure compatibility.
http_archive(
    name = "googleapis",
    sha256 = "f25472e77c059ebcda01fd241bf5d6094b62747cafa8e939ac776c16069e5852",
    strip_prefix = "googleapis-01d4201e2620da2084d2151522c25cf49dda9da3",
    urls = ["https://github.com/googleapis/googleapis/archive/01d4201e2620da2084d2151522c25cf49dda9da3.zip"],
)

load("@googleapis//:repository_rules.bzl", "switched_rules_by_language")

switched_rules_by_language(
    name = "com_google_googleapis_imports",
    grpc = True,
    java = True,
)
