package com.micro.externalConnectorImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.payment.PaymentFailMessage;
import com.micro.service.PaymentFailService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentFailKafkaSubscriberImpl {

    @Autowired
    private PaymentFailService paymentFailService;

    @KafkaListener(topics = "payment-fail")
    public void paymentFailMessage(ConsumerRecord<String, String> record) {
        System.out.println("Received message: " + record.value());
        ObjectMapper ob = new ObjectMapper();
        try {
            PaymentFailMessage paymentFailMessage = ob.readValue(record.value(), PaymentFailMessage.class);
            paymentFailService.processPaymentFailService(paymentFailMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
