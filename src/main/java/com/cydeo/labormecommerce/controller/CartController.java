
package com.cydeo.labormecommerce.controller;

import com.cydeo.labormecommerce.dto.BalanceDTO;
import com.cydeo.labormecommerce.dto.CartDTO;
import com.cydeo.labormecommerce.dto.DiscountDTO;
import com.cydeo.labormecommerce.model.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllCarts(){
        List<CartDTO> cartDTOS = new ArrayList<>();
        return ResponseEntity.ok(new ResponseWrapper("Cart are successfully retrieved",cartDTOS, HttpStatus.ACCEPTED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createCart(@RequestBody CartDTO cartDTO){
        return ResponseEntity.ok(new ResponseWrapper("Cart is created",cartDTO, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateCart(@RequestBody CartDTO cartDTO){
        return ResponseEntity.ok(new ResponseWrapper("Cart is updated",cartDTO, HttpStatus.CREATED));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper> getCartByCustomerId(@PathVariable("id") String id){
        return ResponseEntity.ok(new ResponseWrapper("Cart is successfully retrieved",new CartDTO(),HttpStatus.OK));

    }


}
