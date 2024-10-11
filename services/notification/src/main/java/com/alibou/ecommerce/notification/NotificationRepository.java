package com.alibou.ecommerce.notification;

import com.alibou.ecommerce.kafka.payment.PaymentConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
