package com.example.Lab4.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Lab4.entity.CustomerDetails;
import com.example.Lab4.service.CustomerDetailsService;

@RestController
@RequestMapping("/Lab4/CustomerDetails")
public class CustomerDetailsController {
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@GetMapping
	public List<CustomerDetails> getAllCustomerDetails(){
		return customerDetailsService.getAllCustomerDetails();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDetails> getCustomerDetailsById(@PathVariable Long id){
		return customerDetailsService.getCustomerDetailsById(id)
				.map(item -> new ResponseEntity<>(item, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	public ResponseEntity<CustomerDetails> createCustomerDetails(@RequestBody CustomerDetails newCustomerDetails){
		CustomerDetails savedCustomerDetails=customerDetailsService.createCustomerDetails(newCustomerDetails);
		return new ResponseEntity<>(savedCustomerDetails,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerDetails> updateCustomerDetails(@PathVariable Long id, @RequestBody CustomerDetails newCustomerDetails){
		try {
			CustomerDetails updatedCustomerDetails=customerDetailsService.updateCustomerDetails(id, newCustomerDetails);
			return new ResponseEntity<>(updatedCustomerDetails,HttpStatus.OK);
		}
		catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CustomerDetails> deleteCustomerDetails(@PathVariable Long id){
		try {
			customerDetailsService.deleteCustomerDetails(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
