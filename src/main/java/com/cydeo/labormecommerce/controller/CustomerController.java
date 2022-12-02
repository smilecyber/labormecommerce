package com.cydeo.labormecommerce.controller;

import com.cydeo.labormecommerce.dto.CustomerDTO;
import com.cydeo.labormecommerce.model.ResponseWrapper;
import com.cydeo.labormecommerce.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllProjects(){
        return ResponseEntity.ok(new ResponseWrapper("Customers are successfully retrieved",customerService.findAllCustomerList(), HttpStatus.ACCEPTED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createCustomer(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.ok(new ResponseWrapper("Customer is created",customerService.createCustomer(customerDTO), HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateCustomer(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.ok(new ResponseWrapper("Customer is updated",customerService.updateCustomer(customerDTO), HttpStatus.CREATED));
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResponseWrapper> getCustomerByName(@PathVariable("email") String email){
        return ResponseEntity.ok(new ResponseWrapper("Customer is successfully retrieved",customerService.retrieveByEmail(email),HttpStatus.OK));
    }


}
