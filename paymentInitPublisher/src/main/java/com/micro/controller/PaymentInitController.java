package com.micro.controller;

import com.micro.paymentService.PaymentInitiateRequest;
import com.micro.paymentService.PaymentInitiateResponse;
import com.micro.paymentService.PaymentServiceGrpc;
import com.micro.service.PaymentInitService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class PaymentInitController extends PaymentServiceGrpc.PaymentServiceImplBase {

    @Autowired
    private PaymentInitService paymentInitService;
    @Override
    public void paymentInitiate(PaymentInitiateRequest request, StreamObserver<PaymentInitiateResponse> responseObserver) {
        paymentInitService.processPaymentInitiate(request);
        responseObserver.onNext(PaymentInitiateResponse.newBuilder()
                .setStatus(true)
                .setMessage("message received")
                .build());
        responseObserver.onCompleted();
    }
}
