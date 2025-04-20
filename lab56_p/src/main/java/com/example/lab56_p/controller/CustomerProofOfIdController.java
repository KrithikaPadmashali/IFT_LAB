package com.example.lab56_p.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import  org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import  com.example.lab56_p.entity.CustomerProofOfId;
import com.example.lab56_p.service.CustomerProofOfIdService;

@RestController
@RequestMapping("/api/customer-proof")
public class CustomerProofOfIdController  {
	
	@Autowired
	private CustomerProofOfIdService cpis;
	@GetMapping
	public List<CustomerProofOfId> getAllCust(){
		return cpis.getAllCust();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerProofOfId> getCustbyid(@PathVariable Long id){
		return cpis.getCustById(id).
				map(cpi->new ResponseEntity<>(cpi,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		}
	
	@PostMapping
	public ResponseEntity<CustomerProofOfId> postallCust(@RequestBody CustomerProofOfId cpi){
		CustomerProofOfId newcpi=cpis.postallcust(cpi);
		return new ResponseEntity<>(newcpi,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerProofOfId> putbyId(@PathVariable Long id,@RequestBody CustomerProofOfId cpidet){
		try {
			CustomerProofOfId newcpi=cpis.putbyid(id, cpidet);
			return new ResponseEntity<>(newcpi,HttpStatus.OK);
		}
		catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletebyId(@PathVariable Long id){
		try {
			cpis.deletebyid(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
