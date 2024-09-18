package com.micro.controller;

import com.micro.productService.*;
import com.micro.service.ProductReserveSuccessService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@GrpcService
public class ProductReserveSuccessController extends ProductServiceGrpc.ProductServiceImplBase {

    @Autowired
    private ProductReserveSuccessService productReserveSuccessService;

    @Override
    public void productReserveSuccess(ProductReserveSuccessRequest request, StreamObserver<ProductReserveSuccessResponse> responseObserver) {
        productReserveSuccessService.processProductSuccess(request);
        responseObserver.onNext(ProductReserveSuccessResponse.newBuilder().setStatus(true).setMessage("success").build());
        responseObserver.onCompleted();
    }
}
