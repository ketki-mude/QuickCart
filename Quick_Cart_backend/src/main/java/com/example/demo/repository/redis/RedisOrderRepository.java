package com.example.demo.repository.redis;

import com.example.demo.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface RedisOrderRepository extends CrudRepository<Order, String> {
    // Custom methods for Redis caching (if needed)
}
