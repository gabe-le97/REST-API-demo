package com.component;

import com.model.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
// Use when operations need to be executed in a transaction (when running against a database)
public class LoadUsersInDb implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Bimbus", "Boo", 1000, "USA");
        userRepository.save(user);

        user = new User("Plumpus", "Pook", -100000, "Antarctica");
        userRepository.save(user);

        user = new User("Jiggly", "Boof", 20, "Japan");
        userRepository.save(user);

        user = new User("Jiggly", "Boof", 20, "Japan");
        userRepository.save(user);
    }
}
