package com.micro.service;

import com.micro.product.ItemReleaseSuccessMessage;

public interface ProductReleaseSuccessMessageService {

    public void processProductReleaseSuccessMessage(ItemReleaseSuccessMessage productReleaseSuccessMessage);
}
