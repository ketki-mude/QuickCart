package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.mongo.ProductRepository;
import com.example.demo.repository.redis.RedisProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RedisProductRepository redisProductRepository;

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID (using Redis cache)
    public Product getProductById(String id) {
        // Check Redis cache
        Optional<Product> cachedProduct = redisProductRepository.findById(id);
        if (cachedProduct.isPresent()) {
            return cachedProduct.get();
        }

        // Fetch from MongoDB if not in Redis
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            redisProductRepository.save(product); // Cache the product
        }

        return product;
    }

    // Get products by category
    public Iterable<Product> getProductsByCategory(String categoryId) {
        return productRepository.findByCategory(categoryId);
    }

    // Get products by subcategory
    public Iterable<Product> getProductsBySubcategory(String subcategoryId) {
        return productRepository.findBySubcategory(subcategoryId);
    }

    // Create or update product
    public String createProduct(Product product) {
        // Save to MongoDB
        productRepository.save(product);

        // Cache in Redis
        redisProductRepository.save(product);

        return "Product created successfully.";
    }
}