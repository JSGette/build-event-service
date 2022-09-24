package com.gette

import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver

fun main() {
    val port = 50051

    println("Starting server...")
    val server = ServerBuilder.forPort(port)
        .build()
        .start()

    Runtime.getRuntime().addShutdownHook(object : Thread() {
        override fun run() {
            println("Shutting down server...");
            server.shutdown();
            println("Server shut down.");
        }
    });

    println("Server started, listening on $port.")
    server.awaitTermination()
}
