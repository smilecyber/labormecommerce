package com.cydeo.labormecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Address {
    @Id
    private String id;
    private String name;
    private String zipCode;
    private String street;
    @ManyToOne
    private Customer customer;
}
