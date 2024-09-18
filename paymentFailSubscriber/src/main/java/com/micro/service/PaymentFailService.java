package com.micro.service;

import com.micro.payment.PaymentFailMessage;

public interface PaymentFailService {

    public void processPaymentFailService(PaymentFailMessage paymentFailMessage);
}
