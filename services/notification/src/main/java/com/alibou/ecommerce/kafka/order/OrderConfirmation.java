package com.alibou.ecommerce.kafka.order;

import com.alibou.ecommerce.kafka.payment.PaymentMethod;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderConfirmation{

        private String orderReference;
        private BigDecimal totalAmount;
        private PaymentMethod orderPaymentMethod;
        @Embedded
        private Customer customer;
        @ElementCollection
        List<Product> products;
}
