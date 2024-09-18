package com.micro.externalConnector;

import com.micro.payment.PaymentInitiationMessage;

public interface KafkaPublisher {

    public void publishPaymentInitiateMessage(PaymentInitiationMessage paymentInitiationMessage);
}
