package com.caioneves.challenge_anota_ai.services;

import com.caioneves.challenge_anota_ai.domain.category.Category;
import com.caioneves.challenge_anota_ai.domain.category.CategoryDTO;
import com.caioneves.challenge_anota_ai.domain.category.exceptions.CategoryNotFoundException;
import com.caioneves.challenge_anota_ai.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository repository) {
        this.categoryRepository = repository;
    }

    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    public Category create(CategoryDTO categoryData) {
        Category newCategory = new Category(categoryData);

        this.categoryRepository.save(newCategory);

        return newCategory;
    }


    public Category update(String id, CategoryDTO categoryData) {
        Category category = this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);

        if(!categoryData.title().isEmpty()) category.setTitle(categoryData.title());
        if(!categoryData.description().isEmpty()) category.setDescription(categoryData.description());

        this.categoryRepository.save(category);

        return category;
    }

    public void delete(String id) {
        Category category = this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);

        this.categoryRepository.delete(category);
    }
}
