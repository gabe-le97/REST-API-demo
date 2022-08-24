package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> findAll(Pageable pageable) {
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<User> userOpt = userService.findById(id);

        if (userOpt.isPresent()) {
            return new ResponseEntity<>(userOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> findByCriteria(@RequestParam(name = "criteria", required = true) String criteria,
                                            @RequestParam(name = "searchItem", required = true) String searchItem) {
        return new ResponseEntity<List<User>>(userService.findByCriteria(criteria, searchItem), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Optional<User> optUser = userService.updateUser(user);

        if (optUser.isPresent()) {
            return new ResponseEntity<>(optUser.get(), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<User> optUser = userService.deleteUser(id);

        if (optUser.isPresent()) {
            return new ResponseEntity<>(optUser.get(), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
