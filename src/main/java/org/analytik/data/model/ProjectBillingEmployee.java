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
@Table(name = "PROJECT_BILLING_EMPLOYEE")
@NamedQuery(name = "ProjectBillingEmployee.findAll", query = "SELECT p FROM ProjectBillingEmployee p")
@NamedQuery(name = "ProjectBillingEmployee.findByPbeid", query = "SELECT p FROM ProjectBillingEmployee p WHERE p.pbeId = :pbeId")
@NamedQuery(name = "ProjectBillingEmployee.findByHours", query = "SELECT p FROM ProjectBillingEmployee p WHERE p.hours = :hours")
public class ProjectBillingEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PBEID")
    private BigDecimal pbeId;
    @Column(name = "HOURS")
    private BigInteger hours;
    @JoinColumn(name = "BILLING_ID", referencedColumnName = "BILLING_ID")
    @ManyToOne(optional = false)
    private Billing billingId;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(optional = false)
    private Employee employeeId;

    public ProjectBillingEmployee() {
    }

    public ProjectBillingEmployee(BigDecimal pbeId) {
        this.pbeId = pbeId;
    }

    public BigDecimal getPbeId() {
        return pbeId;
    }

    public void setPbeId(BigDecimal pbeId) {
        this.pbeId = pbeId;
    }

    public BigInteger getHours() {
        return hours;
    }

    public void setHours(BigInteger hours) {
        this.hours = hours;
    }

    public Billing getBillingId() {
        return billingId;
    }

    public void setBillingId(Billing billingId) {
        this.billingId = billingId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pbeId != null ? pbeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof ProjectBillingEmployee) {
      		
      		ProjectBillingEmployee other = (ProjectBillingEmployee) object;
              
      		if ((this.pbeId != null && other.pbeId != null) && (this.pbeId.equals(other.pbeId))) {
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
        return "ProjectBillingEmployee[ pbeid=" + pbeId + " ]";
    }
    
}
