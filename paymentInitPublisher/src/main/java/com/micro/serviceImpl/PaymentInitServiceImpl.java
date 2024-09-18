package com.micro.serviceImpl;

import com.micro.externalConnector.KafkaPublisher;
import com.micro.payment.PaymentInitiationMessage;
import com.micro.paymentService.PaymentInitiateRequest;
import com.micro.service.PaymentInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentInitServiceImpl implements PaymentInitService {

    @Autowired
    private KafkaPublisher kafkaPublisher;

    @Override
    public void processPaymentInitiate(PaymentInitiateRequest request) {
        try{
            PaymentInitiationMessage paymentInitiationMessage = PaymentInitiationMessage.builder()
                    .sagaId(request.getSagaId())
                    .customerId(request.getCustomerId())
                    .payableAmount(request.getPayableAmount())
                    .build();
            kafkaPublisher.publishPaymentInitiateMessage(paymentInitiationMessage);
        }catch (Exception ex){

        }
    }
}
