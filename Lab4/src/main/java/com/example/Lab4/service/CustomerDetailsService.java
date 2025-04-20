package com.example.Lab4.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.Lab4.entity.CustomerDetails;
import com.example.Lab4.entity.CustomerIdentification;
import com.example.Lab4.repository.CustomerDetailsRepository;
import com.example.Lab4.repository.CustomerIdentificationRepository;

@Service
public class CustomerDetailsService {
	@Autowired
	private CustomerDetailsRepository customerDetailsRepository;
	
	@Autowired
	private CustomerIdentificationRepository customerIdentificationRepository;
	
	public List<CustomerDetails> getAllCustomerDetails(){
		return customerDetailsRepository.findAll();
	}
	
	public Optional<CustomerDetails> getCustomerDetailsById(Long id){
		return customerDetailsRepository.findById(id);
	}
	
	public CustomerDetails createCustomerDetails(CustomerDetails newCustomerDetails) {
		CustomerIdentification customerIdentification=customerIdentificationRepository.findById(newCustomerDetails.getCustomerId().getId())
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
		newCustomerDetails.setCustomerId(customerIdentification);
		return customerDetailsRepository.save(newCustomerDetails);
	}
	
	public CustomerDetails updateCustomerDetails(Long id, CustomerDetails newCustomerDetails) {
		return customerDetailsRepository.findById(id).map(customerDetails -> {
			customerDetails.setCustomerId(newCustomerDetails.getCustomerId());
			customerDetails.setFullName(newCustomerDetails.getFullName());
			customerDetails.setDob(newCustomerDetails.getDob());
			customerDetails.setStatus(newCustomerDetails.getStatus());
			customerDetails.setMobileNo(newCustomerDetails.getMobileNo());
			customerDetails.setEmail(newCustomerDetails.getEmail());
			customerDetails.setEffectiveDate(newCustomerDetails.getEffectiveDate());
			return customerDetailsRepository.save(customerDetails);
		}).orElseThrow(() -> new RuntimeException("Customer not found with id "+id));
	}
	
	public void deleteCustomerDetails(Long id) {
		customerDetailsRepository.findById(id).ifPresentOrElse(
				customerDetailsRepository::delete, 
				()-> {
					new RuntimeException("Customer not found with id "+id);
				}
		);
	}
}
