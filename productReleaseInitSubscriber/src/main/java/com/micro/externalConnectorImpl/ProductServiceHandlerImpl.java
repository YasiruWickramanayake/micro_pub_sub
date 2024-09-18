package com.micro.externalConnectorImpl;

import com.micro.externalConnector.ProductServiceHandler;

import com.micro.productService.ProductReleaseInitRequest;
import com.micro.productService.ProductReleaseInitResponse;
import com.micro.productService.ProductServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceHandlerImpl implements ProductServiceHandler {

    @GrpcClient("product-service")
    ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub;

    @Override
    public void sendMessageToProductService(ProductReleaseInitRequest productReleaseInitRequest) {
        try{
            ProductReleaseInitResponse productReleaseInitResponse = productServiceBlockingStub.releaseReservedProduct(productReleaseInitRequest);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }
}
