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
@Table(name = "CREDIT_BALANCE")
@NamedQuery(name = "CreditBalance.findAll", query = "SELECT c FROM CreditBalance c")
@NamedQuery(name = "CreditBalance.findByCreditBalanceId", query = "SELECT c FROM CreditBalance c WHERE c.creditBalanceId = :creditBalanceId")
@NamedQuery(name = "CreditBalance.findByOpeningBalance", query = "SELECT c FROM CreditBalance c WHERE c.openingBalance = :openingBalance")
@NamedQuery(name = "CreditBalance.findByClosingBalance", query = "SELECT c FROM CreditBalance c WHERE c.closingBalance = :closingBalance")
@NamedQuery(name = "CreditBalance.findBySundryDebtorAmount", query = "SELECT c FROM CreditBalance c WHERE c.sundryDebtorAmount = :sundryDebtorAmount")
@NamedQuery(name = "CreditBalance.findBySundryCreditorAmount", query = "SELECT c FROM CreditBalance c WHERE c.sundryCreditorAmount = :sundryCreditorAmount")
@NamedQuery(name = "CreditBalance.findByCreditBalanceDate", query = "SELECT c FROM CreditBalance c WHERE c.creditBalanceDate = :creditBalanceDate")
@NamedQuery(name = "CreditBalance.findByCreditInHand", query = "SELECT c FROM CreditBalance c WHERE c.creditInHand = :creditInHand")
public class CreditBalance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CREDIT_BALANCE_ID")
    private BigDecimal creditBalanceId;
    @Column(name = "OPENING_BALANCE")
    private BigInteger openingBalance;
    @Column(name = "CLOSING_BALANCE")
    private BigInteger closingBalance;
    @Column(name = "SUNDRY_DEBTOR_AMOUNT")
    private BigInteger sundryDebtorAmount;
    @Column(name = "SUNDRY_CREDITOR_AMOUNT")
    private BigInteger sundryCreditorAmount;
    @Column(name = "CREDIT_BALANCE_DATE")
    @Temporal(TemporalType.DATE)
    private Date creditBalanceDate;
    @Column(name = "CREDIT_IN_HAND")
    private BigInteger creditInHand;
    @JoinColumn(name = "CREDIT_ID", referencedColumnName = "CREDIT_ID")
    @ManyToOne
    private SettlementCredit creditId;

    public CreditBalance() {
    }

    public CreditBalance(BigDecimal creditBalanceId) {
        this.creditBalanceId = creditBalanceId;
    }

    public BigDecimal getCreditBalanceId() {
        return creditBalanceId;
    }

    public void setCreditBalanceId(BigDecimal creditBalanceId) {
        this.creditBalanceId = creditBalanceId;
    }

    public BigInteger getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(BigInteger openingBalance) {
        this.openingBalance = openingBalance;
    }

    public BigInteger getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(BigInteger closingBalance) {
        this.closingBalance = closingBalance;
    }

    public BigInteger getSundryDebtorAmount() {
        return sundryDebtorAmount;
    }

    public void setSundryDebtorAmount(BigInteger sundryDebtorAmount) {
        this.sundryDebtorAmount = sundryDebtorAmount;
    }

    public BigInteger getSundryCreditorAmount() {
        return sundryCreditorAmount;
    }

    public void setSundryCreditorAmount(BigInteger sundryCreditorAmount) {
        this.sundryCreditorAmount = sundryCreditorAmount;
    }

    public Date getCreditBalanceDate() {
        return creditBalanceDate;
    }

    public void setCreditBalanceDate(Date creditBalanceDate) {
        this.creditBalanceDate = creditBalanceDate;
    }

    public BigInteger getCreditInHand() {
        return creditInHand;
    }

    public void setCreditInHand(BigInteger creditInHand) {
        this.creditInHand = creditInHand;
    }

    public SettlementCredit getCreditId() {
        return creditId;
    }

    public void setCreditId(SettlementCredit creditId) {
        this.creditId = creditId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditBalanceId != null ? creditBalanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
    	boolean isEqual = false;
     	
     	if(object instanceof CreditBalance) {
     		
     		CreditBalance other = (CreditBalance) object;
             
     		if ((this.creditBalanceId != null && other.creditBalanceId != null) && (this.creditBalanceId.equals(other.creditBalanceId))) {
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
        return "CreditBalance[ creditBalanceId=" + creditBalanceId + " ]";
    }
    
}
