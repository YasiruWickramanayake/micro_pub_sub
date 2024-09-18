package com.micro.productreservationinitsubscriber.serviceImpl;

import com.micro.product.ProductionReservationInitiateMessage;
import com.micro.productreservationinitsubscriber.externalConnector.ProductServiceHandler;
import com.micro.productreservationinitsubscriber.service.ProductReserveInitSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductReserveInitSubServiceImpl implements ProductReserveInitSubService {

    @Autowired
    private ProductServiceHandler productServiceHandler;

    @Override
    public void processProductReserveInitMessage(ProductionReservationInitiateMessage productionReservationInitiateMessage) {
        try{
            productServiceHandler.sendMessageToProductService(productionReservationInitiateMessage);
        }catch (Exception ex){

        }
    }
}
