package com.micro.externalConnectorImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.micro.externalConnector.PaymentFailKafkaPublisher;
import com.micro.payment.PaymentFailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentFailPublisherImpl implements PaymentFailKafkaPublisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Override
    public void publishKafkaMessage(PaymentFailMessage paymentFailMessage) {
        try{
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = null;
            json = ow.writeValueAsString(paymentFailMessage);
            kafkaTemplate.send("payment-fail", json);
        }catch (RuntimeException ex){
            throw ex;
        }catch (JsonProcessingException ex){
            throw new RuntimeException(ex);
        }
    }
}
