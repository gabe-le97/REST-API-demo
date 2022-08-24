package com.component;

import com.model.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Transactional
// Use when operations need to be executed in a transaction (when running against a database)
public class LoadUsersInDb implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() > 0) {
            return;
        }

        User user1 = new User("BimbusB", UUID.randomUUID().toString(), "Bimbus", "Boo", 1000, "USA");
        userRepository.save(user1);

        User user2 = new User("PlumpusP", UUID.randomUUID().toString(), "Plumpus", "Pook", -100000, "Antarctica");
        userRepository.save(user2);

        User user3 = new User("JigglyB", UUID.randomUUID().toString(), "Jiggly", "Boof", 20, "Japan");
        userRepository.save(user3);

        User user4 = new User("CaptainD", UUID.randomUUID().toString(), "Captain", "Dook", 20, "Japan");
        userRepository.save(user4);

        List<User> userList = Arrays.asList(user1, user2, user3, user4);

        userList = userList.stream().peek(user -> user.setPassword(passwordEncoder.encode(user.getPassword()))).collect(Collectors.toList());
        userRepository.saveAll(userList);
    }
}
