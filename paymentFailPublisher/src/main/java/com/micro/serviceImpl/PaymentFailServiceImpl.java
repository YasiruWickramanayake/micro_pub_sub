package com.micro.serviceImpl;

import com.micro.externalConnector.PaymentFailKafkaPublisher;
import com.micro.payment.PaymentFailMessage;
import com.micro.paymentService.PaymentFailRequest;
import com.micro.service.PaymentFailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentFailServiceImpl implements PaymentFailService {

    @Autowired
    private PaymentFailKafkaPublisher paymentFailKafkaPublisher;

    @Override
    public void processPaymentFailMessage(PaymentFailRequest request) {
        try {
            PaymentFailMessage paymentFailMessage = PaymentFailMessage.builder()
                    .sagaId(request.getSagaId())
                    .build();
            paymentFailKafkaPublisher.publishKafkaMessage(paymentFailMessage);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
