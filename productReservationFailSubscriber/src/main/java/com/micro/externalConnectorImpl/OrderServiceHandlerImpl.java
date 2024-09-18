package com.micro.externalConnectorImpl;

import com.micro.externalConnector.OrderServiceHandler;
import com.micro.productService.ProductReserveFailRequest;
import com.micro.productService.ProductReserveFailResponse;
import com.micro.productService.ProductServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceHandlerImpl implements OrderServiceHandler {

    @GrpcClient("order-service")
    ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub;
    @Override
    public void sendProductReservationFailMessage(ProductReserveFailRequest productReserveFailRequest) {
        productServiceBlockingStub.productReserveFail(productReserveFailRequest)
    }
}
