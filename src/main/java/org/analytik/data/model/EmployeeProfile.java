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
@Table(name = "EMPLOYEEPROFILE")
@NamedQuery(name = "Employeeprofile.findAll", query = "SELECT e FROM EmployeeProfile e")
@NamedQuery(name = "Employeeprofile.findByEmployeeprofileId", query = "SELECT e FROM EmployeeProfile e WHERE e.employeeProfileId = :employeeProfileId")
@NamedQuery(name = "Employeeprofile.findByAddressId", query = "SELECT e FROM EmployeeProfile e WHERE e.addressId = :addressId")
public class EmployeeProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEEPROFILE_ID")
    private BigDecimal employeeProfileId;
    @Column(name = "ADDRESS_ID")
    private BigInteger addressId;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee employeeId;
    @JoinColumn(name = "SKILLID1", referencedColumnName = "SKILLID")
    @ManyToOne
    private Skillset skillid1;
    @JoinColumn(name = "SKILLID3", referencedColumnName = "SKILLID")
    @ManyToOne
    private Skillset skillid3;
    @JoinColumn(name = "SKILLID2", referencedColumnName = "SKILLID")
    @ManyToOne
    private Skillset skillid2;

    public EmployeeProfile() {
    }

    public EmployeeProfile(BigDecimal employeeProfileId) {
        this.employeeProfileId = employeeProfileId;
    }

    public BigDecimal getEmployeeprofileId() {
        return employeeProfileId;
    }

    public void setEmployeeprofileId(BigDecimal employeeprofileId) {
        this.employeeProfileId = employeeprofileId;
    }

    public BigInteger getAddressId() {
        return addressId;
    }

    public void setAddressId(BigInteger addressId) {
        this.addressId = addressId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Skillset getSkillid1() {
        return skillid1;
    }

    public void setSkillid1(Skillset skillid1) {
        this.skillid1 = skillid1;
    }

    public Skillset getSkillid3() {
        return skillid3;
    }

    public void setSkillid3(Skillset skillid3) {
        this.skillid3 = skillid3;
    }

    public Skillset getSkillid2() {
        return skillid2;
    }

    public void setSkillid2(Skillset skillid2) {
        this.skillid2 = skillid2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeProfileId != null ? employeeProfileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
     	boolean isEqual = false;
      	
      	if(object instanceof EmployeeProfile) {
      		
      		EmployeeProfile other = (EmployeeProfile) object;
              
      		if ((this.employeeProfileId != null && other.employeeProfileId != null) && (this.employeeProfileId.equals(other.employeeProfileId))) {
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
        return "Employeeprofile[ employeeprofileId=" + employeeProfileId + " ]";
    }
    
}
