package com.micro.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentInitiationMessage {
    @JsonProperty(value = "sagaId")
    private String sagaId;
    @JsonProperty(value = "customerId")
    private Integer customerId;
    @JsonProperty(value = "payableAmount")
    private Double payableAmount;

}
