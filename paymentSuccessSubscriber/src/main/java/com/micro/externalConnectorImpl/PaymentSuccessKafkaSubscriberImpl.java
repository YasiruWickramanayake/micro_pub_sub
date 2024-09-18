package com.micro.externalConnectorImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.extrenalConnector.OrderServiceHandler;
import com.micro.payment.PaymentSuccessMessage;
import com.micro.service.PaymentSuccessService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentSuccessKafkaSubscriberImpl {

    @Autowired
    private PaymentSuccessService paymentSuccessService;

    @KafkaListener(topics = "payment-success")
    public void paymentSuccessMessage(ConsumerRecord<String, String> record) {
        System.out.println("Received message: " + record.value());
        ObjectMapper ob = new ObjectMapper();
        try {
            PaymentSuccessMessage paymentSuccessMessage = ob.readValue(record.value(), PaymentSuccessMessage.class);
            paymentSuccessService.processPaymentSuccessMessage(paymentSuccessMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
