package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.mongo.OrderRepository;
import com.example.demo.repository.redis.RedisOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RedisOrderRepository redisOrderRepository;

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get orders by user ID
    public Iterable<Order> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    // Get order by ID (using Redis cache)
    public Order getOrderById(String id) {
        // Check Redis cache
        Optional<Order> cachedOrder = redisOrderRepository.findById(id);
        if (cachedOrder.isPresent()) {
            return cachedOrder.get();
        }

        // Fetch from MongoDB if not in Redis
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            redisOrderRepository.save(order); // Cache the order
        }

        return order;
    }

    // Create an order
    public String createOrder(Order order) {
        // Save to MongoDB
        orderRepository.save(order);

        // Cache in Redis
        redisOrderRepository.save(order);

        return "Order placed successfully.";
    }
}
