package com.example.lab9.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Important for bulk operations

import com.example.lab9.entity.User;
import com.example.lab9.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserService.class); // Optional: for logging

    @Autowired // Inject the repository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Saves a list of users to the database in a single transaction.
     *
     * @param users The list of User entities to save.
     * @return The list of saved User entities (including generated IDs).
     */
    @Transactional // Ensures the entire operation succeeds or fails together
    public List<User> saveAllUsers(List<User> users) {
        try {
            List<User> savedUsers = userRepository.saveAll(users); // Use JpaRepository's saveAll for efficiency
            logger.info("Successfully saved {} users.", savedUsers.size()); // Optional logging
            return savedUsers;
        } catch (Exception e) {
            // Log the error (important for debugging bulk operations)
            logger.error("Error saving bulk users: {}", e.getMessage(), e);
            // Re-throw or handle as appropriate for your application's error strategy
            throw new RuntimeException("Failed to save bulk users: " + e.getMessage(), e);
        }
    }

    // You can keep the file processing method from Lab 9 if needed elsewhere
    // public List<String> processFile(MultipartFile file) { ... }
}