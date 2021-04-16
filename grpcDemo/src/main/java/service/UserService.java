package service;


import com.yrrhelp.grpc.User;
import com.yrrhelp.grpc.userGrpc;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class UserService extends userGrpc.userImplBase {

    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {

        System.out.println("Inside login");

        String username = request.getUsername();
        String password = request.getPassword();
        Logger.getLogger("info").info("Testing log: " + request.getUsername());
        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        if (username.equals(password)) {

            // return success message

            response.setResponseCode(0).setResponseMessage("SUCCESS");

        } else {
            response.setResponseCode(100).setResponseMessage("INVALID PASSWORD");
        }


        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        response.setResponseCode(0);
        response.setResponseMessage("LOGOUT");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }


}

