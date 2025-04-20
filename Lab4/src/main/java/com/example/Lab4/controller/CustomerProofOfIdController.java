package com.example.Lab4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.Lab4.entity.CustomerProofOfId;
import com.example.Lab4.service.CustomerProofOfIdService;
import java.util.List;

@RestController
@RequestMapping("/Lab4/CustomerProofOfId")
public class CustomerProofOfIdController {
	
	@Autowired
	private CustomerProofOfIdService customerProofOfIdService;
	
	@GetMapping
	public List<CustomerProofOfId> getAllCustomerProofOfId(){
		return customerProofOfIdService.getAllCustomerProofOfId();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerProofOfId> getCustomerProofOfIdById(@PathVariable Long id){
		return customerProofOfIdService.getCustomerProofOfIdById(id)
				.map(item -> new ResponseEntity<>(item, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	public ResponseEntity<CustomerProofOfId> createCustomerProofOfId(@RequestBody CustomerProofOfId newCustomerProofOfId){
		CustomerProofOfId savedCustomerProofOfId=customerProofOfIdService.createCustomerProofOfId(newCustomerProofOfId);
		return new ResponseEntity<>(savedCustomerProofOfId, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerProofOfId> updateCustomerProofOfId(@PathVariable Long id, @RequestBody CustomerProofOfId newCustomerProofOfId){
		try {
			CustomerProofOfId updatedCustomerProofOfId=customerProofOfIdService.updateCustomerProofOfId(id, newCustomerProofOfId);
			return new ResponseEntity<>(updatedCustomerProofOfId, HttpStatus.OK);
		}
		catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CustomerProofOfId> deleteCustomerProofOfId(@PathVariable Long id){
		try {
			customerProofOfIdService.deleteCustomerProofOfId(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
