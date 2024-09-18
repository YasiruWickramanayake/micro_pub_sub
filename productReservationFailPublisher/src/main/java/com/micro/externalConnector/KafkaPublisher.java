package com.micro.externalConnector;

import com.micro.product.ProductReserveFailMessage;

public interface KafkaPublisher {

    public void publishProductReserveFailMessage(ProductReserveFailMessage productReserveFailMessage);
}
