package com.caioneves.challenge_anota_ai.services;

import com.caioneves.challenge_anota_ai.domain.category.Category;
import com.caioneves.challenge_anota_ai.domain.category.CategoryDTO;
import com.caioneves.challenge_anota_ai.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository repository) {
        this.categoryRepository = repository;
    }

    public Category create(CategoryDTO categoryData) {
        Category newCategory = new Category(categoryData);

        this.categoryRepository.save(newCategory);

        return newCategory;
    }
}
