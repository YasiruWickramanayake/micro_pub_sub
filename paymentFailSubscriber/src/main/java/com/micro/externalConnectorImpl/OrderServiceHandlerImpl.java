package com.micro.externalConnectorImpl;

import com.micro.externalConnector.OrderServiceHandler;
import com.micro.paymentService.PaymentFailRequest;
import com.micro.paymentService.PaymentFailResponse;
import com.micro.paymentService.PaymentServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceHandlerImpl implements OrderServiceHandler {

    @GrpcClient("order-service")
    PaymentServiceGrpc.PaymentServiceBlockingStub paymentServiceBlockingStub;

    @Override
    public void passMessageToOrderService(PaymentFailRequest request) {
        try{
            PaymentFailResponse paymentFailResponse = paymentServiceBlockingStub.paymentFail(request);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
