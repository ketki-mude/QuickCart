package com.example.demo.repository.mongo;

import com.example.demo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    // Find products by category or subcategory
    Iterable<Product> findByCategory(String categoryId);
    Iterable<Product> findBySubcategory(String subcategoryId);
}
