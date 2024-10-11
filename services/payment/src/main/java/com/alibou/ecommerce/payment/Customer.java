package com.alibou.ecommerce.payment;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        String id,
        @NotNull(message = "Firstname is required")
        String firstName,
        @NotNull(message = "Lastname is required")
        String lastName,
        @NotNull(message = "Email is required")
        @Email(message = "The customer Email is not correctly formatted")
        String email
) {

    // we used @Valid PaymentRequest  in payment controller
    // and PaymentRequest is a record and when you use a complex object a record or another class u need to mark THIS class as @Validated
    // when u use @Validated all the attributes that you include inside this record it will also be validated

}
