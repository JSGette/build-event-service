package com.gette.service

import com.google.devtools.build.v1.*
import com.google.protobuf.Empty
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object BuildEventServiceImpl : PublishBuildEventGrpcKt.PublishBuildEventCoroutineImplBase() {
    override suspend fun publishLifecycleEvent(request: PublishLifecycleEventRequest): Empty {
        return Empty.getDefaultInstance()
    }

    override fun publishBuildToolEventStream(requests: Flow<PublishBuildToolEventStreamRequest>): Flow<PublishBuildToolEventStreamResponse> {
        return flow {
//            emit(PublishBuildToolEventStreamResponse.newBuilder().build())
        }
    }
}
