package com.example.lab5_and_lab6.service;



import com.example.lab5_and_lab6.entity.CUST_NAME;
import java.util.List;
import java.util.Optional;

public interface CUST_NAMEService {

    List<CUST_NAME> getAllCustomerNames();

    Optional<CUST_NAME> getCustomerNameById(Long id);

    CUST_NAME createCustomerName(CUST_NAME customerName);

    CUST_NAME updateCustomerName(Long id, CUST_NAME newCustomerName);

    void deleteCustomerName(Long id);
}