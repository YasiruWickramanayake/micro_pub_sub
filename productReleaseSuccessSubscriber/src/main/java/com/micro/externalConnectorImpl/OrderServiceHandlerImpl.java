package com.micro.externalConnectorImpl;

import com.micro.externalConnector.OrderServiceHandler;
import com.micro.productService.ProductReleaseInitRequest;
import com.micro.productService.ProductReleaseSuccessRequest;
import com.micro.productService.ProductReleaseSuccessResponse;
import com.micro.productService.ProductServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceHandlerImpl implements OrderServiceHandler {

    @GrpcClient("order-service")
    ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub;
    @Override
    public void sendProductReleaseMessage(ProductReleaseSuccessRequest request) {
        try{
            ProductReleaseSuccessResponse productReleaseSuccessResponse =
                    productServiceBlockingStub.productReleaseSuccess(request);
        }catch (RuntimeException ex){
            throw ex;
        }
    }
}
