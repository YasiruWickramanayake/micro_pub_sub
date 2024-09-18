package com.micro.serviceImpl;

import com.micro.externalConnector.ProductServiceHandler;
import com.micro.product.ProductReleaseInitMessage;
import com.micro.productService.ProductReleaseInitRequest;
import com.micro.service.ProductReleaseInitSubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductReleaseInitSubscriberServiceImpl implements ProductReleaseInitSubscriberService {

    @Autowired
    private ProductServiceHandler productServiceHandler;

    @Override
    public void processProductReleaseInitMessage(ProductReleaseInitMessage productReleaseInitMessage) {
        try {
            ProductReleaseInitRequest productReleaseInitRequest = ProductReleaseInitRequest.newBuilder()
                    .setSagaId(productReleaseInitMessage.getSagaId())
                    .build();
            productServiceHandler.sendMessageToProductService(productReleaseInitRequest);
        } catch (RuntimeException ex) {
            throw ex;
        }
    }
}
