package com.micro.controller;

import com.micro.paymentService.PaymentServiceGrpc;
import com.micro.paymentService.PaymentSuccessRequest;
import com.micro.paymentService.PaymentSuccessResponse;
import com.micro.service.PaymentSuccessService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class PaymentSuccessController extends PaymentServiceGrpc.PaymentServiceImplBase {

    @Autowired
    private PaymentSuccessService paymentSuccessService;
    @Override
    public void paymentSuccess(PaymentSuccessRequest request, StreamObserver<PaymentSuccessResponse> responseObserver) {
        paymentSuccessService.processPaymentSuccessMessage(request);
        responseObserver.onNext(PaymentSuccessResponse.newBuilder().setStatus(true).setMessage("message received").build());
        responseObserver.onCompleted();
    }
}
