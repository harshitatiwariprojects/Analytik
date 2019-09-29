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
@Table(name = "CASH_BALANCE")
@NamedQuery(name = "CashBalance.findAll", query = "SELECT c FROM CashBalance c")
@NamedQuery(name = "CashBalance.findByCashBalanceId", query = "SELECT c FROM CashBalance c WHERE c.cashBalanceId = :cashBalanceId")
@NamedQuery(name = "CashBalance.findByOpeningBalance", query = "SELECT c FROM CashBalance c WHERE c.openingBalance = :openingBalance")
@NamedQuery(name = "CashBalance.findByClosingBalance", query = "SELECT c FROM CashBalance c WHERE c.closingBalance = :closingBalance")
@NamedQuery(name = "CashBalance.findBySundryDebtorAmount", query = "SELECT c FROM CashBalance c WHERE c.sundryDebtorAmount = :sundryDebtorAmount")
@NamedQuery(name = "CashBalance.findBySundryCreditorAmount", query = "SELECT c FROM CashBalance c WHERE c.sundryCreditorAmount = :sundryCreditorAmount")
@NamedQuery(name = "CashBalance.findByCashBalanceDate", query = "SELECT c FROM CashBalance c WHERE c.cashBalanceDate = :cashBalanceDate")
@NamedQuery(name = "CashBalance.findByCashInHand", query = "SELECT c FROM CashBalance c WHERE c.cashInHand = :cashInHand")
public class CashBalance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CASH_BALANCE_ID")
    private BigDecimal cashBalanceId;
    @Column(name = "OPENING_BALANCE")
    private BigInteger openingBalance;
    @Column(name = "CLOSING_BALANCE")
    private BigInteger closingBalance;
    @Column(name = "SUNDRY_DEBTOR_AMOUNT")
    private BigInteger sundryDebtorAmount;
    @Column(name = "SUNDRY_CREDITOR_AMOUNT")
    private BigInteger sundryCreditorAmount;
    @Column(name = "CASH_BALANCE_DATE")
    @Temporal(TemporalType.DATE)
    private Date cashBalanceDate;
    @Column(name = "CASH_IN_HAND")
    @Temporal(TemporalType.DATE)
    private Date cashInHand;
    @JoinColumn(name = "CASH_ID", referencedColumnName = "CASH_ID")
    @ManyToOne
    private SettlementCash cashId;

    public CashBalance() {
    }

    public CashBalance(BigDecimal cashBalanceId) {
        this.cashBalanceId = cashBalanceId;
    }

    public BigDecimal getCashBalanceId() {
        return cashBalanceId;
    }

    public void setCashBalanceId(BigDecimal cashBalanceId) {
        this.cashBalanceId = cashBalanceId;
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

    public Date getCashBalanceDate() {
        return cashBalanceDate;
    }

    public void setCashBalanceDate(Date cashBalanceDate) {
        this.cashBalanceDate = cashBalanceDate;
    }

    public Date getCashInHand() {
        return cashInHand;
    }

    public void setCashInHand(Date cashInHand) {
        this.cashInHand = cashInHand;
    }

    public SettlementCash getCashId() {
        return cashId;
    }

    public void setCashId(SettlementCash cashId) {
        this.cashId = cashId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cashBalanceId != null ? cashBalanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	    	
    	boolean isEqual = false;
    	
    	if(object instanceof CashBalance) {
    		
    		CashBalance other = (CashBalance) object;
            
    		if ((this.cashBalanceId != null && other.cashBalanceId != null) && (this.cashBalanceId.equals(other.cashBalanceId))) {
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
        return "CashBalance[ cashBalanceId=" + cashBalanceId + " ]";
    }
    
}
