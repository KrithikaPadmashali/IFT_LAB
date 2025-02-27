package com.example.lab5_and_lab6.controller;


import com.example.lab5_and_lab6.entity.CUST_ID;
import com.example.lab5_and_lab6.service.CUST_IDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/customer-identification")
public class CUST_IDController {
	
	 @Autowired
	 private CUST_IDService customerIdentificationService;
	 
	 @GetMapping
	 public List<CUST_ID> getAllCustomerIdentifications() {
		 return customerIdentificationService.getAllCustomerIdentifications();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<CUST_ID> getCustomerIdentificationById(@PathVariable Long id) {
		 return customerIdentificationService.getCustomerIdentificationById(id)
				 .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
				 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 }
	 
	 @PostMapping
	 public ResponseEntity<CUST_ID> createCustomerIdentification(@RequestBody CUST_ID newCustomerIdentification) {
		 CUST_ID savedCustomerIdentification = customerIdentificationService.createCustomerIdentification(newCustomerIdentification);
	 	return new ResponseEntity<>(savedCustomerIdentification, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<CUST_ID> updateCustomerIdentification(@PathVariable Long id, @RequestBody CUST_ID newCustomerIdentification) {
		 try {
			 CUST_ID updatedCustomerIdentification = customerIdentificationService.updateCustomerIdentification(id, newCustomerIdentification);
			 return new ResponseEntity<>(updatedCustomerIdentification, HttpStatus.OK);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteCustomerIdentification(@PathVariable Long id) {
		 try {
			 customerIdentificationService.deleteCustomerIdentification(id);
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
}