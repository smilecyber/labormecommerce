package com.cydeo.labormecommerce.dto;

import com.cydeo.labormecommerce.entity.BaseEntity;
import com.cydeo.labormecommerce.entity.Cart;
import com.cydeo.labormecommerce.entity.Customer;
import com.cydeo.labormecommerce.entity.Payment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
public class OrderDTO {
    private Long cartId;
    private BigDecimal paidPrice;
    private BigDecimal totalPrice;
    private Long customerId;
    private Long paymentId;
    private Long id;
}
