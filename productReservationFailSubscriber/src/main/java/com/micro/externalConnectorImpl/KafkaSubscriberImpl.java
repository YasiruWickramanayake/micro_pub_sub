package com.micro.externalConnectorImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.product.ProductReserveFailMessage;
import com.micro.service.ProductReservationFailService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaSubscriberImpl {

    @Autowired
    private ProductReservationFailService productReservationFailService;

    @KafkaListener(topics = "item-reservation-fail")
    public void itemReservationFailMessage(ConsumerRecord<String, String> record) {
        System.out.println("Received message: " + record.value());
        ObjectMapper ob = new ObjectMapper();
        try {
            ProductReserveFailMessage productReservationFailMessage = ob.readValue(record.value(), ProductReserveFailMessage.class);
            productReservationFailService.processProductReservationFailMessage(productReservationFailMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
