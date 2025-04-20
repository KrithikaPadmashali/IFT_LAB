package com.example.lab56_p.service;


import java.util.List;
import java.util.Optional;
import com.example.lab56_p.entity.CustomerContactInformation;

public interface CustomerContactInformationService {

	List<CustomerContactInformation> getAllCust();
	Optional<CustomerContactInformation> getByid(Long id);
	CustomerContactInformation postCust(CustomerContactInformation cci);
	CustomerContactInformation putbyid(Long id,CustomerContactInformation ccidetail);
	void delecust(Long id);
}
