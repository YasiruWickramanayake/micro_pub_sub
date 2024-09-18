package com.micro.productreservationinitsubscriber.externalConnector;

import com.micro.product.ProductionReservationInitiateMessage;

public interface ProductServiceHandler {

    public void sendMessageToProductService(ProductionReservationInitiateMessage productReservationRequest);
}
