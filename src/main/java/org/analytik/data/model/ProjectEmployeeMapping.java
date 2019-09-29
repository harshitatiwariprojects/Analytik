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
@Table(name = "PROJECT_EMPLOYEE_MAPPING")
@NamedQuery(name = "ProjectEmployeeMapping.findAll", query = "SELECT p FROM ProjectEmployeeMapping p")
@NamedQuery(name = "ProjectEmployeeMapping.findByPemid", query = "SELECT p FROM ProjectEmployeeMapping p WHERE p.pemId = :pemId")
public class ProjectEmployeeMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PEMID")
    private BigDecimal pemId;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee employeeId;
    @JoinColumn(name = "PROJECT_CODE", referencedColumnName = "PROJECT_CODE")
    @ManyToOne
    private Project projectCode;

    public ProjectEmployeeMapping() {
    }

    public ProjectEmployeeMapping(BigDecimal pemId) {
        this.pemId = pemId;
    }

    public BigDecimal getPemId() {
        return pemId;
    }

    public void setPemId(BigDecimal pemId) {
        this.pemId = pemId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Project getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(Project projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pemId != null ? pemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof ProjectEmployeeMapping) {
      		
      		ProjectEmployeeMapping other = (ProjectEmployeeMapping) object;
              
      		if ((this.pemId != null && other.pemId != null) && (this.pemId.equals(other.pemId))) {
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
        return "ProjectEmployeeMapping[ pemId=" + pemId + " ]";
    }
    
}
