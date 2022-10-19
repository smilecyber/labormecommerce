package com.cydeo.labormecommerce.service.impl;

import com.cydeo.labormecommerce.dto.ProductDTO;
import com.cydeo.labormecommerce.entity.Product;
import com.cydeo.labormecommerce.mapper.MapperUtil;
import com.cydeo.labormecommerce.repository.ProductRepository;
import com.cydeo.labormecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final MapperUtil mapperUtil;

    public ProductServiceImpl(ProductRepository productRepository, MapperUtil mapperUtil) {
        this.productRepository = productRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<ProductDTO> retrieveProductList() {
        return productRepository.findAll().stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }
}
