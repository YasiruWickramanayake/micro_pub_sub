package com.micro.externalConnector;


import com.micro.productService.ProductReleaseSuccessRequest;

public interface OrderServiceHandler {
    public void sendProductReleaseMessage(ProductReleaseSuccessRequest request);
}
