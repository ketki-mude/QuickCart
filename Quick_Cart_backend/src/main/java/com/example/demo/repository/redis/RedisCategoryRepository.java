package com.example.demo.repository.redis;

import com.example.demo.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisCategoryRepository extends CrudRepository<Category, String> {
    // Custom methods for Redis caching (if needed)
}
