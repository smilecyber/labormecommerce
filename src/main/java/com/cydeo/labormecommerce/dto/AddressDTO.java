package com.cydeo.labormecommerce.dto;

import com.cydeo.labormecommerce.entity.BaseEntity;
import com.cydeo.labormecommerce.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class AddressDTO{
    private Long id;
    private String name;
    private String zipCode;
    private String street;
    private Long customerId;
}
