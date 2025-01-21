package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Get all categories
    @GetMapping
    public Iterable<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Get a single category by ID
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable String id) {
        return categoryService.getCategoryById(id);
    }

    // Get a single category by name
    @GetMapping("/search")
    public Category getCategoryByName(@RequestParam String name) {
        return categoryService.getCategoryByName(name);
    }

    // Create or update category
//    @PostMapping
//    public String createCategory(@RequestBody Category category) {
//        return categoryService.createCategory(category);
//    }
}
