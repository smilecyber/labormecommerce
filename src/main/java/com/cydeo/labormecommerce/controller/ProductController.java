package com.cydeo.labormecommerce.controller;

import com.cydeo.labormecommerce.dto.ProductDTO;
import com.cydeo.labormecommerce.model.ResponseWrapper;
import com.cydeo.labormecommerce.repository.ProductRepository;
import lombok.Getter;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
/*
    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllProjects(){
        List<ProductDTO> productDTOList = new ArrayList<>();
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved",productDTOList, HttpStatus.ACCEPTED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(new ResponseWrapper("Product is created",productDTO, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(new ResponseWrapper("Product is updated",productDTO, HttpStatus.CREATED));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getProductByName(@PathVariable("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("Project is successfully retrieved",new ProductDTO(),HttpStatus.OK));

    }


 */
}
