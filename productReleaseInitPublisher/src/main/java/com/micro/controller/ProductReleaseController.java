package com.micro.controller;

import com.micro.productService.ProductReleaseInitRequest;
import com.micro.productService.ProductReleaseInitResponse;
import com.micro.productService.ProductServiceGrpc;
import com.micro.service.ProductReleaseInitiateService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class ProductReleaseController extends ProductServiceGrpc.ProductServiceImplBase {
    @Autowired
    private ProductReleaseInitiateService productReleaseInitiateService;

    @Override
    public void releaseReservedProduct(ProductReleaseInitRequest request, StreamObserver<ProductReleaseInitResponse> responseObserver) {
        try{
            productReleaseInitiateService.processReleaseProductInitiate(request);
            responseObserver.onNext(ProductReleaseInitResponse.newBuilder()
                    .setStatus(true)
                    .setMessage("message received")
                    .build());
            responseObserver.onCompleted();
        }catch (RuntimeException ex){
            responseObserver.onNext(ProductReleaseInitResponse.newBuilder()
                    .setStatus(false)
                    .setMessage("message received failed")
                    .build());
            responseObserver.onCompleted();
        }
    }
}
