package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Product") // Enables Redis caching
@Document(collection = "products") // For MongoDB
public class Product {
    @Id
    private String id;
    private String name; // Product name
    private double price; // Product price
    private String description; // Product description
    private String category; // Reference to category ID
    private String subcategory; // Reference to subcategory ID
    private int stock; // Quantity available

    // Constructors
    public Product() {}

    public Product(String id, String name, double price, String description, String category, String subcategory, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.subcategory = subcategory;
        this.stock = stock;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
