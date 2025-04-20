package com.example.lab56_p.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.lab56_p.entity.CustomerProofOfId;
import com.example.lab56_p.repository.CustomerProofOfIdRepository;
import com.example.lab56_p.service.CustomerProofOfIdService;


@Service
public class CustomerProofOfIdServiceImpl implements CustomerProofOfIdService {

	@Autowired
	private CustomerProofOfIdRepository custproofidrepo;
	
	public 	List<CustomerProofOfId> getAllCust(){
		return custproofidrepo.findAll();
	}

	public 	Optional<CustomerProofOfId> getCustById(Long id){
		return custproofidrepo.findById(id);
	}
    
	
	public 	CustomerProofOfId postallcust(CustomerProofOfId cpi) {
		return custproofidrepo.save(cpi);
	}

	public 	CustomerProofOfId putbyid(Long id,CustomerProofOfId cpidet) {
		return custproofidrepo.findById(id).map(cpi->{
			cpi.setType(cpidet.getType());
			cpi.setValue(cpidet.getValue());
			cpi.setStartDate(cpidet.getStartDate());
			cpi.setEndDate(cpidet.getEndDate());
			return custproofidrepo.save(cpi);
		}).orElseThrow(()->new RuntimeException("Not found"));
		
		
		
	}
	public 	void deletebyid(Long id) {
		custproofidrepo.findById(id).ifPresentOrElse(custproofidrepo::delete,()->{
			throw new RuntimeException("Not found");
		});
	}

}
