package com.micro.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductionReservationInitiateMessage {
    @JsonProperty(value = "sagaId")
    private String sagaId;
    @JsonProperty(value = "orderItems")
    private List<ReservedOrderItem> orderItems;
}
