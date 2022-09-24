package com.gette.service

import io.grpc.stub.StreamObserver
import com.google.protobuf.Empty
import com.google.devtools.build.v1.PublishBuildEventGrpc
import com.google.devtools.build.v1.PublishLifecycleEventRequest
import com.google.devtools.build.v1.PublishBuildToolEventStreamRequest
import com.google.devtools.build.v1.PublishBuildToolEventStreamResponse

object BuildEventServiceImpl: PublishBuildEventGrpc.PublishBuildEventImplBase() {

    override fun publishLifecycleEvent(request: PublishLifecycleEventRequest, responseObserver: StreamObserver<Empty>) {
        println(request.getServiceLevelValue())
        responseObserver.onCompleted()
    }

    /*override fun publishBuildToolEventStream(responseObserver: StreamObserver<PublishBuildToolEventStreamResponse>): StreamObserver<PublishBuildToolEventStreamRequest> {
        return responseObserver
    }*/
    
}
