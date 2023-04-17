package com.example.chinaornotbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chinaornotbackend.model.User;
import com.example.chinaornotbackend.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<Long> createUser(@RequestBody User user) {
    Long userId = userService.createUser(user);
    return new ResponseEntity<>(userId, HttpStatus.CREATED);
  }

  @GetMapping("/{user_id}")
  public ResponseEntity<User> getUserById(@PathVariable("user_id") Long userId) {
    User user = userService.getUserByid(userId);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }
}
