package com.micro.externalConnectorImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.externalConnector.KafkaPublisher;
import com.micro.payment.PaymentInitiationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaPublisherImpl implements KafkaPublisher {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Override
    public void publishPaymentInitiateMessage(PaymentInitiationMessage paymentInitiationMessage) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonMessage = objectMapper.writeValueAsString(paymentInitiationMessage);
            System.out.println("publish payment init message :" + jsonMessage);
            kafkaTemplate.send("init-payment", jsonMessage);
        }catch (Exception ex){}
    }
}
