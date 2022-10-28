package com.cydeo.labormecommerce.repository;

import com.cydeo.labormecommerce.model.Category;
import com.cydeo.labormecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.sound.sampled.Port;
import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    int countProductByPriceGreaterThan(BigDecimal price);
    List<Product> findAllByQuantityIsGreaterThanEqual(int quantity);
    Product findFirstByName(String productName);
    List<Product> findProductByCategoryListContaining(Category category);
    @Query(value = "select * from product p where p.price > ?1 and p.remaining_quantity < ?2", nativeQuery = true)
    List<Product> retrieveProductListGreaterThanPriceAndLowerThanRemainingQuantity(BigDecimal price, int remainingQuantity);

    @Query(value = "select * from product p join product_category_rel pl on pl.p_id = p.id where pl.c_id = ?1", nativeQuery = true)
    List<Product> retrieveProductListByCategory(Long categoryId);

    @Query(value = "select * from product p join product_category_rel pl on pl.p_id = p.id where pl.c_id in(?1) " +
            " p.price > ?2", nativeQuery = true)
    List<Product> retrieveProductListByCategory(List<Long> categoryId, BigDecimal price);

}
