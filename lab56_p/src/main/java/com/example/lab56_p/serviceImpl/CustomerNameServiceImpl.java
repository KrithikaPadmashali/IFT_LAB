package com.example.lab56_p.serviceImpl;

import java.util.Optional;
import java.util.List;
import com.example.lab56_p.entity.CustomerName;
import com.example.lab56_p.repository.CustomerNameRepository;
import com.example.lab56_p.service.CustomerNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerNameServiceImpl implements CustomerNameService {

	@Autowired
	private CustomerNameRepository customernamerepo;
	
	@Override
	public List<CustomerName> getAllcustnames(){
		return customernamerepo.findAll();
	}
	@Override
	public Optional<CustomerName> getcustById(Long id){
		return customernamerepo.findById(id);
	}
	@Override
	public 	CustomerName showallcust(CustomerName cname) {
		return customernamerepo.save(cname);
	}
	@Override
	public 	CustomerName updatebyid(Long id,CustomerName cnamedetail) {
		return customernamerepo.findById(id)
		.map(cname->{
			cname.setName(cnamedetail.getName());
			cname.setMiddlename(cnamedetail.getMiddlename());
			cname.setLastname(cnamedetail.getLastname());
			return customernamerepo.save(cname);
		})
		.orElseThrow(()-> new RuntimeException("could not find customer with the id"+id));
	}
	
	@Override
    public void delebyId(Long id) {
    	customernamerepo.findById(id).ifPresentOrElse(
    			customernamerepo::delete,
    			() ->
    			{throw new RuntimeException("couldnot find customer name with that id"+id);
    				}
    			);
    	
    }
	
	
	
	
	
	
}
