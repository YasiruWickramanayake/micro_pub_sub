package com.micro.serviceImpl;

import com.micro.externalConnector.OrderServiceHandler;
import com.micro.product.ItemReleaseSuccessMessage;
import com.micro.productService.ProductReleaseSuccessRequest;
import com.micro.service.ProductReleaseSuccessMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductReleaseSuccessMessageServiceImpl implements ProductReleaseSuccessMessageService {

    @Autowired
    private OrderServiceHandler orderServiceHandler;

    @Override
    public void processProductReleaseSuccessMessage(ItemReleaseSuccessMessage productReleaseSuccessMessage) {
        try {
            ProductReleaseSuccessRequest productReleaseSuccessRequest = ProductReleaseSuccessRequest.newBuilder()
                    .setSagaId(productReleaseSuccessMessage.getSagaId())
                    .build();
            orderServiceHandler.sendProductReleaseMessage(productReleaseSuccessRequest);
        } catch (RuntimeException ex) {
            throw ex;
        }
    }
}
