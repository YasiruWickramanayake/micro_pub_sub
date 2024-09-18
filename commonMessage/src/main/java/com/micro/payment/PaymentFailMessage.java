package com.micro.payment;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentFailMessage {
    private String sagaId;
}
