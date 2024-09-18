package com.micro.serviceImpl;

import com.micro.externalConnector.KafkaPublisher;
import com.micro.payment.PaymentSuccessMessage;
import com.micro.paymentService.PaymentSuccessRequest;
import com.micro.service.PaymentSuccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentSuccessServiceImpl implements PaymentSuccessService {

    @Autowired
    private KafkaPublisher kafkaPublisher;

    @Override
    public void processPaymentSuccessMessage(PaymentSuccessRequest request) {
        try{
           PaymentSuccessMessage paymentSuccessMessage = PaymentSuccessMessage.builder()
                   .sagaId(request.getSagaId())
                   .build();

            kafkaPublisher.publishThePaymentSuccessMessage(paymentSuccessMessage);
        }catch (Exception ex){

        }
    }
}
