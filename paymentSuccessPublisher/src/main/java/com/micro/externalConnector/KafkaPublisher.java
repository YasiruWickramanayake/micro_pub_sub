package com.micro.externalConnector;

import com.micro.payment.PaymentSuccessMessage;

public interface KafkaPublisher {
    public void publishThePaymentSuccessMessage(PaymentSuccessMessage paymentSuccessMessage);

}
