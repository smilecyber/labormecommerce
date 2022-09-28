package com.cydeo.labormecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class Product extends BaseEntity{
    private BigDecimal price;
    private Integer quantity;
    private Integer remainingQuantity;
    private String name;
    @ManyToMany
    @JoinTable(name = "product_category_rel",
            joinColumns = @JoinColumn(name="p_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id"))
    private List<Category> categoryList;

}
