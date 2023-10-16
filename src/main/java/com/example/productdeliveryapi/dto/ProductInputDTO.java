package com.example.productdeliveryapi.dto;

import java.math.BigDecimal;

public record ProductInputDTO(
        String name,
        BigDecimal price

) {
}
