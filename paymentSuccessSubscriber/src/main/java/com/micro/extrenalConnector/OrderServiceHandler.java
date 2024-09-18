package com.micro.extrenalConnector;

import com.micro.paymentService.PaymentSuccessRequest;

public interface OrderServiceHandler {

    public void sendPaymentSuccessMessage(PaymentSuccessRequest request);
}
