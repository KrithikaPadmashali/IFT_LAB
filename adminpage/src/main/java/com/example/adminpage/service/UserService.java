package com.example.adminpage.service;



import com.example.adminpage.entity.User;
import com.example.adminpage.repository.UserRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Fetch a paginated list of users
    public Page<User> getPaginatedUsers(int page, int pageSize) {
        return userRepository.findAll(PageRequest.of(page, pageSize));
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Save a new user or update an existing user
    public void saveUser(@Valid User user) {
        userRepository.save(user);
    }
    
    // Get a user by ID (for updating existing records)
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    // Delete a user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
