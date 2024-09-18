package com.micro.controller;

import com.micro.productService.ProductReserveFailRequest;
import com.micro.productService.ProductReserveFailResponse;
import com.micro.productService.ProductServiceGrpc;
import com.micro.service.ProductReserveFailService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class ProductReserveFailPublisherController extends ProductServiceGrpc.ProductServiceImplBase {
    @Autowired
    private ProductReserveFailService productReserveFailService;

    @Override
    public void productReserveFail(ProductReserveFailRequest request, StreamObserver<ProductReserveFailResponse> responseObserver) {
        productReserveFailService.processProductReserveFailMessage(request);
        responseObserver.onCompleted();
    }
}
