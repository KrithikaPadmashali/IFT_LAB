package com.example.lab56_p.repository;

import com.example.lab56_p.entity.CustomerName;

import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerNameRepository extends JpaRepository<CustomerName, Long> {

}
