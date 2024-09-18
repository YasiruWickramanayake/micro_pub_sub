package com.micro.service;

import com.micro.productService.ProductReserveFailRequest;

public interface ProductReserveFailService {

    public void processProductReserveFailMessage(ProductReserveFailRequest request);
}
