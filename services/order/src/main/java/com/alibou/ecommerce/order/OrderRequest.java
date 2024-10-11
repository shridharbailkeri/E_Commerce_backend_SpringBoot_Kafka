package com.alibou.ecommerce.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        Integer id,
        String reference,

        @Positive(message = "order amount should be positive")
        BigDecimal amount,

        @NotNull(message = "payment method should be precise")
        PaymentMethod paymentMethod,

        @Positive(message = "Customer ID must be a positive number")
        @NotNull(message = "customer should be present")
        Long customerId,
        @NotEmpty(message = "You should purchase atleast 1 product")
        List<PurchaseRequest> products
) {
}
