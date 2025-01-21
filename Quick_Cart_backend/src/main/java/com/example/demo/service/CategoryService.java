package com.example.demo.service;
import com.example.demo.model.Category;
import com.example.demo.repository.mongo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.redis.RedisCategoryRepository;
import java.util.Optional;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RedisCategoryRepository redisCategoryRepository;

    // Get all categories
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Get category by ID
    public Category getCategoryById(String id) {
        // Check Redis cache
        Optional<Category> cachedCategory = redisCategoryRepository.findById(id);
        if (cachedCategory.isPresent()) {
            return cachedCategory.get();
        }

        // Fetch from MongoDB if not in Redis
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            redisCategoryRepository.save(category); // Cache the category
        }

        return category;
    }

    // Get category by name
    public Category getCategoryByName(String name) {
        // Check Redis cache
        Optional<Category> cachedCategory = redisCategoryRepository.findById(name);
        if (cachedCategory.isPresent()) {
            return cachedCategory.get();
        }

        // Fetch from MongoDB if not in Redis
        Category category = categoryRepository.findByName(name);
        if (category != null) {
            redisCategoryRepository.save(category); // Cache the category
        }

        return category;
    }

    // Create or update category
    public String createCategory(Category category) {
        // Save to MongoDB
        categoryRepository.save(category);

        // Cache in Redis
        redisCategoryRepository.save(category);

        return "Category created successfully.";
    }
}