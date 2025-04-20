package com.example.lab56_p.serviceImpl;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lab56_p.entity.CustomerContactInformation;

import com.example.lab56_p.repository.CustomerContactInformationRepository;
import com.example.lab56_p.service.CustomerContactInformationService;

@Service
public class CustomerContactInformationServiceImpl implements CustomerContactInformationService{
	@Autowired
	private CustomerContactInformationRepository ccir;
	
	public List<CustomerContactInformation> getAllCust(){
		return ccir.findAll();
	}
	
	public 	Optional<CustomerContactInformation> getByid(Long id){
		return 	ccir.findById(id);
	}
	
	public 	CustomerContactInformation postCust(CustomerContactInformation cci) {
		return ccir.save(cci);
	}
	
	public CustomerContactInformation putbyid(Long id,CustomerContactInformation cidetail) {
		return ccir.findById(id).map(
				cci->{
					cci.setValue(cidetail.getValue());
		cci.setType(cidetail.getType());
		return ccir.save(cci);
				}).orElseThrow(()->new RuntimeException ("Cannot find that val with  id"+id));
				
	}
  public  void delecust(Long id) {
	  ccir.findById(id).ifPresentOrElse
			  (ccir::delete, ()->{
				  throw new RuntimeException("Cannot find that val with id"+id);
				  }
	  );
  }


	

}
