package com.micro.serviceImpl;

import com.micro.extrenalConnector.OrderServiceHandler;
import com.micro.payment.PaymentSuccessMessage;
import com.micro.paymentService.PaymentSuccessRequest;
import com.micro.service.PaymentSuccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentSuccessServiceImpl implements PaymentSuccessService {

    @Autowired
    private OrderServiceHandler orderServiceHandler;

    @Override
    public void processPaymentSuccessMessage(PaymentSuccessMessage paymentSuccessMessage) {
        try {
            PaymentSuccessRequest paymentSuccessRequest = PaymentSuccessRequest.newBuilder()
                    .setSagaId(paymentSuccessMessage.getSagaId())
                    .build();
            orderServiceHandler.sendPaymentSuccessMessage(paymentSuccessRequest);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
