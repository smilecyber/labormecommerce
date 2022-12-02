package com.cydeo.labormecommerce.dto;

import com.cydeo.labormecommerce.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProductRequest {
    private List<Long> categoryList;
    private BigDecimal price;
}
