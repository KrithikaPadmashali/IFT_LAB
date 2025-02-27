package com.example.lab5_and_lab6.service;




import com.example.lab5_and_lab6.entity.CUST_ID;

import java.util.List;
import java.util.Optional;

public interface CUST_IDService {

    List<CUST_ID> getAllCustomerIdentifications();

    Optional<CUST_ID> getCustomerIdentificationById(Long id);

    CUST_ID createCustomerIdentification(CUST_ID customerIdentification);

    CUST_ID updateCustomerIdentification(Long id, CUST_ID newCustomerIdentification);

    void deleteCustomerIdentification(Long id);
}