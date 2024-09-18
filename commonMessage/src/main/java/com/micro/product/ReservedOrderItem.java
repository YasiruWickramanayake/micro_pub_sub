package com.micro.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservedOrderItem {
    @JsonProperty(value = "productId")
    private Integer productId;
    @JsonProperty(value = "quantity")
    private Integer quantity;
    @JsonProperty(value = "amount")
    private Double amount;
}
