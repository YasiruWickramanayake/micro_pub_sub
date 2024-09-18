package com.micro.externalConnector;

import com.micro.product.ProductReleaseInitMessage;

public interface ProductReleaseKafkaPublisher {

    public void publishProductReleaseInitMessage(ProductReleaseInitMessage productReleaseInitMessage);
}
