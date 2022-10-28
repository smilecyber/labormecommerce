package com.cydeo.labormecommerce.repository;

import com.cydeo.labormecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    Customer findCustomerById(Long id);

    Customer findCustomerByEmail(String email);

}
