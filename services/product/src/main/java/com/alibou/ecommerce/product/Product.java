package com.alibou.ecommerce.product;

import com.alibou.ecommerce.category.Category;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
