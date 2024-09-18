package com.micro.service;

import com.micro.paymentService.PaymentFailRequest;

public interface PaymentFailService {

    public void processPaymentFailMessage(PaymentFailRequest request);
}
