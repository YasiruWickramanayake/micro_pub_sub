package com.micro.productReserveInitPublisher.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductReservationPublisherException extends RuntimeException{

    private int errorCode;
    private String message;
}
