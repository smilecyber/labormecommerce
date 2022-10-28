package com.cydeo.labormecommerce.repository;

import com.cydeo.labormecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findFirstByName(String name);
}
