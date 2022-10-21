package com.cydeo.labormecommerce.dto;

import com.cydeo.labormecommerce.entity.BaseEntity;
import com.cydeo.labormecommerce.entity.Customer;
import com.cydeo.labormecommerce.entity.Discount;
import com.cydeo.labormecommerce.enums.CartState;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class CartDTO extends BaseEntity {
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Discount discount;
    @Enumerated(EnumType.STRING)
    private CartState cartState;
}
