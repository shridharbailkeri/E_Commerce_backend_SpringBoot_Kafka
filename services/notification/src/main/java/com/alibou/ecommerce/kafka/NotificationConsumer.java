package com.alibou.ecommerce.kafka;

import com.alibou.ecommerce.email.EmailService;
import com.alibou.ecommerce.kafka.order.OrderConfirmation;
import com.alibou.ecommerce.kafka.payment.PaymentConfirmation;
import com.alibou.ecommerce.notification.Notification;
import com.alibou.ecommerce.notification.NotificationRepository;
import com.alibou.ecommerce.notification.NotificationType;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    // consumer of my topics
    private final NotificationRepository repository;

    //private final EmailService emailService;
    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info(String.format("Consuming the message from payment-topic Topic:: %s", paymentConfirmation));
        repository.save(
                Notification.builder()
                        .type(NotificationType.PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );
        // to do send email
        //var customerName = paymentConfirmation.customerFirstName() + " " + paymentConfirmation.customerLastName();
        //emailService.sentPaymentSuccessEmail(
        //        paymentConfirmation.customerEmail(),
        //        customerName,
        //        paymentConfirmation.amount(),
        //        paymentConfirmation.paymentOrderReference()
        //);
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info(String.format("Consuming the message from order-topic Topic:: %s", orderConfirmation));
        repository.save(
                Notification.builder()
                        .type(NotificationType.ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );
        // to do send email
        //var customerName = orderConfirmation.getCustomer().firstName() + " " + orderConfirmation.getCustomer().lastName();
        //emailService.sentOrderConfirmationEmail(
        //        orderConfirmation.getCustomer().email(),
        //        customerName,
        //        orderConfirmation.getTotalAmount(),
        //        orderConfirmation.getOrderReference(),
        //        orderConfirmation.getProducts()
        //);
    }

}
