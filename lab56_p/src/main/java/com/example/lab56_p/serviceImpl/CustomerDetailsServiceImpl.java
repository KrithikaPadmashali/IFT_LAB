package com.example.lab56_p.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lab56_p.entity.CustomerDetails;
import com.example.lab56_p.repository.CustomerDetailsRepository;
import com.example.lab56_p.service.CustomerDetailsService;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService{

	@Autowired
	private CustomerDetailsRepository cdr;
	@Override
	public 	List<CustomerDetails> getAllCust(){
		return cdr.findAll();
	}
	@Override
	public 	Optional<CustomerDetails> getCustByid(Long id){
		return cdr.findById(id);
	}
	@Override
	public CustomerDetails postAllcust(CustomerDetails cd) {
		return cdr.save(cd);
	}
	@Override
	public 	CustomerDetails putByid(Long id,CustomerDetails cddetails) {
		return cdr.findById(id).map(
				cd->{
					cd.setId(cddetails.getId());
					cd.setDateOfBirth(cddetails.getDateOfBirth());
		            cd.setCn(cddetails.getCn());
		            cd.setCpi(cddetails.getCpi());
		            cd.setCi(cddetails.getCi());
		            cd.setCci(cddetails.getCci());
		            return cdr.save(cd);
				}).orElseThrow(()->new RuntimeException("Not found"));
		
		
		
	}
	@Override
	public 	void deleteUser(Long id) {
		cdr.findById(id).ifPresentOrElse(cdr::delete, ()->{throw new RuntimeException("Not found");});
	}

	
}
