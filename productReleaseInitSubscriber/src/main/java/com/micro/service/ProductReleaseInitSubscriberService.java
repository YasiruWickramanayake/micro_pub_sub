package com.micro.service;

import com.micro.product.ProductReleaseInitMessage;

public interface ProductReleaseInitSubscriberService {

    public void processProductReleaseInitMessage(ProductReleaseInitMessage productReleaseInitMessage);
}
