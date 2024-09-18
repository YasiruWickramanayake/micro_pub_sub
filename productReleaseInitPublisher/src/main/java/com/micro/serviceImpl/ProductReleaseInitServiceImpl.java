package com.micro.serviceImpl;

import com.micro.externalConnector.ProductReleaseKafkaPublisher;
import com.micro.product.ProductReleaseInitMessage;
import com.micro.product.ReservedOrderItem;
import com.micro.productService.ProductReleaseInitRequest;
import com.micro.service.ProductReleaseInitiateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductReleaseInitServiceImpl implements ProductReleaseInitiateService {

    @Autowired
    private ProductReleaseKafkaPublisher productReleaseKafkaPublisher;
    @Override
    public void processReleaseProductInitiate(ProductReleaseInitRequest request) {
        try{
            ProductReleaseInitMessage productReleaseInitMessage = generateKafkaMessage(request);
            productReleaseKafkaPublisher.publishProductReleaseInitMessage(productReleaseInitMessage);
        }catch (RuntimeException ex){
            throw ex;
        }
    }


    private ProductReleaseInitMessage generateKafkaMessage(ProductReleaseInitRequest request){
        try{
            return ProductReleaseInitMessage.builder()
                    .sagaId(request.getSagaId())
                    .build();
        }catch (RuntimeException e){
            throw e;
        }
    }
}
