package com.example.lab9.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lab9.entity.User;
import org.springframework.stereotype.Repository; // Optional, but good practice

@Repository // Indicate that this is a Spring Data repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository provides methods like findAll(), findById(), save(), saveAll(), deleteById()
    // No need to add custom methods for bulk creation
}