package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentFailSubscriber {
    public static void main(String[] args) {
        SpringApplication.run(PaymentFailSubscriber.class, args);

    }
}