package com.micro.serviceImpl;

import com.micro.externalConnector.PaymentServiceHandler;
import com.micro.payment.PaymentInitiationMessage;
import com.micro.paymentService.PaymentInitiateRequest;
import com.micro.service.PaymentInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentInitServiceImpl implements PaymentInitService {

    @Autowired
    private PaymentServiceHandler paymentServiceHandler;

    @Override
    public void processPaymentInitMessage(PaymentInitiationMessage paymentInitiationMessage) {
        try {
            PaymentInitiateRequest paymentInitiateRequest = PaymentInitiateRequest.newBuilder()
                    .setSagaId(paymentInitiationMessage.getSagaId())
                    .setCustomerId(paymentInitiationMessage.getCustomerId())
                    .setPayableAmount(paymentInitiationMessage.getPayableAmount())
                    .build();
            paymentServiceHandler.sendThePaymentInitiateMessage(paymentInitiateRequest);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
