package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.RedisHash;
import java.util.List;

@RedisHash("Order") // Enables Redis caching
@Document(collection = "orders") // For MongoDB
public class Order {
    @Id
    private String id;
    private String userId; // Reference to user ID
    private List<OrderItem> items; // List of order items
    private double total; // Total order amount
    private String status; // Order status (e.g., Placed, Shipped, Delivered)
    private String timestamp; // Order timestamp

    // Constructors
    public Order() {}

    public Order(String id, String userId, List<OrderItem> items, double total, String status, String timestamp) {
        this.id = id;
        this.userId = userId;
        this.items = items;
        this.total = total;
        this.status = status;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

class OrderItem {
    private String productId;
    private int quantity;
    private double price;

    // Constructors
    public OrderItem() {}

    public OrderItem(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
