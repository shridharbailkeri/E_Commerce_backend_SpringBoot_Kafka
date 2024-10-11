package com.alibou.ecommerce.product;

import com.alibou.ecommerce.category.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(

        Integer id,
        @NotNull(message = "product name is required")
        String name,
        @NotNull(message = "product description is required")
        String description,
        @Positive(message = "product quantity should be positive")
        double availableQuantity,
        @Positive(message = "product price should be positive")
        BigDecimal price,
        @NotNull(message = "product category is required")
        Integer categoryId

) {
}
