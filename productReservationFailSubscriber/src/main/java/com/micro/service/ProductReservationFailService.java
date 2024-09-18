package com.micro.service;

import com.micro.product.ProductReserveFailMessage;

public interface ProductReservationFailService {

    public void processProductReservationFailMessage(ProductReserveFailMessage productReserveFailMessage);
}
