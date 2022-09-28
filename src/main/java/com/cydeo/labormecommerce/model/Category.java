package com.cydeo.labormecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Category extends BaseEntity {
    private String name;
}
