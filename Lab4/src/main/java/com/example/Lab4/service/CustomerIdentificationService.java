package com.example.Lab4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Lab4.entity.CustomerIdentification;
import com.example.Lab4.repository.CustomerIdentificationRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerIdentificationService {
	
	@Autowired
	private CustomerIdentificationRepository customerIdentificationRepository;
	
	public List<CustomerIdentification> getAllCustomerIdentification(){
		return customerIdentificationRepository.findAll();
	}
	public Optional<CustomerIdentification> getCustomerIdentificationById(Long id){
		return customerIdentificationRepository.findById(id);
	}
	public CustomerIdentification createCustomerIdentification(CustomerIdentification customerIdentification){
		return customerIdentificationRepository.save(customerIdentification);
	}
	public CustomerIdentification updateCustomerIdentification(Long id,CustomerIdentification newCustomerIdentification) {
		return customerIdentificationRepository.findById(id).map(customerIdentification -> {
			customerIdentification.setCustomerId(newCustomerIdentification.getCustomerId());
			customerIdentification.setCustIdType(newCustomerIdentification.getCustIdType());
			customerIdentification.setCustIdItem(newCustomerIdentification.getCustIdItem());
			customerIdentification.setCustIdEffectiveDate(newCustomerIdentification.getCustIdEffectiveDate());
			return customerIdentificationRepository.save(customerIdentification);
		}).orElseThrow(() -> new RuntimeException("Customer identification not found with id: " + id));
	}
	public void deleteCustomerIdentification(Long id) {
		customerIdentificationRepository.findById(id).ifPresentOrElse(
				customerIdentificationRepository::delete,() -> {
					throw new RuntimeException("Customer Identification not found with id: "+id);
				}
		);
	}
}
