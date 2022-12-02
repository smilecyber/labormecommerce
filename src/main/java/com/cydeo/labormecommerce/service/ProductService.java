package com.cydeo.labormecommerce.service;

import com.cydeo.labormecommerce.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductDTO> retrieveProductList();

    List<ProductDTO> retrieveTop3Product();

    ProductDTO retrieveByName(String name);
    List<ProductDTO> retrieveByCategory(Long category);

    ProductDTO updateProduct(ProductDTO productDTO);

    ProductDTO createProduct(ProductDTO productDTO);

    Integer retriveByPrice(BigDecimal price);

    List<ProductDTO> retrieveProductListByPriceAndQuantity(BigDecimal price, Integer quantity);
    List<ProductDTO> retrieveProductListByCategoryListAndPrice(List<Long> categoryList, BigDecimal price);
}
