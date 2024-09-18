package com.micro.externalConnectorImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.micro.externalConnector.ProductReleaseSuccessKafkaPublisher;
import com.micro.product.ItemReleaseSuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductReleaseSuccessKafkaPublisherImpl implements ProductReleaseSuccessKafkaPublisher {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void itemReleaseSuccessMessagePublish(ItemReleaseSuccessMessage itemReleaseSuccessMessage) {
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = null;
            json = ow.writeValueAsString(itemReleaseSuccessMessage);
            kafkaTemplate.send("item-release-success", json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
