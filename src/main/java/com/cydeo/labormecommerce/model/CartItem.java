package com.cydeo.labormecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class CartItem {
    @Id
    private Long id;
    @ManyToOne
    private Product product;
    private Integer quantity;
    @ManyToOne
    private Cart cart;
}
