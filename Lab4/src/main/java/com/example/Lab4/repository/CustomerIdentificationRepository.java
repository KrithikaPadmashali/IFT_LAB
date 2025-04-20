package com.example.Lab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Lab4.entity.CustomerIdentification;

public interface CustomerIdentificationRepository extends JpaRepository<CustomerIdentification, Long>{
	
}
