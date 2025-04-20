package com.example.lab56_p.entity;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.util.*;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class CustomerDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
	private CustomerName cn;
	
	private Date dateOfBirth;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<CustomerIdentification> ci;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<CustomerProofOfId> cpi;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<CustomerContactInformation> cci;
    
    @CreatedBy
    private String createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerName getCn() {
		return cn;
	}

	public void setCn(CustomerName cn) {
		this.cn = cn;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<CustomerIdentification> getCi() {
		return ci;
	}

	public void setCi(List<CustomerIdentification> ci) {
		this.ci = ci;
	}

	public List<CustomerProofOfId> getCpi() {
		return cpi;
	}

	public void setCpi(List<CustomerProofOfId> cpi) {
		this.cpi = cpi;
	}

	public List<CustomerContactInformation> getCci() {
		return cci;
	}

	public void setCci(List<CustomerContactInformation> cci) {
		this.cci = cci;
	}
	
	
	
	
	
}
