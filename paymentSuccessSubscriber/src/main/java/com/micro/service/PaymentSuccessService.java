package com.micro.service;

import com.micro.payment.PaymentSuccessMessage;

public interface PaymentSuccessService {

    public void processPaymentSuccessMessage(PaymentSuccessMessage paymentSuccessMessage);
}
