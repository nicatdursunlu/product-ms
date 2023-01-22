package com.atl.academy.productms.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name can not be empty")
    private String name;

    @PositiveOrZero(message = "Count must be positive or zero")
    @NotNull(message = "Count can not be null")
    private Long count;

    @NotNull(message = "Price can not be null")
    @PositiveOrZero(message = "Price must be positive or zero")
    private BigDecimal price;
}
