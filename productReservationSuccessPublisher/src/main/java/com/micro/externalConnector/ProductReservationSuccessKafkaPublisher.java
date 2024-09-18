package com.micro.externalConnector;

import com.micro.product.ProductReserveSuccessMessage;

public interface ProductReservationSuccessKafkaPublisher {

    public void publishProductReservationSuccessMessage(ProductReserveSuccessMessage productReserveSuccessMessage);
}
