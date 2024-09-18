package com.micro.service;


import com.micro.paymentService.PaymentInitiateRequest;

public interface PaymentInitService {

    public void processPaymentInitiate(PaymentInitiateRequest request);
}
