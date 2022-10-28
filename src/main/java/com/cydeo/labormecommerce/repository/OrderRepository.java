package com.cydeo.labormecommerce.repository;

import com.cydeo.labormecommerce.enums.CartState;
import com.cydeo.labormecommerce.enums.PaymentMethod;
import com.cydeo.labormecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCustomer_Email(String email);
    List<Order> findAllByPayment_PaymentMethod(PaymentMethod paymentMethod);
    List<Order> findAllByCart_Customer_Email(String email);
    boolean existsByCustomer_Email(String email);

    @Query(value = "select o.* from orders o join cart c on c.id = o.cart_id " +
            " join cart_item ci on ci.cart_id = c.id " +
            " join product p on p.id = ci.product_id where p.name = ?1  ", nativeQuery = true)
    List<Order> retrieveOrdersByProductName(String name);

    @Query(value = "select o.* from orders o join cart c on c.id = o.cart_id " +
            " join cart_item ci on ci.cart_id = c.id " +
            " join product p on p.id = ci.product_id" +
            " join product_category_rel pl on pl.p_id = p.id where pl.c_id = ?1  ", nativeQuery = true)
    List<Order> retrieveOrdersByProductCategoryId(Long categoryId);

    @Query("select o from Order o where o.paidPrice = o.totalPrice")
    List<Order> retrieveOrdersPaidPriceAndTotalPriceAreEqual();
    @Query("select o from Order o join o.cart c join c.discount d where o.paidPrice <> o.totalPrice and d is not null")
    List<Order> retrieveOrdersPaidPriceAndTotalPriceAreNotEqualAndDiscountIsNull();

}
