package com.example.demo.repository.mongo;

import com.example.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MongoUserRepository extends MongoRepository<User, String> {
    List<User> findByEmail(String email);
}