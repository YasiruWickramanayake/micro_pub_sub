package com.micro.productreservationinitsubscriber.service;

import com.micro.product.ProductionReservationInitiateMessage;

public interface ProductReserveInitSubService {

    public void processProductReserveInitMessage(ProductionReservationInitiateMessage productionReservationInitiateMessage);
}
