package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;
import java.util.List;

@RedisHash("User") // For Redis
@Document(collection = "users") // For MongoDB

//define structure of user data

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    @Indexed(unique = true) // Ensure email is unique
    private String email;
    private String password; // For registered users, hash before storing
    private boolean isRegistered; // true for "registered", false for "guest"
    private List<CartItem> cart; // List of cart items

    // Constructors
    public User() {}

    public User(String id, String name, String email, String password, boolean isRegistered, List<CartItem> cart) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isRegistered = isRegistered;
        this.cart = cart;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    public List<CartItem> getCart() {
        return cart;
    }

    public void setCart(List<CartItem> cart) {
        this.cart = cart;
    }
}

class CartItem {
    private String productId;
    private int quantity;

    // Constructors
    public CartItem() {}

    public CartItem(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
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
}
