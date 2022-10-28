package com.cydeo.labormecommerce.repository;

import com.cydeo.labormecommerce.enums.CartState;
import com.cydeo.labormecommerce.model.Cart;
import com.cydeo.labormecommerce.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    int countByCart_CartStateAndProduct_Name(CartState cartState, String name);

    @Query(value = "select ci.* from cart_item ci join product p on p.id = ci.product_id" +
            " join cart c on c.id = ci.cart_id where p.id = ?1 and c.cart_state = ?2", nativeQuery = true)
    List<CartItem> retriveCartItemThatSold(Long productId, String cartState);


    @Query(value = "select ci.* from cart_item ci join product p on p.id = ci.product_id" +
            " join cart c on c.id = ci.cart_id where p.id = ?1 and c.cart_state = ?2 and c.discount_id is null", nativeQuery = true)
    List<CartItem> retriveCartItemThatSoldWithOutDiscount(Long productId, String cartState);

}
