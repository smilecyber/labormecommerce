package com.cydeo.labormecommerce.model;

import com.cydeo.labormecommerce.enums.DiscountType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Discount {
    @Id
    private Long id;
    private String name;
    private BigDecimal discount;
    @Enumerated(value = EnumType.STRING)
    private DiscountType discountType;
}
