package com.alibou.ecommerce.kafka.order;

import jakarta.persistence.Embeddable;

@Embeddable
public record Customer(
        String customerId,
        String firstName,
        String lastName,
        String email
) {
}
