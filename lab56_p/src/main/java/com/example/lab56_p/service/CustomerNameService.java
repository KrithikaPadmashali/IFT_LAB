package com.example.lab56_p.service;

import java.util.Optional;
import java.util.List;
import com.example.lab56_p.entity.CustomerName;
public interface CustomerNameService {
	List<CustomerName> getAllcustnames();
	Optional<CustomerName> getcustById(Long id);
	CustomerName showallcust(CustomerName cname);
	CustomerName updatebyid(Long id,CustomerName cnamedetail);
	void delebyId(Long id);

}
