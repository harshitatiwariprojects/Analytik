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
@Table(name = "EMPLOYEE_BONUS")
@NamedQuery(name = "EmployeeBonus.findAll", query = "SELECT e FROM EmployeeBonus e")
@NamedQuery(name = "EmployeeBonus.findByBonusId", query = "SELECT e FROM EmployeeBonus e WHERE e.bonusId = :bonusId")
@NamedQuery(name = "EmployeeBonus.findByBonusType", query = "SELECT e FROM EmployeeBonus e WHERE e.bonusType = :bonusType")
@NamedQuery(name = "EmployeeBonus.findByBonusAmount", query = "SELECT e FROM EmployeeBonus e WHERE e.bonusAmount = :bonusAmount")
@NamedQuery(name = "EmployeeBonus.findByConfirmationDate", query = "SELECT e FROM EmployeeBonus e WHERE e.confirmationDate = :confirmationDate")
@NamedQuery(name = "EmployeeBonus.findByEffectiveDate", query = "SELECT e FROM EmployeeBonus e WHERE e.effectiveDate = :effectiveDate")
@NamedQuery(name = "EmployeeBonus.findByExcepAcceptance", query = "SELECT e FROM EmployeeBonus e WHERE e.excepAcceptance = :excepAcceptance")
@NamedQuery(name = "EmployeeBonus.findByBillabilityScore", query = "SELECT e FROM EmployeeBonus e WHERE e.billabilityScore = :billabilityScore")
public class EmployeeBonus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BONUS_ID")
    private BigDecimal bonusId;
    @Column(name = "BONUS_TYPE")
    private String bonusType;
    @Column(name = "BONUS_AMOUNT")
    private BigInteger bonusAmount;
    @Column(name = "CONFIRMATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date confirmationDate;
    @Column(name = "EFFECTIVE_DATE")
    @Temporal(TemporalType.DATE)
    private Date effectiveDate;
    @Column(name = "EXCEP_ACCEPTANCE")
    private String excepAcceptance;
    @Column(name = "BILLABILITY_SCORE")
    private BigInteger billabilityScore;
    @JoinColumn(name = "CONFIRM_MGR_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(optional = false)
    private Employee confirmMgrId;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "EXCEP_ACCEPT_MGR", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee excepAcceptMgr;
    @JoinColumn(name = "BAND_ID", referencedColumnName = "BAND_ID")
    @ManyToOne(optional = false)
    private SalaryBand bandId;

    public EmployeeBonus() {
    }

    public EmployeeBonus(BigDecimal bonusId) {
        this.bonusId = bonusId;
    }

    public BigDecimal getBonusId() {
        return bonusId;
    }

    public void setBonusId(BigDecimal bonusId) {
        this.bonusId = bonusId;
    }

    public String getBonusType() {
        return bonusType;
    }

    public void setBonusType(String bonusType) {
        this.bonusType = bonusType;
    }

    public BigInteger getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(BigInteger bonusAmount) {
        this.bonusAmount = bonusAmount;
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

    public BigInteger getBillabilityScore() {
        return billabilityScore;
    }

    public void setBillabilityScore(BigInteger billabilityScore) {
        this.billabilityScore = billabilityScore;
    }

    public Employee getConfirmMgrId() {
        return confirmMgrId;
    }

    public void setConfirmMgrId(Employee confirmMgrId) {
        this.confirmMgrId = confirmMgrId;
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

    public SalaryBand getBandId() {
        return bandId;
    }

    public void setBandId(SalaryBand bandId) {
        this.bandId = bandId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bonusId != null ? bonusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
     	boolean isEqual = false;
      	
      	if(object instanceof EmployeeBonus) {
      		
      		EmployeeBonus other = (EmployeeBonus) object;
              
      		if ((this.bonusId != null && other.bonusId != null) && (this.bonusId.equals(other.bonusId))) {
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
        return "EmployeeBonus[ bonusId=" + bonusId + " ]";
    }
    
}
