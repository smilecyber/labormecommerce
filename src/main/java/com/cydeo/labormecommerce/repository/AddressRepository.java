package com.cydeo.labormecommerce.repository;

import com.cydeo.labormecommerce.model.Address;
import com.cydeo.labormecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByCustomer(Customer customer);

    List<Address> findAllByStreet(String street);
}
