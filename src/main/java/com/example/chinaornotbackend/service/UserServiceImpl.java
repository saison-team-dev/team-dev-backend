package com.example.chinaornotbackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chinaornotbackend.exception.UserNotFoundExeption;
import com.example.chinaornotbackend.model.User;
import com.example.chinaornotbackend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public Long createUser(User user) {
    User newUser = userRepository.save(user);
    return newUser.getId();
  }

  @Override
  public User getUserByid(Long userId) {
    Optional<User> user = userRepository.findById(userId);
    if (user.isPresent()) {
      return user.get();
    } else {
      throw new UserNotFoundExeption("ユーザーが見つかりませんでした。");
    }
  }
}
