package com.micro.externalConnectorImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.micro.externalConnector.ProductReservationSuccessKafkaPublisher;
import com.micro.product.ProductReserveSuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductReservationSuccessKafkaPublisherImpl implements ProductReservationSuccessKafkaPublisher {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Override
    public void publishProductReservationSuccessMessage(ProductReserveSuccessMessage productReserveSuccessMessage) {
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = null;
            json = ow.writeValueAsString(productReserveSuccessMessage);
            kafkaTemplate.send("item-reservation-success", json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
