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
@Table(name = "EMPLOYEE_PROMOTION")
@NamedQuery(name = "EmployeePromotion.findAll", query = "SELECT e FROM EmployeePromotion e")
@NamedQuery(name = "EmployeePromotion.findByPromotionId", query = "SELECT e FROM EmployeePromotion e WHERE e.promotionId = :promotionId")
@NamedQuery(name = "EmployeePromotion.findByPerformanceRating", query = "SELECT e FROM EmployeePromotion e WHERE e.performanceRating = :performanceRating")
@NamedQuery(name = "EmployeePromotion.findByConfirmationDate", query = "SELECT e FROM EmployeePromotion e WHERE e.confirmationDate = :confirmationDate")
@NamedQuery(name = "EmployeePromotion.findByEffectiveDate", query = "SELECT e FROM EmployeePromotion e WHERE e.effectiveDate = :effectiveDate")
@NamedQuery(name = "EmployeePromotion.findByExcepAcceptance", query = "SELECT e FROM EmployeePromotion e WHERE e.excepAcceptance = :excepAcceptance")
public class EmployeePromotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROMOTION_ID")
    private BigDecimal promotionId;
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

    public EmployeePromotion() {
    }

    public EmployeePromotion(BigDecimal promotionId) {
        this.promotionId = promotionId;
    }

    public BigDecimal getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(BigDecimal promotionId) {
        this.promotionId = promotionId;
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
        hash += (promotionId != null ? promotionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
     	boolean isEqual = false;
      	
      	if(object instanceof EmployeePromotion) {
      		
      		EmployeePromotion other = (EmployeePromotion) object;
              
      		if ((this.promotionId != null && other.promotionId != null) && (this.promotionId.equals(other.promotionId))) {
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
        return "EmployeePromotion[ promotionId=" + promotionId + " ]";
    }
    
}
