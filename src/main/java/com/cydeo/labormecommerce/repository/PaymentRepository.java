package com.cydeo.labormecommerce.repository;

import com.cydeo.labormecommerce.entity.Category;
import com.cydeo.labormecommerce.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
