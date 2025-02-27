package com.example.lab5_and_lab6.service.impl;

import com.example.lab5_and_lab6.service.CUST_NAMEService;
import com.example.lab5_and_lab6.entity.CUST_NAME;
import com.example.lab5_and_lab6.repository.CUST_NAMERepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



	
	@Service
	public class CUST_NAMEServiceimpl implements CUST_NAMEService {

	    @Autowired
	    private CUST_NAMERepository customerNameRepository;

	    @Override
	    public List<CUST_NAME> getAllCustomerNames() {
	        return customerNameRepository.findAll();
	    }

	    @Override
	    public Optional<CUST_NAME> getCustomerNameById(Long id) {
	        return customerNameRepository.findById(id);
	    }

	    @Override
	    public CUST_NAME createCustomerName(CUST_NAME customerName) {
	        return customerNameRepository.save(customerName);
	    }

	    @Override
	    public CUST_NAME updateCustomerName(Long id, CUST_NAME newCustomerName) {
	        return customerNameRepository.findById(id).map(customerName -> {
	            customerName.setFirstName(newCustomerName.getFirstName());
	            customerName.setMiddleName(newCustomerName.getMiddleName());
	            customerName.setLastName(newCustomerName.getLastName());
	            return customerNameRepository.save(customerName);
	        }).orElseThrow(() -> new RuntimeException("Customer name not found with id: " + id));
	    }

	    @Override
	    public void deleteCustomerName(Long id) {
	        customerNameRepository.findById(id).ifPresentOrElse(
	                customerNameRepository::delete,
	                () -> {
	                    throw new RuntimeException("Customer name not found with id: " + id);
	                });
	    }
	}


