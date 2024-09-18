package com.micro.externalConnectorImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.micro.externalConnector.KafkaPublisher;
import com.micro.payment.PaymentSuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaPublisherImpl implements KafkaPublisher {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void publishThePaymentSuccessMessage(PaymentSuccessMessage paymentSuccessMessage) {
        try{
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = null;
            json = ow.writeValueAsString(paymentSuccessMessage);
            kafkaTemplate.send("payment-success", json);
        }catch (Exception ex){

        }
    }
}
