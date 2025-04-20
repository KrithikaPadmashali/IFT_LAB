package com.example.Lab4.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import org.hibernate.annotations.NaturalId;

@Entity
public class CustomerProofOfId {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CustomerIdentification customerId;
	
	private Integer cstPoiClsId;
	
	@NaturalId
	private String cstPoiValue;
	
	private Date cstPoiStartDate;
	private Date cstPoiEndDate;
	private LocalDateTime cstPoiEffectiveDate;
	
	public CustomerIdentification getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerIdentification customerId) {
		this.customerId = customerId;
	}

	public Integer getCstPoiClsId() {
		return cstPoiClsId;
	}

	public void setCstPoiClsId(Integer cstPoiClsId) {
		this.cstPoiClsId = cstPoiClsId;
	}

	public String getCstPoiValue() {
		return cstPoiValue;
	}

	public void setCstPoiValue(String cstPoiValue) {
		this.cstPoiValue = cstPoiValue;
	}

	public Date getCstPoiStartDate() {
		return cstPoiStartDate;
	}

	public void setCstPoiStartDate(Date cstPoiStartDate) {
		this.cstPoiStartDate = cstPoiStartDate;
	}
	public Date getCstPoiEndDate() {
		return cstPoiEndDate;
	}

	public void setCstPoiEndDate(Date cstPoiEndDate) {
		this.cstPoiEndDate = cstPoiEndDate;
	}

	public LocalDateTime getCstPoiEffectiveDate() {
		return cstPoiEffectiveDate;
	}

	public void setCstPoiEffectiveDate(LocalDateTime cstPoiEffectiveDate) {
		this.cstPoiEffectiveDate = cstPoiEffectiveDate;
	}

}
