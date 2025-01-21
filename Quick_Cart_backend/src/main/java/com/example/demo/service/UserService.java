package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.mongo.MongoUserRepository;
import com.example.demo.repository.redis.RedisUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private RedisUserRepository redisUserRepository;

    @Autowired
    private MongoUserRepository mongoUserRepository;

    // Search user by email
    public User getUserByEmail(String email) {
        // Check Redis cache
        Optional<User> cachedUser = redisUserRepository.findById(email);
        if (cachedUser.isPresent()) {
            return cachedUser.get(); // Return user from Redis cache
        }

        // Check MongoDB if not found in Redis
        List<User> usersFromDb = mongoUserRepository.findByEmail(email);
        if (usersFromDb.size() > 1) {
            throw new IllegalStateException("Multiple users found with the same email: " + email);
        }

        if (!usersFromDb.isEmpty()) {
            User userFromDb = usersFromDb.get(0);
            // Cache the user in Redis for future requests
            redisUserRepository.save(userFromDb);
            return userFromDb;
        }

        return null; // Return null if no user is found
    }

    // Create a new user
    public String createUser(User user) {
        // Save to MongoDB
        mongoUserRepository.save(user);

        // Cache the user in Redis
        redisUserRepository.save(user);

        return "User created successfully.";
    }
}