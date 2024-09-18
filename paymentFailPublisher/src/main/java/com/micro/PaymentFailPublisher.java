package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentFailPublisher {
    public static void main(String[] args) {
        SpringApplication.run(PaymentFailPublisher.class, args);
    }
}