package com.micro.serviceImpl;

import com.micro.externalConnector.OrderServiceHandler;
import com.micro.product.ProductReserveFailMessage;
import com.micro.productService.ProductReserveFailRequest;
import com.micro.service.ProductReservationFailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductReservationFailServiceImpl implements ProductReservationFailService {

    @Autowired
    private OrderServiceHandler orderServiceHandler;
    @Override
    public void processProductReservationFailMessage(ProductReserveFailMessage productReserveFailMessage) {
        try{
            ProductReserveFailRequest productReserveFailRequest = ProductReserveFailRequest.newBuilder()
                    .setSagaId(productReserveFailMessage.getSagaId())
                    .build();
            orderServiceHandler.sendProductReservationFailMessage(productReserveFailRequest);
        }catch (Exception ex){

        }
    }
}
