package com.example.new3.service;

import java.util.List;
import com.example.new3.entity.User;
import com.example.new3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
 @Autowired
 private UserRepository userRepository;
 public List<User> getAllUsers() {
 return userRepository.findAll();
 }
 public User saveUser(User user) {
 return userRepository.save(user);
 }
}
