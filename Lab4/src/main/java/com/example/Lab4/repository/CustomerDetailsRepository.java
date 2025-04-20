package com.example.Lab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Lab4.entity.CustomerDetails;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long>{

}
