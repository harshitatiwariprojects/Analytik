package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "INVOICE")
@NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i")
@NamedQuery(name = "Invoice.findByInvoiceNo", query = "SELECT i FROM Invoice i WHERE i.invoiceNo = :invoiceNo")
@NamedQuery(name = "Invoice.findByInvoiceType", query = "SELECT i FROM Invoice i WHERE i.invoiceType = :invoiceType")
@NamedQuery(name = "Invoice.findByInvoiceDate", query = "SELECT i FROM Invoice i WHERE i.invoiceDate = :invoiceDate")
@NamedQuery(name = "Invoice.findByInvoiceAmount", query = "SELECT i FROM Invoice i WHERE i.invoiceAmount = :invoiceAmount")
@NamedQuery(name = "Invoice.findByPenaltyAccrualAmount", query = "SELECT i FROM Invoice i WHERE i.penaltyAccrualAmount = :penaltyAccrualAmount")
@NamedQuery(name = "Invoice.findByInterestAccrualAmount", query = "SELECT i FROM Invoice i WHERE i.interestAccrualAmount = :interestAccrualAmount")
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "INVOICE_ID")
    private BigDecimal invoiceId;
    @Column(name = "INVOICE_NO")
    private BigInteger invoiceNo;
    @Column(name = "INVOICE_TYPE")
    private String invoiceType;
    @Column(name = "INVOICE_DATE")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    @Column(name = "INVOICE_AMOUNT")
    private BigInteger invoiceAmount;
    @Column(name = "PENALTY_ACCRUAL_AMOUNT")
    private BigInteger penaltyAccrualAmount;
    @Column(name = "INTEREST_ACCRUAL_AMOUNT")
    private BigInteger interestAccrualAmount;
    @OneToMany(mappedBy = "invoiceId")
    private Collection<Settlement> settlementCollection;

    public Invoice() {
    }

    public Invoice(BigDecimal invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BigDecimal getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(BigDecimal invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BigInteger getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(BigInteger invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigInteger getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigInteger invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public BigInteger getPenaltyAccrualAmount() {
        return penaltyAccrualAmount;
    }

    public void setPenaltyAccrualAmount(BigInteger penaltyAccrualAmount) {
        this.penaltyAccrualAmount = penaltyAccrualAmount;
    }

    public BigInteger getInterestAccrualAmount() {
        return interestAccrualAmount;
    }

    public void setInterestAccrualAmount(BigInteger interestAccrualAmount) {
        this.interestAccrualAmount = interestAccrualAmount;
    }

    public Collection<Settlement> getSettlementCollection() {
        return settlementCollection;
    }

    public void setSettlementCollection(Collection<Settlement> settlementCollection) {
        this.settlementCollection = settlementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceId != null ? invoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
     	boolean isEqual = false;
      	
      	if(object instanceof Invoice) {
      		
      		Invoice other = (Invoice) object;
              
      		if ((this.invoiceId != null && other.invoiceId != null) && (this.invoiceId.equals(other.invoiceId))) {
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
        return "Invoice[ invoiceId=" + invoiceId + " ]";
    }
    
}
