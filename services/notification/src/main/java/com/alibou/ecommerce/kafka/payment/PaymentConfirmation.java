package com.alibou.ecommerce.kafka.payment;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.math.BigDecimal;
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PaymentConfirmation{

    // PaymentNotificationRequest and PaymentConfirmation should have attributes exactly same or you get de serialization error
    String paymentOrderReference;
    BigDecimal amount;
    PaymentMethod paymentMethod;
    String customerFirstName;
    String customerLastName;
    String customerEmail;
}
