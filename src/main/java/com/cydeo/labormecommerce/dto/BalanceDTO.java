package com.cydeo.labormecommerce.dto;


import com.cydeo.labormecommerce.entity.BaseEntity;
import com.cydeo.labormecommerce.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Getter
@Setter
public class BalanceDTO{
    @OneToOne
    private Customer customer;
    private BigDecimal amount;
}
