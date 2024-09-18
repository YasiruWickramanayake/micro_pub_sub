package com.micro.externalConnector;

import com.micro.productService.ProductReserveSuccessRequest;

public interface ProductServiceHandler {

    public void sendProductReserveSuccessMessageToOrderService(ProductReserveSuccessRequest productReserveSuccessRequest);
}
