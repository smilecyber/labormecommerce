
package com.cydeo.labormecommerce.controller;

import com.cydeo.labormecommerce.dto.AddressDTO;
import com.cydeo.labormecommerce.dto.BalanceDTO;
import com.cydeo.labormecommerce.dto.DiscountDTO;
import com.cydeo.labormecommerce.model.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllAddress(){
        List<AddressDTO> addressDTOS = new ArrayList<>();
        return ResponseEntity.ok(new ResponseWrapper("Address are successfully retrieved",addressDTOS, HttpStatus.ACCEPTED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createAddress(@RequestBody AddressDTO addressDTO){
        return ResponseEntity.ok(new ResponseWrapper("Address is created",addressDTO, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateAddress(@RequestBody AddressDTO addressDTO){
        return ResponseEntity.ok(new ResponseWrapper("Address is updated",addressDTO, HttpStatus.CREATED));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper> getAddressByCustomerId(@PathVariable("id") String id){
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully retrieved",new AddressDTO(),HttpStatus.OK));

    }


}
