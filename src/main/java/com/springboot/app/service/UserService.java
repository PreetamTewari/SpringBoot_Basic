package com.springboot.app.service;

import com.springboot.app.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long userId);

    void deleteUserById(Long userId);
}
