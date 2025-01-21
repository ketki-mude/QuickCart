package com.example.demo.repository.redis;

import com.example.demo.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisProductRepository extends CrudRepository<Product, String> {
    // Custom methods for Redis caching (if needed)
}
