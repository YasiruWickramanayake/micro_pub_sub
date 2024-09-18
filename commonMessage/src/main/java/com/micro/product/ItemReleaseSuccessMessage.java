package com.micro.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemReleaseSuccessMessage {
    @JsonProperty(value = "sagaId")
    private String sagaId;
}
