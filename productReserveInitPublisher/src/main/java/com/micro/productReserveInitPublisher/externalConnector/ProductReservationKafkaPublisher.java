package com.micro.productReserveInitPublisher.externalConnector;


import com.micro.product.ProductionReservationInitiateMessage;

public interface ProductReservationKafkaPublisher {

    public void publishProductInitiateKafkaMessage(ProductionReservationInitiateMessage productionReservationInitiateMessage);
}
