package com.micro.externalConnector;

import com.micro.product.ItemReleaseSuccessMessage;

public interface ProductReleaseSuccessKafkaPublisher {

    public void itemReleaseSuccessMessagePublish(ItemReleaseSuccessMessage itemReleaseSuccessMessage);
}
