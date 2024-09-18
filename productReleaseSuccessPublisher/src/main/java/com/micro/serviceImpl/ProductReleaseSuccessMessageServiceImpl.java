package com.micro.serviceImpl;

import com.micro.externalConnector.ProductReleaseSuccessKafkaPublisher;
import com.micro.product.ItemReleaseSuccessMessage;
import com.micro.productService.ProductReleaseInitRequest;
import com.micro.productService.ProductReleaseSuccessRequest;
import com.micro.service.ProductReleaseSuccessMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductReleaseSuccessMessageServiceImpl implements ProductReleaseSuccessMessageService {

    @Autowired
    private ProductReleaseSuccessKafkaPublisher productReleaseSuccessKafkaPublisher;
    @Override
    public void processProductReleaseSuccessMessage(ProductReleaseSuccessRequest request) {
        try{
            ItemReleaseSuccessMessage itemReleaseSuccessMessage = ItemReleaseSuccessMessage.builder()
                    .sagaId(request.getSagaId())
                    .build();
            productReleaseSuccessKafkaPublisher.itemReleaseSuccessMessagePublish(itemReleaseSuccessMessage);
        }catch (RuntimeException ex){
            throw ex;
        }
    }
}
