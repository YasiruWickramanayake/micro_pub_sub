package com.micro.serviceImpl;

import com.micro.externalConnector.KafkaPublisher;
import com.micro.product.ProductReserveFailMessage;
import com.micro.productService.ProductReserveFailRequest;
import com.micro.service.ProductReserveFailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductReserveFailServiceImpl implements ProductReserveFailService {

    @Autowired
    private KafkaPublisher kafkaPublisher;
    @Override
    public void processProductReserveFailMessage(ProductReserveFailRequest request) {
        try{
            ProductReserveFailMessage productReserveFailMessage =
                    ProductReserveFailMessage.builder().sagaId(request.getSagaId()).build();
            kafkaPublisher.publishProductReserveFailMessage(productReserveFailMessage);
        }catch (Exception ex){

        }
    }
}
