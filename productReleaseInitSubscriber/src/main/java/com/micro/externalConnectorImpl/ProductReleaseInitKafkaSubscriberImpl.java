package com.micro.externalConnectorImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.product.ProductReleaseInitMessage;
import com.micro.service.ProductReleaseInitSubscriberService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ProductReleaseInitKafkaSubscriberImpl {

    @Autowired
    private ProductReleaseInitSubscriberService productReleaseInitSubscriberService;

    @KafkaListener(topics = "init-product-release")
    public void releaseItemMessage(ConsumerRecord<String, String> record) {
        System.out.println("Received message: " + record.value());
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ProductReleaseInitMessage itemReleaseRequestObject = objectMapper.readValue(record.value(), ProductReleaseInitMessage.class);
            productReleaseInitSubscriberService.processProductReleaseInitMessage(itemReleaseRequestObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
