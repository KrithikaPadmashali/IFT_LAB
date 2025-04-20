package com.example.Lab4.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerIdentification {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private Long customerId;
	private String custIdType;
	private String custIdItem;
	private LocalDateTime custIdEffectiveDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustIdType() {
		return custIdType;
	}
	public void setCustIdType(String custIdType) {
		this.custIdType = custIdType;
	}
	public String getCustIdItem() {
		return custIdItem;
	}
	public void setCustIdItem(String custIdItem) {
		this.custIdItem = custIdItem;
	}
	public LocalDateTime getCustIdEffectiveDate() {
		return custIdEffectiveDate;
	}
	public void setCustIdEffectiveDate(LocalDateTime custIdEffectiveDate) {
		this.custIdEffectiveDate = custIdEffectiveDate;
	}
}
