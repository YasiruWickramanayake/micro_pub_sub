package com.micro.controller;

import com.micro.productService.*;
import com.micro.service.ProductReleaseSuccessMessageService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class ItemReleaseSuccessController extends ProductServiceGrpc.ProductServiceImplBase {
    @Autowired
    private ProductReleaseSuccessMessageService productReleaseSuccessMessageService;

    @Override
    public void productReleaseSuccess(ProductReleaseSuccessRequest request, StreamObserver<ProductReleaseSuccessResponse> responseObserver) {
        try{
            productReleaseSuccessMessageService.processProductReleaseSuccessMessage(request);
            responseObserver.onNext(ProductReleaseSuccessResponse.newBuilder()
                    .setStatus(true)
                    .setMessage("message received successfully")
                    .build());
            responseObserver.onCompleted();
        }catch (RuntimeException ex){
            responseObserver.onNext(ProductReleaseSuccessResponse.newBuilder()
                    .setStatus(false)
                    .setMessage("message received failed")
                    .build());
            responseObserver.onCompleted();
        }
    }
}
