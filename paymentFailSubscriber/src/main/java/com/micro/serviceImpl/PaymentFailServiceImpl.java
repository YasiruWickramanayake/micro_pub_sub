package com.micro.serviceImpl;

import com.micro.externalConnector.OrderServiceHandler;
import com.micro.payment.PaymentFailMessage;
import com.micro.paymentService.PaymentFailRequest;
import com.micro.service.PaymentFailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentFailServiceImpl implements PaymentFailService {

    @Autowired
    private OrderServiceHandler orderServiceHandler;

    @Override
    public void processPaymentFailService(PaymentFailMessage paymentFailMessage) {
        try {
            PaymentFailRequest paymentFailRequest = PaymentFailRequest.newBuilder()
                    .setSagaId(paymentFailMessage.getSagaId())
                    .build();
            orderServiceHandler.passMessageToOrderService(paymentFailRequest);
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }
}
