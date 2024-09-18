package com.micro.controller;

import com.micro.paymentService.PaymentFailRequest;
import com.micro.paymentService.PaymentFailResponse;
import com.micro.paymentService.PaymentServiceGrpc;
import com.micro.service.PaymentFailService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class PaymentFailPublisherController extends PaymentServiceGrpc.PaymentServiceImplBase {

    @Autowired
    private PaymentFailService paymentFailService;
    @Override
    public void paymentFail(PaymentFailRequest request, StreamObserver<PaymentFailResponse> responseObserver) {
        try{
            paymentFailService.processPaymentFailMessage(request);
            responseObserver.onNext(PaymentFailResponse.newBuilder()
                    .setStatus(true)
                    .setMessage("message received successfully")
                    .build());
            responseObserver.onCompleted();
        }catch (Exception ex){
            responseObserver.onNext(PaymentFailResponse.newBuilder()
                    .setStatus(false)
                    .setMessage("message received fail")
                    .build());
            responseObserver.onCompleted();
        }
    }
}
