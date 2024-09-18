package com.micro.externalConnectorImpl;

import com.micro.externalConnector.PaymentServiceHandler;
import com.micro.paymentService.PaymentInitiateRequest;
import com.micro.paymentService.PaymentInitiateResponse;
import com.micro.paymentService.PaymentServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceHandlerImpl implements PaymentServiceHandler {

    @GrpcClient("payment-service")
    PaymentServiceGrpc.PaymentServiceBlockingStub paymentServiceBlockingStub;
    @Override
    public void sendThePaymentInitiateMessage(PaymentInitiateRequest paymentInitiateRequest) {
        try{
            PaymentInitiateResponse paymentInitiateResponse = paymentServiceBlockingStub.paymentInitiate(paymentInitiateRequest);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
