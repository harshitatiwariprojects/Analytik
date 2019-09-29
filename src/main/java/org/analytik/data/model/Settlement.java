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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SETTLEMENT")
@NamedQuery(name = "Settlement.findAll", query = "SELECT s FROM Settlement s")
@NamedQuery(name = "Settlement.findBySettlementId", query = "SELECT s FROM Settlement s WHERE s.settlementId = :settlementId")
@NamedQuery(name = "Settlement.findBySettlementDueDate", query = "SELECT s FROM Settlement s WHERE s.settlementDueDate = :settlementDueDate")
@NamedQuery(name = "Settlement.findBySettlementAmount", query = "SELECT s FROM Settlement s WHERE s.settlementAmount = :settlementAmount")
@NamedQuery(name = "Settlement.findBySettlementCycle", query = "SELECT s FROM Settlement s WHERE s.settlementCycle = :settlementCycle")
@NamedQuery(name = "Settlement.findBySettlementType", query = "SELECT s FROM Settlement s WHERE s.settlementType = :settlementType")
@NamedQuery(name = "Settlement.findBySettlementFrequencyType", query = "SELECT s FROM Settlement s WHERE s.settlementFrequencyType = :settlementFrequencyType")
@NamedQuery(name = "Settlement.findByClassificationType", query = "SELECT s FROM Settlement s WHERE s.classificationType = :classificationType")
@NamedQuery(name = "Settlement.findBySettlementStatus", query = "SELECT s FROM Settlement s WHERE s.settlementStatus = :settlementStatus")
public class Settlement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SETTLEMENT_ID")
    private BigDecimal settlementId;
    @Column(name = "SETTLEMENT_DUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date settlementDueDate;
    @Column(name = "SETTLEMENT_AMOUNT")
    private BigInteger settlementAmount;
    @Column(name = "SETTLEMENT_CYCLE")
    private String settlementCycle;
    @Column(name = "SETTLEMENT_TYPE")
    private String settlementType;
    @Column(name = "SETTLEMENT_FREQUENCY_TYPE")
    private String settlementFrequencyType;
    @Column(name = "CLASSIFICATION_TYPE")
    private String classificationType;
    @Column(name = "SETTLEMENT_STATUS")
    private String settlementStatus;
    @OneToMany(mappedBy = "settlementId")
    private Collection<SettlementCredit> settlementCreditCollection;
    @JoinColumn(name = "INVOICE_ID", referencedColumnName = "INVOICE_ID")
    @ManyToOne
    private Invoice invoiceId;
    @OneToMany(mappedBy = "settlementId")
    private Collection<SettlementCash> settlementCashCollection;
    @OneToMany(mappedBy = "settlementId")
    private Collection<Fulfillment> fulfillmentCollection;

    public Settlement() {
    }

    public Settlement(BigDecimal settlementId) {
        this.settlementId = settlementId;
    }

    public BigDecimal getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(BigDecimal settlementId) {
        this.settlementId = settlementId;
    }

    public Date getSettlementDueDate() {
        return settlementDueDate;
    }

    public void setSettlementDueDate(Date settlementDueDate) {
        this.settlementDueDate = settlementDueDate;
    }

    public BigInteger getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(BigInteger settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public String getSettlementCycle() {
        return settlementCycle;
    }

    public void setSettlementCycle(String settlementCycle) {
        this.settlementCycle = settlementCycle;
    }

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

    public String getSettlementFrequencyType() {
        return settlementFrequencyType;
    }

    public void setSettlementFrequencyType(String settlementFrequencyType) {
        this.settlementFrequencyType = settlementFrequencyType;
    }

    public String getClassificationType() {
        return classificationType;
    }

    public void setClassificationType(String classificationType) {
        this.classificationType = classificationType;
    }

    public String getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(String settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public Collection<SettlementCredit> getSettlementCreditCollection() {
        return settlementCreditCollection;
    }

    public void setSettlementCreditCollection(Collection<SettlementCredit> settlementCreditCollection) {
        this.settlementCreditCollection = settlementCreditCollection;
    }

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Collection<SettlementCash> getSettlementCashCollection() {
        return settlementCashCollection;
    }

    public void setSettlementCashCollection(Collection<SettlementCash> settlementCashCollection) {
        this.settlementCashCollection = settlementCashCollection;
    }

    public Collection<Fulfillment> getFulfillmentCollection() {
        return fulfillmentCollection;
    }

    public void setFulfillmentCollection(Collection<Fulfillment> fulfillmentCollection) {
        this.fulfillmentCollection = fulfillmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (settlementId != null ? settlementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
      
    	boolean isEqual = false;
      	
      	if(object instanceof Settlement) {
      		
      		Settlement other = (Settlement) object;
              
      		if ((this.settlementId != null && other.settlementId != null) && (this.settlementId.equals(other.settlementId))) {
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
        return "Settlement[ settlementId=" + settlementId + " ]";
    }
    
}
