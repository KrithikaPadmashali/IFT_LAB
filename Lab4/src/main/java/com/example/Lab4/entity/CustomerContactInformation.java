package com.example.Lab4.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class CustomerContactInformation {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private Long customerId;
	 private Integer type;
	 private String value;
	 private LocalDateTime effectiveDate;
	 private Date startDate;
	 private Date endDate;
	 
	 public Long getId() {
		 return id;
	 }
	 
	 public Long getCustomerId() {
		 return customerId;
	 }
	 
	 public Integer getType() {
		 return type;
	 }
	 
	 public String getValue() {
		 return value;
	 }

	 
	 public LocalDateTime getEffectiveDate() {
		 return effectiveDate;
	 }
	 
	 
	 public void setId(Long newId) {
		 id = newId;
	 }
	 
	 public void setCustomerId(Long newCustomerId) {
		 customerId = newCustomerId;
	 }
	 
	 public void setType(Integer newType) {
		 type = newType;
	 }
	 
	 public void setValue(String newValue) {
		 value = newValue;
	 }
	 
	 
	 public void setEffectiveDate(LocalDateTime newEffectiveDate) {
		 effectiveDate = newEffectiveDate;
	 }

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	 
}