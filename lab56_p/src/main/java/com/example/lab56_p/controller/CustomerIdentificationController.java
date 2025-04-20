package com.example.lab56_p.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.lab56_p.entity.CustomerIdentification;
import com.example.lab56_p.service.CustomerIdentificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/api/customer-identification")
public class CustomerIdentificationController {

	@Autowired
	private CustomerIdentificationService customeridentificationservice;
	@GetMapping
	public List<CustomerIdentification> getAllCust(){
		return customeridentificationservice.getAllCust();
	}
	@GetMapping("/{id}")
	public ResponseEntity<CustomerIdentification> getByid(@PathVariable Long id){
		return customeridentificationservice.getByid(id).
				map(ci->new ResponseEntity<>(ci,HttpStatus.OK))
				.orElse(new ResponseEntity <>(HttpStatus.NOT_FOUND));
	}
	@PostMapping
	public ResponseEntity<CustomerIdentification> postCust(@RequestBody CustomerIdentification ci){
		CustomerIdentification cinew=customeridentificationservice.postCust(ci);
		return new ResponseEntity<>(cinew,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<CustomerIdentification> putbyid(@PathVariable Long id,@RequestBody CustomerIdentification ci){
		try {
			CustomerIdentification cinew=customeridentificationservice.putbyid(id, ci);
			return new ResponseEntity<>(cinew,HttpStatus.OK);
		}
		catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delcust(@PathVariable Long id){
		try {
			customeridentificationservice.delecust(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
