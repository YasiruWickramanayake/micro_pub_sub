package com.micro.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductReleaseInitMessage {
    @JsonProperty(value = "sagaId")
    private String sagaId;

}
