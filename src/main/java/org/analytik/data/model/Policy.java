package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Defines Model.
 * @author Harshita Tiwari
 * Copyright 2019 by Harshita Tiwari. All rights reserved.
 *
 */

@Entity
@Table(name = "POLICY")
@NamedQuery(name = "Policy.findAll", query = "SELECT p FROM Policy p")
@NamedQuery(name = "Policy.findByPolicyId", query = "SELECT p FROM Policy p WHERE p.policyId = :policyId")
@NamedQuery(name = "Policy.findByPolicyType", query = "SELECT p FROM Policy p WHERE p.policyType = :policyType")
@NamedQuery(name = "Policy.findByStartDate", query = "SELECT p FROM Policy p WHERE p.startDate = :startDate")
@NamedQuery(name = "Policy.findByEndDate", query = "SELECT p FROM Policy p WHERE p.endDate = :endDate")
@NamedQuery(name = "Policy.findByRenewalDate", query = "SELECT p FROM Policy p WHERE p.renewalDate = :renewalDate")
@NamedQuery(name = "Policy.findByVersion", query = "SELECT p FROM Policy p WHERE p.version = :version")
public class Policy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "POLICY_ID")
    private BigDecimal policyId;
    @Column(name = "POLICY_TYPE")
    private String policyType;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "RENEWAL_DATE")
    @Temporal(TemporalType.DATE)
    private Date renewalDate;
    @Column(name = "VERSION")
    private BigInteger version;

    public Policy() {
    }

    public Policy(BigDecimal policyId) {
        this.policyId = policyId;
    }

    public BigDecimal getPolicyId() {
        return policyId;
    }

    public void setPolicyId(BigDecimal policyId) {
        this.policyId = policyId;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
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

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (policyId != null ? policyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof Policy) {
      		
      		Policy other = (Policy) object;
              
      		if ((this.policyId != null && other.policyId != null) && (this.policyId.equals(other.policyId))) {
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
        return "Policy[ policyId=" + policyId + " ]";
    }
    
}
