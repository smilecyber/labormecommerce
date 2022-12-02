package com.cydeo.labormecommerce.service.impl;

import com.cydeo.labormecommerce.dto.ProductDTO;
import com.cydeo.labormecommerce.entity.Category;
import com.cydeo.labormecommerce.entity.Product;
import com.cydeo.labormecommerce.mapper.MapperUtil;
import com.cydeo.labormecommerce.repository.ProductRepository;
import com.cydeo.labormecommerce.service.CategoryService;
import com.cydeo.labormecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final MapperUtil mapperUtil;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, MapperUtil mapperUtil) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<ProductDTO> retrieveProductList() {
        return productRepository.findAll().stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> retrieveTop3Product() {
        return productRepository.findTop3ByOrderByPriceDesc().stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public ProductDTO retrieveByName(String name) {
        return mapperUtil.convert( productRepository.findFirstByName(name), new ProductDTO());
    }

    @Override
    public List<ProductDTO> retrieveByCategory(Long categoryId) {
        Category category = categoryService.findById(categoryId);
        return productRepository.findAllByCategoryListContaining(category).stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO){
        Product product = mapperUtil.convert(productDTO, new Product());
        Product product1 = productRepository.save(product);

        return mapperUtil.convert(product1, new ProductDTO());
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO){
        Product product = mapperUtil.convert(productDTO, new Product());
        Product product1 = productRepository.save(product);

        return mapperUtil.convert(product1, new ProductDTO());
    }

    @Override
    public Integer retriveByPrice(BigDecimal price) {
        return productRepository.countProductByPriceGreaterThan(price);
    }

    @Override
    public List<ProductDTO> retrieveProductListByPriceAndQuantity(BigDecimal price, Integer quantity) {
        return productRepository.retrieveProductListGreaterThanPriceAndLowerThanRemainingQuantity(price, quantity).stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> retrieveProductListByCategoryListAndPrice(List<Long> categoryList, BigDecimal price) {
        return productRepository.retrieveProductListByCategory(categoryList,price).stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }
}
