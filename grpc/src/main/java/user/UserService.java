package user;

import com.example.grpc.User.APIResponse;
import com.example.grpc.User.loginRequest;
import com.example.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{

	@Override
	public void login(loginRequest request, StreamObserver<APIResponse> responseObserver) {
		
		System.out.println("Inside login");
		
		String username = request.getUsername();
		String password = request.getPassword();
		
		APIResponse.Builder response = APIResponse.newBuilder();
		if(username.equals(password)) {
			
			 // return success message
			
			response.setResponseCode(0).setResponseMessage(password);
			
		}
		else {
			response.setResponseCode(100).setResponseMessage("INVALID PASSWORD");
		}
		
		
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
}
