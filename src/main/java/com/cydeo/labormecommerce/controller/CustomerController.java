package com.cydeo.labormecommerce.controller;

import com.cydeo.labormecommerce.dto.CustomerDTO;
import com.cydeo.labormecommerce.model.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllProjects(){
        List<CustomerDTO> productDTOList = new ArrayList<>();
        return ResponseEntity.ok(new ResponseWrapper("Customers are successfully retrieved",productDTOList, HttpStatus.ACCEPTED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createCustomer(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.ok(new ResponseWrapper("Customer is created",customerDTO, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateCustomer(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.ok(new ResponseWrapper("Customer is updated",customerDTO, HttpStatus.CREATED));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getCustomerByName(@PathVariable("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("Customer is successfully retrieved",new CustomerDTO(),HttpStatus.OK));

    }


}
