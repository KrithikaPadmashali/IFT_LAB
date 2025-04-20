package com.example.Lab4.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String fullName;
	private Date dob;
	private String status;
	private String mobileNo;
	private String email;
	private Date effectiveDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private CustomerIdentification customerId;
	
	public CustomerIdentification getCustomerId() {
		return customerId;
	}
	public void setCustomerId(CustomerIdentification customerId) {
		this.customerId=customerId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
}
