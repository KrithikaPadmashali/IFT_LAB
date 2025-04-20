package com.example.Lab4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Lab4.entity.CustomerIdentification;
import com.example.Lab4.service.CustomerIdentificationService;
import java.util.List;

@RestController
@RequestMapping("/Lab4/CustomerIdentification")
public class CustomerIdentificationController {
	@Autowired
	private CustomerIdentificationService customerIdentificationService;
	
	@GetMapping
	public List<CustomerIdentification> getAllCustomerIdentification(){
		return customerIdentificationService.getAllCustomerIdentification();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerIdentification> getCustomerIdentificationById(@PathVariable Long id){
		return customerIdentificationService.getCustomerIdentificationById(id)
				.map(item -> new ResponseEntity<>(item,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	public ResponseEntity<CustomerIdentification> createCustomerIdentification(@RequestBody CustomerIdentification newCustomerIdentification){
		CustomerIdentification savedCustomerIdentification=customerIdentificationService.createCustomerIdentification(newCustomerIdentification);
		return new ResponseEntity<>(savedCustomerIdentification,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerIdentification> updateCustomerIdentification(@PathVariable Long id,@RequestBody CustomerIdentification newCustomerIdentification){
		try {
			CustomerIdentification updatedCustomerIdentification=customerIdentificationService.updateCustomerIdentification(id, newCustomerIdentification);
			return new ResponseEntity<>(updatedCustomerIdentification,HttpStatus.OK);
		}
		catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomerIdentification(@PathVariable Long id){
		try {
			customerIdentificationService.deleteCustomerIdentification(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
