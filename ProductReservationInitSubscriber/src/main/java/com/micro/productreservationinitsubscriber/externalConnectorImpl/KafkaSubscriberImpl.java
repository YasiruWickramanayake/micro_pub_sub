package com.micro.productreservationinitsubscriber.externalConnectorImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.product.ProductionReservationInitiateMessage;
import com.micro.productreservationinitsubscriber.service.ProductReserveInitSubService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaSubscriberImpl {
    @Autowired
    private ProductReserveInitSubService productReserveInitSubService;

    @KafkaListener(topics = "init-item-reservation")
    public void initiateItemReservationMessage(ConsumerRecord<String, String> record) {
        System.out.println("Received message: " + record.value());
        ObjectMapper ob = new ObjectMapper();
        try {
            ProductionReservationInitiateMessage productReservationRequest = ob.readValue(record.value(), ProductionReservationInitiateMessage.class);
            productReserveInitSubService.processProductReserveInitMessage(productReservationRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
