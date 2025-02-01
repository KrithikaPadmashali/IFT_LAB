package com.example.new3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.new3.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {
}