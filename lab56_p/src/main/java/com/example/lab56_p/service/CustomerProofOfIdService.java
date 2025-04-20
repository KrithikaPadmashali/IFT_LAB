package com.example.lab56_p.service;

import com.example.lab56_p.entity.CustomerProofOfId;
import java.util.Optional;
import java.util.List;
public interface CustomerProofOfIdService {

	List<CustomerProofOfId> getAllCust();
	Optional<CustomerProofOfId> getCustById(Long id);
	CustomerProofOfId postallcust(CustomerProofOfId cpi);
	CustomerProofOfId putbyid(Long id,CustomerProofOfId cpidet);
	void deletebyid(Long id);
	

}
