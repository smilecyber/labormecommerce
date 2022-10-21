
package com.cydeo.labormecommerce.controller;

import com.cydeo.labormecommerce.dto.AddressDTO;
import com.cydeo.labormecommerce.dto.OrderDTO;
import com.cydeo.labormecommerce.entity.Order;
import com.cydeo.labormecommerce.model.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllOrders(){
        List<OrderDTO> orderDTOS = new ArrayList<>();
        return ResponseEntity.ok(new ResponseWrapper("Orders are successfully retrieved",orderDTOS, HttpStatus.ACCEPTED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(new ResponseWrapper("Order is created",orderDTO, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(new ResponseWrapper("Order is updated",orderDTO, HttpStatus.CREATED));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper> getOrderByCustomerId(@PathVariable("id") String id){
        return ResponseEntity.ok(new ResponseWrapper("Orders is successfully retrieved",new OrderDTO(),HttpStatus.OK));

    }


}
