package com.service;

import com.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    // All methods public by default
    Page<User> findAll(Pageable pageable);

    Optional<User> findById(Long id);

    List<User> findByCriteria(String criteria, String searchItem);

    void addUser(User user);

    Optional<User> updateUser(User user);

    Optional<User> deleteUser(Long id);
}
