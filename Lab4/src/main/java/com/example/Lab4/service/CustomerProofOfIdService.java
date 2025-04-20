package com.example.Lab4.service;

import java.util.List;
import java.util.Optional;
import com.example.Lab4.entity.CustomerIdentification;
import com.example.Lab4.entity.CustomerProofOfId;
import com.example.Lab4.repository.CustomerIdentificationRepository;
import com.example.Lab4.repository.CustomerProofOfIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CustomerProofOfIdService {
    
    @Autowired
    private CustomerProofOfIdRepository customerProofOfIdRepository;
    
    @Autowired
    private CustomerIdentificationRepository customerIdentificationRepository;
    
    public List<CustomerProofOfId> getAllCustomerProofOfId() {
        return customerProofOfIdRepository.findAll();
    }
    
    public Optional<CustomerProofOfId> getCustomerProofOfIdById(Long id) {
        return customerProofOfIdRepository.findById(id);
    }
    
    public CustomerProofOfId createCustomerProofOfId(CustomerProofOfId customerProofOfId) {
        CustomerIdentification customerIdentification = customerIdentificationRepository
            .findById(customerProofOfId.getCustomerId().getId()) 
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
        customerProofOfId.setCustomerId(customerIdentification);
        return customerProofOfIdRepository.save(customerProofOfId);
    }
    
    public CustomerProofOfId updateCustomerProofOfId(Long id, CustomerProofOfId newCustomerProofOfId) {
        return customerProofOfIdRepository.findById(id).map(customerProofOfId -> {
            customerProofOfId.setCustomerId(newCustomerProofOfId.getCustomerId());
            customerProofOfId.setCstPoiClsId(newCustomerProofOfId.getCstPoiClsId());
            customerProofOfId.setCstPoiStartDate(newCustomerProofOfId.getCstPoiStartDate());
            customerProofOfId.setCstPoiEndDate(newCustomerProofOfId.getCstPoiEndDate());
            customerProofOfId.setCstPoiEffectiveDate(newCustomerProofOfId.getCstPoiEffectiveDate());
            return customerProofOfIdRepository.save(customerProofOfId);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Proof of Id not found for id" + id));
    }
    
    public void deleteCustomerProofOfId(Long id) {
        customerProofOfIdRepository.findById(id).ifPresentOrElse(
            customerProofOfIdRepository::delete, () -> { 
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Proof of Id not found for id" + id);
            });
    }
}
