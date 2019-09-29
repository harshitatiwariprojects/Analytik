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
@Table(name = "MANAGEMENT")
@NamedQuery(name = "Management.findAll", query = "SELECT m FROM Management m")
@NamedQuery(name = "Management.findByManagementId", query = "SELECT m FROM Management m WHERE m.managementId = :managementId")
public class Management implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MANAGEMENT_ID")
    private BigDecimal managementId;
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee managerId;

    public Management() {
    }

    public Management(BigDecimal managementId) {
        this.managementId = managementId;
    }

    public BigDecimal getManagementId() {
        return managementId;
    }

    public void setManagementId(BigDecimal managementId) {
        this.managementId = managementId;
    }

    public Employee getManagerId() {
        return managerId;
    }

    public void setManagerId(Employee managerId) {
        this.managerId = managerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (managementId != null ? managementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
     	boolean isEqual = false;
      	
      	if(object instanceof Management) {
      		
      		Management other = (Management) object;
              
      		if ((this.managementId != null && other.managementId != null) && (this.managementId.equals(other.managementId))) {
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
        return "Management[ managementId=" + managementId + " ]";
    }
    
}
