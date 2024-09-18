package com.micro.serviceImpl;

import com.micro.externalConnector.ProductServiceHandler;
import com.micro.product.ProductReserveSuccessMessage;
import com.micro.productService.ProductReserveSuccessRequest;
import com.micro.service.ProductReservationSuccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductReservationSuccessServiceImpl implements ProductReservationSuccessService {
    @Autowired
    private ProductServiceHandler productServiceHandler;

    @Override
    public void sendMessageToOrderService(ProductReserveSuccessMessage productReserveSuccessMessage) {
        try{
            productServiceHandler.sendProductReserveSuccessMessageToOrderService(ProductReserveSuccessRequest
                    .newBuilder()
                    .setSagaId(productReserveSuccessMessage.getSagaId()).build());
        }catch (Exception ex){

        }
    }
}
