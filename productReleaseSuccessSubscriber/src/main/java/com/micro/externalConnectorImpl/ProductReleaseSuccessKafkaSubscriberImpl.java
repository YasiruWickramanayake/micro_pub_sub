package com.micro.externalConnectorImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.product.ItemReleaseSuccessMessage;
import com.micro.service.ProductReleaseSuccessMessageService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ProductReleaseSuccessKafkaSubscriberImpl {

    @Autowired
    private ProductReleaseSuccessMessageService productReleaseSuccessMessageService;

    @KafkaListener(topics = "item-release-success")
    public void itemReleaseSuccessMessage(ConsumerRecord<String, String> record) {
        System.out.println("Received message: " + record.value());
        ObjectMapper ob = new ObjectMapper();
        try {
            ItemReleaseSuccessMessage productReleaseSuccessMessage = ob.readValue(record.value(), ItemReleaseSuccessMessage.class);
            productReleaseSuccessMessageService.processProductReleaseSuccessMessage(productReleaseSuccessMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
