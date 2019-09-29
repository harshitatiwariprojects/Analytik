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
@Table(name = "SETTLEMENT_CASH")
@NamedQuery(name = "SettlementCash.findAll", query = "SELECT s FROM SettlementCash s")
@NamedQuery(name = "SettlementCash.findByCashId", query = "SELECT s FROM SettlementCash s WHERE s.cashId = :cashId")
@NamedQuery(name = "SettlementCash.findByDailyCashLimit", query = "SELECT s FROM SettlementCash s WHERE s.dailyCashLimit = :dailyCashLimit")
@NamedQuery(name = "SettlementCash.findByCashOverdraftAmount", query = "SELECT s FROM SettlementCash s WHERE s.cashOverdraftAmount = :cashOverdraftAmount")
@NamedQuery(name = "SettlementCash.findByCashReserve", query = "SELECT s FROM SettlementCash s WHERE s.cashReserve = :cashReserve")
@NamedQuery(name = "SettlementCash.findByNetCashRequired", query = "SELECT s FROM SettlementCash s WHERE s.netCashRequired = :netCashRequired")
public class SettlementCash implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CASH_ID")
    private BigDecimal cashId;
    @Column(name = "DAILY_CASH_LIMIT")
    private BigInteger dailyCashLimit;
    @Column(name = "CASH_OVERDRAFT_AMOUNT")
    private BigInteger cashOverdraftAmount;
    @Column(name = "CASH_RESERVE")
    private BigInteger cashReserve;
    @Column(name = "NET_CASH_REQUIRED")
    private BigInteger netCashRequired;
    @OneToMany(mappedBy = "cashId")
    private Collection<CashBalance> cashBalanceCollection;
    @JoinColumn(name = "SETTLEMENT_ID", referencedColumnName = "SETTLEMENT_ID")
    @ManyToOne
    private Settlement settlementId;

    public SettlementCash() {
    }

    public SettlementCash(BigDecimal cashId) {
        this.cashId = cashId;
    }

    public BigDecimal getCashId() {
        return cashId;
    }

    public void setCashId(BigDecimal cashId) {
        this.cashId = cashId;
    }

    public BigInteger getDailyCashLimit() {
        return dailyCashLimit;
    }

    public void setDailyCashLimit(BigInteger dailyCashLimit) {
        this.dailyCashLimit = dailyCashLimit;
    }

    public BigInteger getCashOverdraftAmount() {
        return cashOverdraftAmount;
    }

    public void setCashOverdraftAmount(BigInteger cashOverdraftAmount) {
        this.cashOverdraftAmount = cashOverdraftAmount;
    }

    public BigInteger getCashReserve() {
        return cashReserve;
    }

    public void setCashReserve(BigInteger cashReserve) {
        this.cashReserve = cashReserve;
    }

    public BigInteger getNetCashRequired() {
        return netCashRequired;
    }

    public void setNetCashRequired(BigInteger netCashRequired) {
        this.netCashRequired = netCashRequired;
    }

    public Collection<CashBalance> getCashBalanceCollection() {
        return cashBalanceCollection;
    }

    public void setCashBalanceCollection(Collection<CashBalance> cashBalanceCollection) {
        this.cashBalanceCollection = cashBalanceCollection;
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
        hash += (cashId != null ? cashId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof SettlementCash) {
      		
      		SettlementCash other = (SettlementCash) object;
              
      		if ((this.cashId != null && other.cashId != null) && (this.cashId.equals(other.cashId))) {
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
        return "SettlementCash[ cashId=" + cashId + " ]";
    }
    
}
