package com.micro.serviceImpl;

import com.micro.externalConnector.ProductReservationSuccessKafkaPublisher;
import com.micro.product.ProductReserveSuccessMessage;
import com.micro.productService.ProductReserveSuccessRequest;
import com.micro.service.ProductReserveSuccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductReserveSuccessServiceImpl implements ProductReserveSuccessService {
    @Autowired
    private ProductReservationSuccessKafkaPublisher productReservationSuccessKafkaPublisher;
    @Override
    public void processProductSuccess(ProductReserveSuccessRequest request) {
        try{
            productReservationSuccessKafkaPublisher.publishProductReservationSuccessMessage(ProductReserveSuccessMessage.builder()
                    .sagaId(request.getSagaId()).build());
        }catch (Exception ex){

        }
    }
}
