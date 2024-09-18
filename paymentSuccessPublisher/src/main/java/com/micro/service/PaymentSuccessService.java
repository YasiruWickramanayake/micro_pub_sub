package com.micro.service;

import com.micro.payment.PaymentSuccessMessage;
import com.micro.paymentService.PaymentSuccessRequest;

public interface PaymentSuccessService {

    public void processPaymentSuccessMessage(PaymentSuccessRequest request);
}
