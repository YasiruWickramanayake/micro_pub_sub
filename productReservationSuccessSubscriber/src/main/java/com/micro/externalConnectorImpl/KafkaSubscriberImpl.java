package com.micro.externalConnectorImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.product.ProductReserveSuccessMessage;
import com.micro.service.ProductReservationSuccessService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaSubscriberImpl {
    @Autowired
    private ProductReservationSuccessService productReservationSuccessService;

    @KafkaListener(topics = "item-reservation-success")
    public void itemReservationSuccessMessage(ConsumerRecord<String, String> record) {
        System.out.println("Received message: " + record.value());
        ObjectMapper ob = new ObjectMapper();
        try {
            ProductReserveSuccessMessage productReservationSuccessMessage = ob.readValue(record.value(), ProductReserveSuccessMessage.class);
            productReservationSuccessService.sendMessageToOrderService(productReservationSuccessMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
