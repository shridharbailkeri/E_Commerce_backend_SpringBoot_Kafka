package com.alibou.ecommerce.kafka.order;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;
@Embeddable
public record Product(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
