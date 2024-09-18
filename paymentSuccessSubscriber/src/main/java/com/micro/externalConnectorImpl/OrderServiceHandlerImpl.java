package com.micro.externalConnectorImpl;

import com.micro.extrenalConnector.OrderServiceHandler;
import com.micro.paymentService.PaymentServiceGrpc;
import com.micro.paymentService.PaymentSuccessRequest;
import com.micro.paymentService.PaymentSuccessResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceHandlerImpl implements OrderServiceHandler {

    @GrpcClient("order-service")
    PaymentServiceGrpc.PaymentServiceBlockingStub paymentServiceBlockingStub;
    @Override
    public void sendPaymentSuccessMessage(PaymentSuccessRequest request) {
        try{
            PaymentSuccessResponse paymentSuccessResponse =
                    paymentServiceBlockingStub.paymentSuccess(request);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
