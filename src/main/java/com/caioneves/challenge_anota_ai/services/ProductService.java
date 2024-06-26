package com.caioneves.challenge_anota_ai.services;

import com.caioneves.challenge_anota_ai.domain.category.Category;
import com.caioneves.challenge_anota_ai.domain.category.exceptions.CategoryNotFoundException;
import com.caioneves.challenge_anota_ai.domain.product.ProductDTO;
import com.caioneves.challenge_anota_ai.domain.product.exceptions.ProductNotFoundException;
import com.caioneves.challenge_anota_ai.domain.product.Product;
import com.caioneves.challenge_anota_ai.repositories.CategoryRepository;
import com.caioneves.challenge_anota_ai.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService ) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    public Product create(ProductDTO productData) {
        Category category = this.categoryService.getById(productData.categoryId()).orElseThrow(CategoryNotFoundException::new);

        Product newProduct = new Product(productData);
        newProduct.setCategory(category);
        this.productRepository.save(newProduct);

        return newProduct;
    }


    public Product update(String id, ProductDTO productData) {
        Product product = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);

        if(productData.categoryId() != null) {
            this.categoryService.getById(productData.categoryId()).ifPresent(product::setCategory);
        }

        if(!productData.title().isEmpty()) product.setTitle(productData.title());
        if(!productData.description().isEmpty()) product.setDescription(productData.description());
        if(!(productData.price() == null)) product.setPrice(productData.price());

        this.productRepository.save(product);

        return product;
    }

    public void delete(String id) {
        Product product = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);

        this.productRepository.delete(product);
    }
}
