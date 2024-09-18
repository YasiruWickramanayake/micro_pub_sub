package com.micro.externalConnector;

import com.micro.productService.ProductReserveFailRequest;

public interface OrderServiceHandler {
    public void sendProductReservationFailMessage(ProductReserveFailRequest productReserveFailRequest);

}
