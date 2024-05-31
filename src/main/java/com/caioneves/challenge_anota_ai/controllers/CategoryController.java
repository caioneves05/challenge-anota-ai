package com.caioneves.challenge_anota_ai.controllers;

import com.caioneves.challenge_anota_ai.domain.category.Category;
import com.caioneves.challenge_anota_ai.domain.category.CategoryDTO;
import com.caioneves.challenge_anota_ai.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDTO categoryData) {
        Category newCategory = this.service.create(categoryData);

        return ResponseEntity.ok().body(newCategory);
    };
}
