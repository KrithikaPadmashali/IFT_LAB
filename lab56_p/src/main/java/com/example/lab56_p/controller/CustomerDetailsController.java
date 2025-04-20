package com.example.lab56_p.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.lab56_p.entity.CustomerDetails;
import com.example.lab56_p.service.CustomerDetailsService;
import java.util.List;


@RestController
@RequestMapping("/api/customer-details")
public class CustomerDetailsController {
	@Autowired
	private CustomerDetailsService cds;
	@GetMapping
	public List<CustomerDetails> getallcust(){
		return cds.getAllCust();
	}
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDetails> getcustbyid(@PathVariable Long id){
		return cds.getCustByid(id).map(cd->new ResponseEntity<>(cd,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
				
	}
	@PostMapping
	public ResponseEntity<CustomerDetails> postallcust(@RequestBody CustomerDetails cd){
		CustomerDetails newcd=cds.postAllcust(cd);
		return new ResponseEntity<>(newcd,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<CustomerDetails> putbyid(@PathVariable Long id,@RequestBody CustomerDetails cd){
		try {
			CustomerDetails newcd=cds.putByid(id, cd);
			return new ResponseEntity<>(newcd,HttpStatus.OK);
		}
		catch(RuntimeException e) {
			return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
		try {
			cds.deleteUser(id);
			return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
