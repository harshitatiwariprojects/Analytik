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
@Table(name = "SALARY")
@NamedQuery(name = "Salary.findAll", query = "SELECT s FROM Salary s")
@NamedQuery(name = "Salary.findBySalaryId", query = "SELECT s FROM Salary s WHERE s.salaryId = :salaryId")
@NamedQuery(name = "Salary.findByCurrentctc", query = "SELECT s FROM Salary s WHERE s.currentctc = :currentctc")
@NamedQuery(name = "Salary.findByCurrentvpc", query = "SELECT s FROM Salary s WHERE s.currentvpc = :currentvpc")
@NamedQuery(name = "Salary.findByHrPolicyId", query = "SELECT s FROM Salary s WHERE s.hrPolicyId = :hrPolicyId")
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SALARY_ID")
    private BigDecimal salaryId;
    @Column(name = "CURRENTCTC")
    private BigInteger currentctc;
    @Column(name = "CURRENTVPC")
    private BigInteger currentvpc;
    @Column(name = "HR_POLICY_ID")
    private BigInteger hrPolicyId;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(optional = false)
    private Employee employeeId;

    public Salary() {
    }

    public Salary(BigDecimal salaryId) {
        this.salaryId = salaryId;
    }

    public BigDecimal getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(BigDecimal salaryId) {
        this.salaryId = salaryId;
    }

    public BigInteger getCurrentctc() {
        return currentctc;
    }

    public void setCurrentctc(BigInteger currentctc) {
        this.currentctc = currentctc;
    }

    public BigInteger getCurrentvpc() {
        return currentvpc;
    }

    public void setCurrentvpc(BigInteger currentvpc) {
        this.currentvpc = currentvpc;
    }

    public BigInteger getHrPolicyId() {
        return hrPolicyId;
    }

    public void setHrPolicyId(BigInteger hrPolicyId) {
        this.hrPolicyId = hrPolicyId;
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
        hash += (salaryId != null ? salaryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof Salary) {
      		
      		Salary other = (Salary) object;
              
      		if ((this.salaryId != null && other.salaryId != null) && (this.salaryId.equals(other.salaryId))) {
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
        return "Salary[ salaryId=" + salaryId + " ]";
    }
    
}
