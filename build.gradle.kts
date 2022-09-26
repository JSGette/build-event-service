import com.google.protobuf.gradle.*
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

plugins {
    kotlin("jvm") version "1.7.10"
    id("com.google.protobuf") version "0.8.19"
}

val protobufVersion = "3.21.6"
val grpcVersion = "1.49.1"
val grpcKtVersion = "1.3.0"

dependencies {
    implementation("com.google.protobuf:protobuf-java:$protobufVersion")
    implementation("com.google.protobuf:protobuf-kotlin:$protobufVersion")
    implementation("io.grpc:grpc-stub:$grpcVersion")
    implementation("io.grpc:grpc-protobuf:$grpcVersion")
    implementation("io.grpc:grpc-kotlin-stub:$grpcKtVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
}

repositories {
    mavenCentral()
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobufVersion"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
        id("grpcKt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:$grpcKtVersion:jdk8@jar"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpc")
                id("grpcKt")
            }
            it.builtins {
                id("kotlin")
            }
        }
    }
}

val outputDir = layout.buildDirectory.dir("required_proto")

val syncRequiredProto = tasks.register<Sync>("syncRequiredProto") {
    from("/usr/include")
    include("google/devtools/build/v1/*.proto")
    into(outputDir)
}

sourceSets {
    named("main") {
        proto {
            srcDir(syncRequiredProto)
        }
        java {
            srcDir("build/generated/source/proto/main/java")
            srcDir("build/generated/source/proto/main/grpc")
        }
        withConvention(KotlinSourceSet::class) {
            kotlin.srcDir("build/generated/source/proto/main/kotlin")
            kotlin.srcDir("build/generated/source/proto/main/grpcKt")
        }
    }
}
