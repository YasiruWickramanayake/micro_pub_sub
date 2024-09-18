package com.micro.externalConnectorImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.payment.PaymentInitiationMessage;
import com.micro.service.PaymentInitService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaSubscriberImpl {

    @Autowired
    private PaymentInitService paymentInitService;

    @KafkaListener(topics = "init-payment")
    public void paymentInitiateMessage(ConsumerRecord<String, String> record) {
        try {
            System.out.println("Received message: " + record.value());
            ObjectMapper ob = new ObjectMapper();
            PaymentInitiationMessage paymentRequest = ob.readValue(record.value(), PaymentInitiationMessage.class);
            paymentInitService.processPaymentInitMessage(paymentRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
