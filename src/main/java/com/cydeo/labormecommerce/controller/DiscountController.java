package com.cydeo.labormecommerce.controller;

import com.cydeo.labormecommerce.dto.DiscountDTO;
import com.cydeo.labormecommerce.model.ResponseWrapper;
import com.cydeo.labormecommerce.service.DiscountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllDiscount(){
        return ResponseEntity.ok(new ResponseWrapper("Discounts are successfully retrieved",discountService.retrieveDiscountList(), HttpStatus.ACCEPTED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createDiscount(@RequestBody DiscountDTO discountDTO){
        return ResponseEntity.ok(new ResponseWrapper("Discount is created",discountService.createDiscount(discountDTO), HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateDiscount(@RequestBody DiscountDTO discountDTO){
        return ResponseEntity.ok(new ResponseWrapper("Discount is updated",discountService.updateDiscount(discountDTO), HttpStatus.CREATED));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getDiscountByName(@PathVariable("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("Discount is successfully retrieved",discountService.retrieveByName(name),HttpStatus.OK));

    }


}
