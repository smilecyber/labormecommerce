
package com.cydeo.labormecommerce.controller;

import com.cydeo.labormecommerce.dto.OrderDTO;
import com.cydeo.labormecommerce.enums.PaymentMethod;
import com.cydeo.labormecommerce.model.ResponseWrapper;
import com.cydeo.labormecommerce.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllOrders(){
        return ResponseEntity.ok(new ResponseWrapper("Orders are successfully retrieved",orderService.retrieveAll(), HttpStatus.ACCEPTED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(new ResponseWrapper("Order is created",orderService.create(orderDTO), HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(new ResponseWrapper("Order is updated",orderService.update(orderDTO), HttpStatus.CREATED));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseWrapper> getOrderByCustomerEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(new ResponseWrapper("Orders is successfully retrieved",orderService.retrieveOrderListByEmail(email),HttpStatus.OK));
    }

    @GetMapping("/paymentMethod/{paymentMethod}")
    public ResponseEntity<ResponseWrapper> getOrderByCustomerEmail(@PathVariable("paymentMethod") PaymentMethod paymentMethod){
        return ResponseEntity.ok(new ResponseWrapper("Orders is successfully retrieved",orderService.retrieveOrderListByPaymentMethod(paymentMethod),HttpStatus.OK));
    }

}
