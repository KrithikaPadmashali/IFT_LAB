package com.example.lab56_p.service;



import java.util.List;
import java.util.Optional;
import com.example.lab56_p.entity.CustomerIdentification;
public interface CustomerIdentificationService {

	List<CustomerIdentification> getAllCust();
	Optional<CustomerIdentification> getByid(Long id);
	CustomerIdentification postCust(CustomerIdentification ci);
	CustomerIdentification putbyid(Long id,CustomerIdentification cidetail);
	void delecust(Long id);
	
	
}
