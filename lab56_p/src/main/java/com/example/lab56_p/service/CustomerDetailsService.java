package com.example.lab56_p.service;
import java.util.List;
import java.util.Optional;

import com.example.lab56_p.entity.*;



public interface CustomerDetailsService {
	
	
	List<CustomerDetails> getAllCust();
	Optional<CustomerDetails> getCustByid(Long id);
	CustomerDetails postAllcust(CustomerDetails cd);
	CustomerDetails putByid(Long id,CustomerDetails cddetails);
	void deleteUser(Long id);

}
