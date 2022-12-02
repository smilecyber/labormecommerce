package com.cydeo.labormecommerce.service;

import com.cydeo.labormecommerce.dto.DiscountDTO;
import com.cydeo.labormecommerce.dto.ProductDTO;
import com.cydeo.labormecommerce.entity.Discount;

import java.math.BigDecimal;
import java.util.List;

public interface DiscountService {

    List<DiscountDTO> retrieveDiscountList();

    DiscountDTO retrieveByName(String name);

    DiscountDTO updateDiscount(DiscountDTO discountDTO);

    DiscountDTO createDiscount(DiscountDTO discountDTO);
}
