package com.cydeo.labormecommerce.repository;

import com.cydeo.labormecommerce.model.Balance;
import com.cydeo.labormecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface BalanceRepository extends JpaRepository<Balance, Long> {

    boolean existsByCustomer(Customer customer);

    Balance findBalanceByCustomer(Customer customer);

    List<Balance> findAllByAmountGreaterThanEqual(BigDecimal amount);

    List<Balance> findAllByAmountLessThan(BigDecimal amount);
}
