package com.micro.externalConnectorImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.externalConnector.ProductReleaseKafkaPublisher;
import com.micro.product.ProductReleaseInitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductReleaseKafkaPublisherImpl implements ProductReleaseKafkaPublisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Override
    public void publishProductReleaseInitMessage(ProductReleaseInitMessage productReleaseInitMessage) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonMessage = objectMapper.writeValueAsString(productReleaseInitMessage);
            kafkaTemplate.send("init-product-release", jsonMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
