package com.alibou.ecommerce.kafka;

import com.alibou.ecommerce.customer.CustomerResponse;
import com.alibou.ecommerce.order.PaymentMethod;
import com.alibou.ecommerce.order.PurchaseResponse;
import org.apache.kafka.common.protocol.types.Field;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod orderPaymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
