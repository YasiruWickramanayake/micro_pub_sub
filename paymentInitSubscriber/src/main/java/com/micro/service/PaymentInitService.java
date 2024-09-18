package com.micro.service;

import com.micro.payment.PaymentInitiationMessage;

public interface PaymentInitService {

    public void processPaymentInitMessage(PaymentInitiationMessage paymentInitiationMessage);
}
