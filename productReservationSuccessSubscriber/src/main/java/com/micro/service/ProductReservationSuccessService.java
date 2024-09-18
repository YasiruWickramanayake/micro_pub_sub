package com.micro.service;

import com.micro.product.ProductReserveSuccessMessage;

public interface ProductReservationSuccessService {
    public void sendMessageToOrderService(ProductReserveSuccessMessage productReserveSuccessMessage);

}
