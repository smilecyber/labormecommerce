package com.cydeo.labormecommerce.controller;

import com.cydeo.labormecommerce.dto.CustomerDTO;
import com.cydeo.labormecommerce.dto.DiscountDTO;
import com.cydeo.labormecommerce.model.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {

    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllDiscount(){
        List<DiscountDTO> discountDTOS = new ArrayList<>();
        return ResponseEntity.ok(new ResponseWrapper("Discounts are successfully retrieved",discountDTOS, HttpStatus.ACCEPTED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createDiscount(@RequestBody DiscountDTO discountDTO){
        return ResponseEntity.ok(new ResponseWrapper("Discount is created",discountDTO, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateDiscount(@RequestBody DiscountDTO discountDTO){
        return ResponseEntity.ok(new ResponseWrapper("Discount is updated",discountDTO, HttpStatus.CREATED));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getDiscountByName(@PathVariable("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("Discount is successfully retrieved",new DiscountDTO(),HttpStatus.OK));

    }


}
