package com.cydeo.labormecommerce.repository;

import com.cydeo.labormecommerce.enums.DiscountType;
import com.cydeo.labormecommerce.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
    Discount findDiscountByName(String name);
    List<Discount> findAllByDiscountGreaterThan(BigDecimal discount);
    Discount findDiscountByDiscountType(DiscountType discountType);

    @Query("select d from Discount d where d.discount between ?1 and ?2")
    List<Discount> retrieveDiscountListBetween(BigDecimal startAmount, BigDecimal endAmount);


}
