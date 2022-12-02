package com.cydeo.labormecommerce.service.impl;

import com.cydeo.labormecommerce.dto.OrderDTO;
import com.cydeo.labormecommerce.entity.Order;
import com.cydeo.labormecommerce.enums.PaymentMethod;
import com.cydeo.labormecommerce.mapper.MapperUtil;
import com.cydeo.labormecommerce.repository.CartRepository;
import com.cydeo.labormecommerce.repository.CustomerRepository;
import com.cydeo.labormecommerce.repository.OrderRepository;
import com.cydeo.labormecommerce.repository.PaymentRepository;
import com.cydeo.labormecommerce.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final PaymentRepository paymentRepository;
    private final CustomerRepository customerRepository;
    private final MapperUtil mapperUtil;

    public OrderServiceImpl(OrderRepository orderRepository, CartRepository cartRepository, PaymentRepository paymentRepository, CustomerRepository customerRepository, MapperUtil mapperUtil) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.paymentRepository = paymentRepository;
        this.customerRepository = customerRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO){
        Order order = new Order();
        order.setPaidPrice(orderDTO.getPaidPrice());
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setCustomer(customerRepository.findById(orderDTO.getCustomerId()).get());
        order.setPayment(paymentRepository.findById(orderDTO.getPaymentId()).get());
        order.setCart(cartRepository.findById(orderDTO.getCartId()).get());

        Order order1 = orderRepository.save(order);
        return mapperUtil.convert(order1, new OrderDTO());
    }
    @Override
    public OrderDTO update(OrderDTO orderDTO){
        Order order = new Order();
        order.setPaidPrice(orderDTO.getPaidPrice());
        order.setId(orderDTO.getId());
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setCustomer(customerRepository.findById(orderDTO.getCustomerId()).get());
        order.setPayment(paymentRepository.findById(orderDTO.getPaymentId()).get());
        order.setCart(cartRepository.findById(orderDTO.getCartId()).get());

        Order order1 = orderRepository.save(order);
        return mapperUtil.convert(order1, new OrderDTO());
    }

    @Override
    public List<OrderDTO> retrieveAll(){
        return orderRepository.findAll().stream().map(order -> mapperUtil.convert(order, new OrderDTO())).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> retrieveTop5ByTotalPrice(){
        return orderRepository.findTop5ByOrderByTotalPriceDesc().stream().map(order -> mapperUtil.convert(order, new OrderDTO())).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> retrieveOrderListByEmail(String email){
        return orderRepository.findAllByCustomer_Email(email).stream().map(order -> mapperUtil.convert(order, new OrderDTO())).collect(Collectors.toList());
    }
    @Override
    public List<OrderDTO> retrieveOrderListByPaymentMethod(PaymentMethod paymentMethod){
        return orderRepository.findAllByPayment_PaymentMethod(paymentMethod).stream().map(order -> mapperUtil.convert(order, new OrderDTO())).collect(Collectors.toList());
    }

    @Override
    public boolean existByCustomerEmail(String email){
        return orderRepository.existsByCustomer_email(email);
    }
}
