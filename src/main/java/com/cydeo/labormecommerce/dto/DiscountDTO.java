package com.cydeo.labormecommerce.dto;

import com.cydeo.labormecommerce.entity.BaseEntity;
import com.cydeo.labormecommerce.enums.DiscountType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Getter
@Setter
public class DiscountDTO extends BaseEntity {
    private String name;
    private BigDecimal discount;
    private DiscountType discountType;
}
