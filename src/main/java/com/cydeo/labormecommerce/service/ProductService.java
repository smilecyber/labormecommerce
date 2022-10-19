package com.cydeo.labormecommerce.service;

import com.cydeo.labormecommerce.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> retrieveProductList();
}
