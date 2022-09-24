import io.grpc.stub.StreamObserver
import com.google.protobuf.Empty
import com.google.devtools.build.v1.PublishBuildEventGrpc
import com.google.devtools.build.v1.PublishLifecycleEventRequest

object BuildEventServiceImpl: PublishBuildEventGrpc.PublishBuildEventImplBase() {

    override fun publishLifecycleEvent(req: PublishLifecycleEventRequest, response: StreamObserver<Empty>) {
        
    }
    
}
