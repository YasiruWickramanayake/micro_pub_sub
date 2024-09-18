package com.micro.payment;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentSuccessMessage {
    private String sagaId;
}
