package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "EMPLOYEEDETAIL")
@NamedQuery(name = "EmployeeDetail.findAll", query = "SELECT e FROM EmployeeDetail e")
@NamedQuery(name = "EmployeeDetail.findByEmployeedetailId", query = "SELECT e FROM EmployeeDetail e WHERE e.employeeDetailId = :employeeDetailId")
@NamedQuery(name = "EmployeeDetail.findByFirstname", query = "SELECT e FROM EmployeeDetail e WHERE e.firstname = :firstname")
@NamedQuery(name = "EmployeeDetail.findByLastname", query = "SELECT e FROM EmployeeDetail e WHERE e.lastname = :lastname")
@NamedQuery(name = "EmployeeDetail.findByMiddlename", query = "SELECT e FROM EmployeeDetail e WHERE e.middlename = :middlename")
@NamedQuery(name = "EmployeeDetail.findByGender", query = "SELECT e FROM EmployeeDetail e WHERE e.gender = :gender")
@NamedQuery(name = "EmployeeDetail.findByDob", query = "SELECT e FROM EmployeeDetail e WHERE e.dob = :dob")
@NamedQuery(name = "EmployeeDetail.findByPhonenumber", query = "SELECT e FROM EmployeeDetail e WHERE e.phonenumber = :phonenumber")
@NamedQuery(name = "EmployeeDetail.findByEmail", query = "SELECT e FROM EmployeeDetail e WHERE e.email = :email")
@NamedQuery(name = "EmployeeDetail.findByHireDate", query = "SELECT e FROM EmployeeDetail e WHERE e.hireDate = :hireDate")
@NamedQuery(name = "EmployeeDetail.findByBandStartDate", query = "SELECT e FROM EmployeeDetail e WHERE e.bandStartDate = :bandStartDate")
@NamedQuery(name = "EmployeeDetail.findByBandEndDate", query = "SELECT e FROM EmployeeDetail e WHERE e.bandEndDate = :bandEndDate")
@NamedQuery(name = "EmployeeDetail.findBySalary", query = "SELECT e FROM EmployeeDetail e WHERE e.salary = :salary")
@NamedQuery(name = "EmployeeDetail.findByBonus", query = "SELECT e FROM EmployeeDetail e WHERE e.bonus = :bonus")
@NamedQuery(name = "EmployeeDetail.findByAddress", query = "SELECT e FROM EmployeeDetail e WHERE e.address = :address")
public class EmployeeDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEEDETAIL_ID")
    private BigDecimal employeeDetailId;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "MIDDLENAME")
    private String middlename;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "PHONENUMBER")
    private BigInteger phonenumber;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "HIRE_DATE")
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @Column(name = "BAND_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date bandStartDate;
    @Column(name = "BAND_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date bandEndDate;
    @Column(name = "SALARY")
    private BigInteger salary;
    @Column(name = "BONUS")
    private BigInteger bonus;
    @Column(name = "ADDRESS")
    private String address;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee employeeId;
    @JoinColumn(name = "BAND_ID", referencedColumnName = "BAND_ID")
    @ManyToOne
    private SalaryBand bandId;

    public EmployeeDetail() {
    }

    public EmployeeDetail(BigDecimal employeeDetailId) {
        this.employeeDetailId = employeeDetailId;
    }

    public BigDecimal getEmployeedetailId() {
        return employeeDetailId;
    }

    public void setEmployeedetailId(BigDecimal employeeDetailId) {
        this.employeeDetailId = employeeDetailId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public BigInteger getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(BigInteger phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getBandStartDate() {
        return bandStartDate;
    }

    public void setBandStartDate(Date bandStartDate) {
        this.bandStartDate = bandStartDate;
    }

    public Date getBandEndDate() {
        return bandEndDate;
    }

    public void setBandEndDate(Date bandEndDate) {
        this.bandEndDate = bandEndDate;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    public BigInteger getBonus() {
        return bonus;
    }

    public void setBonus(BigInteger bonus) {
        this.bonus = bonus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public SalaryBand getBandId() {
        return bandId;
    }

    public void setBandId(SalaryBand bandId) {
        this.bandId = bandId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeDetailId != null ? employeeDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
     	boolean isEqual = false;
      	
      	if(object instanceof EmployeeDetail) {
      		
      		EmployeeDetail other = (EmployeeDetail) object;
              
      		if ((this.employeeDetailId != null && other.employeeDetailId != null) && (this.employeeDetailId.equals(other.employeeDetailId))) {
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
        return "Employeedetail[ employeeDetailId=" + employeeDetailId + " ]";
    }
    
}
