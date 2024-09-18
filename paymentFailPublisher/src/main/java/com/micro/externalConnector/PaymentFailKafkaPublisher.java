package com.micro.externalConnector;

import com.micro.payment.PaymentFailMessage;

public interface PaymentFailKafkaPublisher {

    public void publishKafkaMessage(PaymentFailMessage paymentFailMessage);
}
