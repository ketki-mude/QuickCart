package com.example.demo.repository.redis;

import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisUserRepository extends CrudRepository<User, String> {
}
