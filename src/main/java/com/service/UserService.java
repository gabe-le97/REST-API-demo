package com.service;

import com.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    // All methods public by default
    List<User> findAll();

    Optional<User> findById(Long id);

    void addUser(User user);

    Optional<User> updateUser(User user);

    Optional<User> deleteUser(Long id);
}
