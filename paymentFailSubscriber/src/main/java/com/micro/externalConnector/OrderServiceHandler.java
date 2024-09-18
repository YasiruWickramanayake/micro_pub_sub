package com.micro.externalConnector;

import com.micro.paymentService.PaymentFailRequest;

public interface OrderServiceHandler {

    public void passMessageToOrderService(PaymentFailRequest request);
}
