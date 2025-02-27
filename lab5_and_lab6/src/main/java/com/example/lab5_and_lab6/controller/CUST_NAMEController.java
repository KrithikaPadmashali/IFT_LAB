package com.example.lab5_and_lab6.controller;



import com.example.lab5_and_lab6.entity.CUST_NAME;
import com.example.lab5_and_lab6.service.CUST_NAMEService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customer-name")
public class CUST_NAMEController {
	
	 @Autowired
	 private CUST_NAMEService customerContactInformationService;
	 
	 @GetMapping
	 public List<CUST_NAME> getAllCustomerNames() {
		 return customerContactInformationService.getAllCustomerNames();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<CUST_NAME> getCustomerNameById(@PathVariable Long id) {
		 return customerContactInformationService.getCustomerNameById(id)
				 .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
				 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 }
	 
	 @PostMapping
	 public ResponseEntity<CUST_NAME> createCustomerName(@RequestBody CUST_NAME newCustomerName) {
		 CUST_NAME savedCustomerIdentification = customerContactInformationService.createCustomerName(newCustomerName);
	 	return new ResponseEntity<>(savedCustomerIdentification, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<CUST_NAME> updateCustomerName(@PathVariable Long id, @RequestBody CUST_NAME newCustomerName) {
		 try {
			 CUST_NAME updatedCustomerIdentification = customerContactInformationService.updateCustomerName(id, newCustomerName);
			 return new ResponseEntity<>(updatedCustomerIdentification, HttpStatus.OK);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteCustomerName(@PathVariable Long id) {
		 try {
			 customerContactInformationService.deleteCustomerName(id);
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
}