package com.springboot.app.controller;

import com.springboot.app.entity.User;
import com.springboot.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @Autowired
    private UserService userService;
//    public UserController(UserService userService) {
//        super();
//        this.userService = userService;
//    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, user == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable("userId") Long userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

}
