package com.example.Lab4.repository;

import com.example.Lab4.entity.CustomerContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerContactInformationRepository extends JpaRepository<CustomerContactInformation, Long> {
	
}