package com.cydeo.labormecommerce.service;

import com.cydeo.labormecommerce.dto.CustomerDTO;
import com.cydeo.labormecommerce.entity.Category;

import java.util.List;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> findAllCustomerList();

    CustomerDTO retrieveByEmail(String email);
}
