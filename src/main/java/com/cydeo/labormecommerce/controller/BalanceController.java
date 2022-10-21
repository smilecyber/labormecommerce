
package com.cydeo.labormecommerce.controller;

import com.cydeo.labormecommerce.dto.BalanceDTO;
import com.cydeo.labormecommerce.dto.DiscountDTO;
import com.cydeo.labormecommerce.model.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/balance")
public class BalanceController {

    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllBalance(){
        List<BalanceDTO> balanceDTOS = new ArrayList<>();
        return ResponseEntity.ok(new ResponseWrapper("Balances are successfully retrieved",balanceDTOS, HttpStatus.ACCEPTED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createBalance(@RequestBody BalanceDTO balanceDTO){
        return ResponseEntity.ok(new ResponseWrapper("Balance is created",balanceDTO, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateBalance(@RequestBody BalanceDTO discountDTO){
        return ResponseEntity.ok(new ResponseWrapper("Balance is updated",discountDTO, HttpStatus.CREATED));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper> getBalanceByCustomerId(@PathVariable("id") String id){
        return ResponseEntity.ok(new ResponseWrapper("Balance is successfully retrieved",new DiscountDTO(),HttpStatus.OK));

    }


}
