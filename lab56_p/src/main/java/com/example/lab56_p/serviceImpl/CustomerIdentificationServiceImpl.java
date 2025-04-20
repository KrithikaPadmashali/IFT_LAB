package com.example.lab56_p.serviceImpl;



import com.example.lab56_p.entity.CustomerIdentification;
import com.example.lab56_p.repository.CustomerIdentificationRepository;
import com.example.lab56_p.service.CustomerIdentificationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerIdentificationServiceImpl implements CustomerIdentificationService{

	@Autowired
	private CustomerIdentificationRepository customeridentificationrepository;
	
	public List<CustomerIdentification> getAllCust(){
		return customeridentificationrepository.findAll();
	}
	
	public 	Optional<CustomerIdentification> getByid(Long id){
		return 	customeridentificationrepository.findById(id);
	}
	
	public 	CustomerIdentification postCust(CustomerIdentification ci) {
		return customeridentificationrepository.save(ci);
	}
	
	public 	CustomerIdentification putbyid(Long id,CustomerIdentification cidetail) {
		return customeridentificationrepository.findById(id).map(
				ci->{
					ci.setValue(cidetail.getValue());
		ci.setType(cidetail.getType());
		return customeridentificationrepository.save(ci);
				}).orElseThrow(()->new RuntimeException ("Cannot find that val with  id"+id));
				
	}
  public  void delecust(Long id) {
	  customeridentificationrepository.findById(id).ifPresentOrElse
			  (customeridentificationrepository::delete, ()->{
				  throw new RuntimeException("Cannot find that val with id"+id);
				  }
	  );
  }



}
