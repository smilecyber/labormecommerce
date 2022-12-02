package com.cydeo.labormecommerce.service.impl;

import com.cydeo.labormecommerce.dto.CustomerDTO;
import com.cydeo.labormecommerce.entity.Customer;
import com.cydeo.labormecommerce.mapper.MapperUtil;
import com.cydeo.labormecommerce.repository.CustomerRepository;
import com.cydeo.labormecommerce.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final MapperUtil mapperUtil;

    public CustomerServiceImpl(CustomerRepository customerRepository, MapperUtil mapperUtil) {
        this.customerRepository = customerRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO){
        Customer customer = mapperUtil.convert(customerDTO, new Customer());
        Customer customer1 = customerRepository.save(customer);
        return mapperUtil.convert(customer1,new CustomerDTO());
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO){
        Customer customer = mapperUtil.convert(customerDTO, new Customer());
        Customer customer1 = customerRepository.save(customer);
        return mapperUtil.convert(customer1,new CustomerDTO());
    }

    @Override
    public List<CustomerDTO> findAllCustomerList(){
        return customerRepository.findAll().stream().map(customer -> mapperUtil.convert(customer, new CustomerDTO())).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO retrieveByEmail(String email){
        return mapperUtil.convert(customerRepository.retrieveByCustomerEmail(email), new CustomerDTO());
    }
}
