package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get products by category ID
    @GetMapping("/category/{categoryId}")
    public Iterable<Product> getProductsByCategory(@PathVariable String categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    // Get products by subcategory ID
    @GetMapping("/subcategory/{subcategoryId}")
    public Iterable<Product> getProductsBySubcategory(@PathVariable String subcategoryId) {
        return productService.getProductsBySubcategory(subcategoryId);
    }

    // Create or update a product
//    @PostMapping
//    public String createProduct(@RequestBody Product product) {
//        return productService.createProduct(product);
//    }
}