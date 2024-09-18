package com.micro.productReserveInitPublisher.util;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum ErrorCodes {
    PRODUCT_RESERVATION_INITIATE_MESSAGE_GENERATION_FAILED(500, "Failed the product reservation generation message"),
    PRODUCT_RESERVATION_MESSAGE_PUBLISH_ERROR_KAFKA(501, "Cannot publish the product for the kafka topic");
    private final int errorCode;
    private final String message;
}
