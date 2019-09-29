package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "EMPLOYEE_PROJECT_MAPPING")
@NamedQuery(name = "EmployeeProjectMapping.findAll", query = "SELECT e FROM EmployeeProjectMapping e")
@NamedQuery(name = "EmployeeProjectMapping.findByEpmid", query = "SELECT e FROM EmployeeProjectMapping e WHERE e.epmid = :epmid")
public class EmployeeProjectMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EPMID")
    private BigDecimal epmid;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(optional = false)
    private Employee employeeId;

    public EmployeeProjectMapping() {
    }

    public EmployeeProjectMapping(BigDecimal epmid) {
        this.epmid = epmid;
    }

    public BigDecimal getEpmid() {
        return epmid;
    }

    public void setEpmid(BigDecimal epmid) {
        this.epmid = epmid;
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
        hash += (epmid != null ? epmid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
     	boolean isEqual = false;
      	
      	if(object instanceof EmployeeProjectMapping) {
      		
      		EmployeeProjectMapping other = (EmployeeProjectMapping) object;
              
      		if ((this.epmid != null && other.epmid != null) && (this.epmid.equals(other.epmid))) {
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
        return "EmployeeProjectMapping[ epmid=" + epmid + " ]";
    }
    
}
