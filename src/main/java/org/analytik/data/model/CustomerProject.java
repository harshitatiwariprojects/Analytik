package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Defines Model.
 * @author Harshita Tiwari
 * Copyright 2019 by Harshita Tiwari. All rights reserved.
 *
 */

@Entity
@Table(name = "CUSTOMER_PROJECT")
@NamedQuery(name = "CustomerProject.findAll", query = "SELECT c FROM CustomerProject c")
@NamedQuery(name = "CustomerProject.findByCustomerProjectCode", query = "SELECT c FROM CustomerProject c WHERE c.customerProjectCode = :customerProjectCode")
@NamedQuery(name = "CustomerProject.findByCustProjectType", query = "SELECT c FROM CustomerProject c WHERE c.custProjectType = :custProjectType")
@NamedQuery(name = "CustomerProject.findByCustomerProjectSponsor", query = "SELECT c FROM CustomerProject c WHERE c.customerProjectSponsor = :customerProjectSponsor")
@NamedQuery(name = "CustomerProject.findByCustomerBillingCode", query = "SELECT c FROM CustomerProject c WHERE c.customerBillingCode = :customerBillingCode")
@NamedQuery(name = "CustomerProject.findByCustomerBusinessUnitId", query = "SELECT c FROM CustomerProject c WHERE c.customerBusinessUnitId = :customerBusinessUnitId")
public class CustomerProject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CUSTOMER_PROJECT_CODE")
    private BigDecimal customerProjectCode;
    @Column(name = "CUST_PROJECT_TYPE")
    private String custProjectType;
    @Column(name = "CUSTOMER_PROJECT_SPONSOR")
    private BigInteger customerProjectSponsor;
    @Basic(optional = false)
    @Column(name = "CUSTOMER_BILLING_CODE")
    private BigInteger customerBillingCode;
    @Basic(optional = false)
    @Column(name = "CUSTOMER_BUSINESS_UNIT_ID")
    private BigInteger customerBusinessUnitId;
    @JoinColumn(name = "CUSTOMER_CODE", referencedColumnName = "CUSTOMER_CODE")
    @ManyToOne(optional = false)
    private Customer customerCode;
    @JoinColumn(name = "CUSTOMER_MANAGER", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee customerManager;

    public CustomerProject() {
    }

    public CustomerProject(BigDecimal customerProjectCode) {
        this.customerProjectCode = customerProjectCode;
    }

    public CustomerProject(BigDecimal customerProjectCode, BigInteger customerBillingCode, BigInteger customerBusinessUnitId) {
        this.customerProjectCode = customerProjectCode;
        this.customerBillingCode = customerBillingCode;
        this.customerBusinessUnitId = customerBusinessUnitId;
    }

    public BigDecimal getCustomerProjectCode() {
        return customerProjectCode;
    }

    public void setCustomerProjectCode(BigDecimal customerProjectCode) {
        this.customerProjectCode = customerProjectCode;
    }

    public String getCustProjectType() {
        return custProjectType;
    }

    public void setCustProjectType(String custProjectType) {
        this.custProjectType = custProjectType;
    }

    public BigInteger getCustomerProjectSponsor() {
        return customerProjectSponsor;
    }

    public void setCustomerProjectSponsor(BigInteger customerProjectSponsor) {
        this.customerProjectSponsor = customerProjectSponsor;
    }

    public BigInteger getCustomerBillingCode() {
        return customerBillingCode;
    }

    public void setCustomerBillingCode(BigInteger customerBillingCode) {
        this.customerBillingCode = customerBillingCode;
    }

    public BigInteger getCustomerBusinessUnitId() {
        return customerBusinessUnitId;
    }

    public void setCustomerBusinessUnitId(BigInteger customerBusinessUnitId) {
        this.customerBusinessUnitId = customerBusinessUnitId;
    }

    public Customer getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(Customer customerCode) {
        this.customerCode = customerCode;
    }

    public Employee getCustomerManager() {
        return customerManager;
    }

    public void setCustomerManager(Employee customerManager) {
        this.customerManager = customerManager;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerProjectCode != null ? customerProjectCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
     	
     	if(object instanceof CustomerProject) {
     		
     		CustomerProject other = (CustomerProject) object;
             
     		if ((this.customerProjectCode != null && other.customerProjectCode != null) && (this.customerProjectCode.equals(other.customerProjectCode))) {
     			isEqual = true;
             }else {
             	isEqual = false;
             }
     	}else {
     		isEqual = false;
     	}      	
     	
     	return isEqual;     	
    }

    @Override
    public String toString() {
        return "CustomerProject[ customerProjectCode=" + customerProjectCode + " ]";
    }
    
}
