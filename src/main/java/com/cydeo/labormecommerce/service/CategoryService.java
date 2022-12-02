package com.cydeo.labormecommerce.service;

import com.cydeo.labormecommerce.dto.ProductDTO;
import com.cydeo.labormecommerce.entity.Category;

import java.util.List;

public interface CategoryService {
    Category findById(Long id);
}
