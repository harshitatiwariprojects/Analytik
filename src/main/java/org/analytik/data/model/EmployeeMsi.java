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
@Table(name = "EMPLOYEE_MSI")
@NamedQuery(name = "EmployeeMsi.findAll", query = "SELECT e FROM EmployeeMsi e")
@NamedQuery(name = "EmployeeMsi.findByMsiId", query = "SELECT e FROM EmployeeMsi e WHERE e.msiId = :msiId")
@NamedQuery(name = "EmployeeMsi.findByPerformanceRating", query = "SELECT e FROM EmployeeMsi e WHERE e.performanceRating = :performanceRating")
@NamedQuery(name = "EmployeeMsi.findByConfirmationDate", query = "SELECT e FROM EmployeeMsi e WHERE e.confirmationDate = :confirmationDate")
@NamedQuery(name = "EmployeeMsi.findByEffectiveDate", query = "SELECT e FROM EmployeeMsi e WHERE e.effectiveDate = :effectiveDate")
@NamedQuery(name = "EmployeeMsi.findByExcepAcceptance", query = "SELECT e FROM EmployeeMsi e WHERE e.excepAcceptance = :excepAcceptance")
public class EmployeeMsi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MSI_ID")
    private BigDecimal msiId;
    @Column(name = "PERFORMANCE_RATING")
    private BigInteger performanceRating;
    @Column(name = "CONFIRMATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date confirmationDate;
    @Column(name = "EFFECTIVE_DATE")
    @Temporal(TemporalType.DATE)
    private Date effectiveDate;
    @Column(name = "EXCEP_ACCEPTANCE")
    private String excepAcceptance;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "EXCEP_ACCEPT_MGR", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee excepAcceptMgr;
    @JoinColumn(name = "CONFIRM_MGR_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee confirmMgrId;
    @JoinColumn(name = "BAND_ID", referencedColumnName = "BAND_ID")
    @ManyToOne(optional = false)
    private SalaryBand bandId;

    public EmployeeMsi() {
    }

    public EmployeeMsi(BigDecimal msiId) {
        this.msiId = msiId;
    }

    public BigDecimal getMsiId() {
        return msiId;
    }

    public void setMsiId(BigDecimal msiId) {
        this.msiId = msiId;
    }

    public BigInteger getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(BigInteger performanceRating) {
        this.performanceRating = performanceRating;
    }

    public Date getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExcepAcceptance() {
        return excepAcceptance;
    }

    public void setExcepAcceptance(String excepAcceptance) {
        this.excepAcceptance = excepAcceptance;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Employee getExcepAcceptMgr() {
        return excepAcceptMgr;
    }

    public void setExcepAcceptMgr(Employee excepAcceptMgr) {
        this.excepAcceptMgr = excepAcceptMgr;
    }

    public Employee getConfirmMgrId() {
        return confirmMgrId;
    }

    public void setConfirmMgrId(Employee confirmMgrId) {
        this.confirmMgrId = confirmMgrId;
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
        hash += (msiId != null ? msiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
      
     	boolean isEqual = false;
      	
      	if(object instanceof EmployeeMsi) {
      		
      		EmployeeMsi other = (EmployeeMsi) object;
              
      		if ((this.msiId != null && other.msiId != null) && (this.msiId.equals(other.msiId))) {
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
        return "EmployeeMsi[ msiId=" + msiId + " ]";
    }
    
}
