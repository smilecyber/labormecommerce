package com.cydeo.labormecommerce.service.impl;

import com.cydeo.labormecommerce.entity.Category;
import com.cydeo.labormecommerce.repository.CategoryRepository;
import com.cydeo.labormecommerce.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
