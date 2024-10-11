package com.alibou.ecommerce.payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepositors extends JpaRepository<Payment, Integer> {
}
