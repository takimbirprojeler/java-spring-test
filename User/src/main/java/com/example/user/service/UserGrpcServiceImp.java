package com.example.user.service;

import com.example.grpc.APIResaponse;
import com.example.grpc.LoginRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import com.example.grpc.userGrpc.userImplBase;

@GrpcService
public class UserGrpcServiceImp extends userImplBase{
    @Override
    public void login(LoginRequest request, StreamObserver<APIResaponse> responseObserver) {
        System.out.println("inside login");
        String username = request.getUsername();
        String password = request.getPassword();

        APIResaponse.Builder response = APIResaponse.newBuilder();

        if (username.equals(password)){
            response.setResponseCode(0).setResponsemessage("Success");
        }else{
            response.setResponseCode(0).setResponsemessage("Ivalid password");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
