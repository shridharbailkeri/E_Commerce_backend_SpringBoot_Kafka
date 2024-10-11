package com.alibou.ecommerce.customer;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Validated
@Embeddable
public class Address {

    private String street;
    private String houseNumber;
    private String zipCode;

}
