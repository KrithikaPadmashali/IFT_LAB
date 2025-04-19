package com.example.lab9.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.lab9.entity.User;
import com.example.lab9.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/customers") // Base path for this controller
public class CustomerController {

    @Autowired
    private UserService userService;

    /**
     * Endpoint to create multiple customers in bulk.
     * Expects a JSON array of User objects in the request body.
     * Example JSON body: [{"name": "Alice", "email": "alice@example.com"}, {"name": "Bob", "email": "bob@example.com"}]
     *
     * @param users List of users to create.
     * @return ResponseEntity with the list of created users or an error message.
     */
    @PostMapping // Maps HTTP POST requests to /customers
    public ResponseEntity<?> createBulkCustomers(@RequestBody List<User> users) {
        if (users == null || users.isEmpty()) {
            return ResponseEntity.badRequest().body("User list cannot be empty.");
        }
        try {
            List<User> savedUsers = userService.saveAllUsers(users);
            // Return 201 Created status with the list of created users
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUsers);
        } catch (Exception e) {
            // Return 500 Internal Server Error if something goes wrong during saving
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating bulk customers: " + e.getMessage());
        }
    }

    // You can add other endpoints here (GET, PUT, DELETE for single users) if needed
    // based on Labs 5 & 6 examples
}