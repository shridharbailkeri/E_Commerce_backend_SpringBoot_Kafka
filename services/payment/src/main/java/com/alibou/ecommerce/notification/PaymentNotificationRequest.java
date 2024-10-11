package com.alibou.ecommerce.notification;

import com.alibou.ecommerce.payment.PaymentMethod;
import org.apache.kafka.common.protocol.types.Field;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        // PaymentNotificationRequest and PaymentConfirmation should have attributes exactly same or you get de serialization error
        String paymentOrderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}
