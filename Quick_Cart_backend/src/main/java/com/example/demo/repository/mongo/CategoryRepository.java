package com.example.demo.repository.mongo;

import com.example.demo.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    // Custom query to find a category by name
    Category findByName(String name);
}
