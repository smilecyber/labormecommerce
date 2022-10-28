package com.cydeo.labormecommerce.repository;

import com.cydeo.labormecommerce.enums.CartState;
import com.cydeo.labormecommerce.enums.DiscountType;
import com.cydeo.labormecommerce.model.Cart;
import com.cydeo.labormecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByDiscount_DiscountType(DiscountType discountType);
    List<Cart> findAllByCustomer(Customer customer);
    List<Cart> findAllByCustomerAndCartState(Customer customer, CartState cartState);
    List<Cart> findAllByCustomerAndDiscountIsNullAndCartState(Customer customer, CartState cartState);
    List<Cart> findAllByCartStateAndDiscountIsNotNull(CartState cartState);



}
