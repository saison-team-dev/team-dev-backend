package com.example.chinaornotbackend.service;

import com.example.chinaornotbackend.model.User;

public interface UserService {
  Long createUser(User user);

  User getUserByid(Long userId);
}
