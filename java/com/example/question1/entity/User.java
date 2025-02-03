package com.example.question1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String CUST_ID;
	private String CSTDET_TYPE;
	private String CSTDET_DOB;
    private String CSTDET_STATUS;
    private String CSTDET_CONTACT;
    private String CSTDET_MOBILE;
    private String CSTDET_EMAIL;
    private String CSTDET_EFCTV_DATE;
    private String CSTDET_CRUD_VALUE;
    private String CSTDET_USER_ID;
    private String CSTDET_WS_ID;
    private String CSTDET_PRGM_ID;
    private String CSTDET_LOCAL_TS ;
    private String CSTDET_ACPT_TS ;
    private String CSTDET_ACPT_TS_UTC_OFST ;
    private String CSTDET_UUID;
    
    
    
}
