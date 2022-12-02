
package com.cydeo.labormecommerce.controller;

import com.cydeo.labormecommerce.dto.AddressDTO;
import com.cydeo.labormecommerce.model.ResponseWrapper;
import com.cydeo.labormecommerce.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllAddress(){
        return ResponseEntity.ok(new ResponseWrapper("Address are successfully retrieved",addressService.findAllAddress(), HttpStatus.ACCEPTED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createAddress(@RequestBody AddressDTO addressDTO){
        return ResponseEntity.ok(new ResponseWrapper("Address is created",addressService.createAddress(addressDTO), HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateAddress(@RequestBody AddressDTO addressDTO){
        return ResponseEntity.ok(new ResponseWrapper("Address is updated",addressService.updateAddress(addressDTO), HttpStatus.CREATED));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ResponseWrapper> getAddressByCustomerId(@PathVariable("id") Long id){
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully retrieved",addressService.findAddressListByCustomer(id),HttpStatus.OK));
    }

    @GetMapping("/startsWith/{address}")
    public ResponseEntity<ResponseWrapper> getAddressByStartsWithAddress(@PathVariable("address") String address){
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully retrieved",addressService.findAddressListByStartsWith(address),HttpStatus.OK));
    }

    @GetMapping("/customer/{customerId}/name/{name}")
    public ResponseEntity<ResponseWrapper> getAddressByStartsWithAddress(@PathVariable("customerId") Long customerId,@PathVariable("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully retrieved",addressService.findAddressListByCustomerAndName(customerId, name),HttpStatus.OK));
    }


}
