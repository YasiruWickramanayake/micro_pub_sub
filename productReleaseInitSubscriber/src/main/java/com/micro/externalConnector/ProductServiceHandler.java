package com.micro.externalConnector;

import com.micro.product.ProductReleaseInitMessage;
import com.micro.productService.ProductReleaseInitRequest;

public interface ProductServiceHandler {

    public void sendMessageToProductService(ProductReleaseInitRequest productReleaseInitRequest);
}
