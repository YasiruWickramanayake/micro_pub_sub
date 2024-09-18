package com.micro.productReserveInitPublisher.controller;

import com.micro.orderService.OrderServiceGrpc;
import com.micro.orderService.ProductReservationInitRequest;
import com.micro.orderService.ProductReservationInitResponse;
import com.micro.productReserveInitPublisher.service.ProductReservationPublisherService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class ProductReservationPublisherConnector extends OrderServiceGrpc.OrderServiceImplBase {

    @Autowired
    private ProductReservationPublisherService productReservationPublisherService;
    @Override
    public void initiateProductReservation(ProductReservationInitRequest request, StreamObserver<ProductReservationInitResponse> responseObserver) {
        System.out.println("message received " + request);
        productReservationPublisherService.initiateProductReservation(request);
        responseObserver.onNext(ProductReservationInitResponse.newBuilder()
                .setSagaId(request.getSagaId())
                .setStatus(true)
                .build());
        responseObserver.onCompleted();
    }
}
