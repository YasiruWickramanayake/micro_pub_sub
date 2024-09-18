package com.micro.externalConnector;

import com.micro.paymentService.PaymentInitiateRequest;

public interface PaymentServiceHandler {

    public void sendThePaymentInitiateMessage(PaymentInitiateRequest paymentInitiateRequest);
}
