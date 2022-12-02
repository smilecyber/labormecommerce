package com.cydeo.labormecommerce.controller;

import com.cydeo.labormecommerce.dto.ProductDTO;
import com.cydeo.labormecommerce.dto.ProductRequest;
import com.cydeo.labormecommerce.model.ResponseWrapper;
import com.cydeo.labormecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(new ResponseWrapper("Product is created",productService.createProduct(productDTO), HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(new ResponseWrapper("Product is updated",productService.updateProduct(productDTO), HttpStatus.CREATED));
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllProjects(){
        List<ProductDTO> productDTOList = productService.retrieveProductList();
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved",productDTOList, HttpStatus.ACCEPTED));
    }

    @GetMapping("/top3")
    public ResponseEntity<ResponseWrapper> retrieveTop3ProductOrderByPrice(){
        List<ProductDTO> productDTOList = productService.retrieveTop3Product();
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved",productDTOList, HttpStatus.ACCEPTED));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getProductByName(@PathVariable("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("Project is successfully retrieved",productService.retrieveByName(name),HttpStatus.OK));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseWrapper> retrieveProductListByCategory(@PathVariable("id") Long categoryId){
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved",productService.retrieveByCategory(categoryId),HttpStatus.OK));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<ResponseWrapper> retrieveProductListByCategory(@PathVariable("price") BigDecimal price){
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved",productService.retriveByPrice(price),HttpStatus.OK));
    }

    @GetMapping("/price/{price}/quantity/{quantity}")
    public ResponseEntity<ResponseWrapper> retrieveProductListByPriceAndQuantity(@PathVariable("price") BigDecimal price,@PathVariable("quantity") Integer quantity){
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved",productService.retrieveProductListByPriceAndQuantity(price,quantity),HttpStatus.OK));
    }
    @PostMapping("/categoryandprice")
    public ResponseEntity<ResponseWrapper> retrieveProductListByCategoryListAndPrice(@RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved",productService.retrieveProductListByCategoryListAndPrice(productRequest.getCategoryList(),productRequest.getPrice()),HttpStatus.OK));
    }
}
