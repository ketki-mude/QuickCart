package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import org.springframework.data.redis.core.RedisHash;
import java.util.List;

@RedisHash("Category") // Enables Redis caching for this entity
@Document(collection = "categories") // For MongoDB
public class Category implements Serializable {
    @Id
    private String id;
    private String name; // Category name (e.g., "Women")
    private List<Subcategory> subcategories; // List of subcategories

    // Constructors
    public Category() {}

    public Category(String id, String name, List<Subcategory> subcategories) {
        this.id = id;
        this.name = name;
        this.subcategories = subcategories;
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

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
}

class Subcategory {
    private String id;
    private String name;

    // Constructors
    public Subcategory() {}

    public Subcategory(String id, String name) {
        this.id = id;
        this.name = name;
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
}