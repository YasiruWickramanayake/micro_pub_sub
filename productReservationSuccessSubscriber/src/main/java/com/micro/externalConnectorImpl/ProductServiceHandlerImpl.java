package com.micro.externalConnectorImpl;

import com.micro.externalConnector.ProductServiceHandler;
import com.micro.productService.ProductReserveSuccessRequest;
import com.micro.productService.ProductReserveSuccessResponse;
import com.micro.productService.ProductServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceHandlerImpl implements ProductServiceHandler {
    @GrpcClient("order-service")
    ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub;

    @Override
    public void sendProductReserveSuccessMessageToOrderService(ProductReserveSuccessRequest productReserveSuccessRequest) {
        productServiceBlockingStub.productReserveSuccess(productReserveSuccessRequest)
    }
}
