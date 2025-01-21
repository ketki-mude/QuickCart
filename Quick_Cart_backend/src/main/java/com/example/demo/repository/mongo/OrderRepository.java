package com.example.demo.repository.mongo;

import com.example.demo.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    // Find orders by user ID
    Iterable<Order> findByUserId(String userId);
}
