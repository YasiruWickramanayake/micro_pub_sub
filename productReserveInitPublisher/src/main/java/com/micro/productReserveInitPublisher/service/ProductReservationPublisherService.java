package com.micro.productReserveInitPublisher.service;

import com.micro.orderService.ProductReservationInitRequest;

public interface ProductReservationPublisherService {

    public void initiateProductReservation(ProductReservationInitRequest request);
}
