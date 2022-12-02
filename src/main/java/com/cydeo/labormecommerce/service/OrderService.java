package com.cydeo.labormecommerce.service;

import com.cydeo.labormecommerce.dto.OrderDTO;
import com.cydeo.labormecommerce.entity.Category;
import com.cydeo.labormecommerce.enums.PaymentMethod;

import java.util.List;

public interface OrderService {
    OrderDTO create(OrderDTO orderDTO);

    OrderDTO update(OrderDTO orderDTO);

    List<OrderDTO> retrieveAll();

    List<OrderDTO> retrieveTop5ByTotalPrice();

    List<OrderDTO> retrieveOrderListByEmail(String email);

    List<OrderDTO> retrieveOrderListByPaymentMethod(PaymentMethod paymentMethod);

    boolean existByCustomerEmail(String email);
}
