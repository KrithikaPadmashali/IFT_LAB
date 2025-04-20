package com.example.lab56_p.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.lab56_p.entity.CustomerContactInformation;

import com.example.lab56_p.service.CustomerContactInformationService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/api/customer-contact")
public class CustomerContactInformationController {



	@Autowired
	private CustomerContactInformationService ccis;
	@GetMapping
	public List<CustomerContactInformation> getAllCust(){
		return ccis.getAllCust();
	}
	@GetMapping("/{id}")
	public ResponseEntity<CustomerContactInformation> getByid(@PathVariable Long id){
		return ccis.getByid(id).
				map(ci->new ResponseEntity<>(ci,HttpStatus.OK))
				.orElse(new ResponseEntity <>(HttpStatus.NOT_FOUND));
	}
	@PostMapping
	public ResponseEntity<CustomerContactInformation> postCust(@RequestBody CustomerContactInformation ci){
		CustomerContactInformation cinew=ccis.postCust(ci);
		return new ResponseEntity<>(cinew,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<CustomerContactInformation> putbyid(@PathVariable Long id,@RequestBody CustomerContactInformation ci){
		try {
			CustomerContactInformation cinew=ccis.putbyid(id, ci);
			return new ResponseEntity<>(cinew,HttpStatus.OK);
		}
		catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delcust(@PathVariable Long id){
		try {
			ccis.delecust(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}
