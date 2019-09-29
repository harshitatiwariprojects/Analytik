package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Defines Model.
 * @author Harshita Tiwari
 * Copyright 2019 by Harshita Tiwari. All rights reserved.
 *
 */

@Entity
@Table(name = "SETTLEMENT_CREDIT")
@NamedQuery(name = "SettlementCredit.findAll", query = "SELECT s FROM SettlementCredit s")
@NamedQuery(name = "SettlementCredit.findByCreditId", query = "SELECT s FROM SettlementCredit s WHERE s.creditId = :creditId")
@NamedQuery(name = "SettlementCredit.findByDailyCreditLimit", query = "SELECT s FROM SettlementCredit s WHERE s.dailyCreditLimit = :dailyCreditLimit")
@NamedQuery(name = "SettlementCredit.findByCreditOverdraftAmount", query = "SELECT s FROM SettlementCredit s WHERE s.creditOverdraftAmount = :creditOverdraftAmount")
@NamedQuery(name = "SettlementCredit.findByCreditReserve", query = "SELECT s FROM SettlementCredit s WHERE s.creditReserve = :creditReserve")
@NamedQuery(name = "SettlementCredit.findByNetCreditRequired", query = "SELECT s FROM SettlementCredit s WHERE s.netCreditRequired = :netCreditRequired")
public class SettlementCredit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CREDIT_ID")
    private BigDecimal creditId;
    @Column(name = "DAILY_CREDIT_LIMIT")
    private BigInteger dailyCreditLimit;
    @Column(name = "CREDIT_OVERDRAFT_AMOUNT")
    private BigInteger creditOverdraftAmount;
    @Column(name = "CREDIT_RESERVE")
    private BigInteger creditReserve;
    @Column(name = "NET_CREDIT_REQUIRED")
    private BigInteger netCreditRequired;
    @OneToMany(mappedBy = "creditId")
    private Collection<CreditBalance> creditBalanceCollection;
    @JoinColumn(name = "SETTLEMENT_ID", referencedColumnName = "SETTLEMENT_ID")
    @ManyToOne
    private Settlement settlementId;

    public SettlementCredit() {
    }

    public SettlementCredit(BigDecimal creditId) {
        this.creditId = creditId;
    }

    public BigDecimal getCreditId() {
        return creditId;
    }

    public void setCreditId(BigDecimal creditId) {
        this.creditId = creditId;
    }

    public BigInteger getDailyCreditLimit() {
        return dailyCreditLimit;
    }

    public void setDailyCreditLimit(BigInteger dailyCreditLimit) {
        this.dailyCreditLimit = dailyCreditLimit;
    }

    public BigInteger getCreditOverdraftAmount() {
        return creditOverdraftAmount;
    }

    public void setCreditOverdraftAmount(BigInteger creditOverdraftAmount) {
        this.creditOverdraftAmount = creditOverdraftAmount;
    }

    public BigInteger getCreditReserve() {
        return creditReserve;
    }

    public void setCreditReserve(BigInteger creditReserve) {
        this.creditReserve = creditReserve;
    }

    public BigInteger getNetCreditRequired() {
        return netCreditRequired;
    }

    public void setNetCreditRequired(BigInteger netCreditRequired) {
        this.netCreditRequired = netCreditRequired;
    }

    public Collection<CreditBalance> getCreditBalanceCollection() {
        return creditBalanceCollection;
    }

    public void setCreditBalanceCollection(Collection<CreditBalance> creditBalanceCollection) {
        this.creditBalanceCollection = creditBalanceCollection;
    }

    public Settlement getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(Settlement settlementId) {
        this.settlementId = settlementId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditId != null ? creditId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof SettlementCredit) {
      		
      		SettlementCredit other = (SettlementCredit) object;
              
      		if ((this.creditId != null && other.creditId != null) && (this.creditId.equals(other.creditId))) {
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
        return "SettlementCredit[ creditId=" + creditId + " ]";
    }
    
}
