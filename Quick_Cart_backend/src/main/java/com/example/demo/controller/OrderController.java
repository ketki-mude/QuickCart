package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Get all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Get orders by user ID
    @GetMapping("/user/{userId}")
    public Iterable<Order> getOrdersByUserId(@PathVariable String userId) {
        return orderService.getOrdersByUserId(userId);
    }

    // Create a new order
    @PostMapping
    public String createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
}
