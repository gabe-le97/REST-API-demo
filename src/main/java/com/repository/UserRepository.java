package com.repository;

import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByUsername(String username);
    public List<User> findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
    public List<User> findByAge(Integer age);
    public List<User> findByCountry(String country);
}
