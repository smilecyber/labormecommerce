package com.cydeo.labormecommerce.model;

import com.cydeo.labormecommerce.enums.CartState;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart extends BaseEntity{
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Discount discount;
    @Enumerated(EnumType.STRING)
    private CartState cartState;
}
