package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "BILLING")
@NamedQuery(name = "Billing.findAll", query = "SELECT b FROM Billing b")
@NamedQuery(name = "Billing.findByBillingId", query = "SELECT b FROM Billing b WHERE b.billingId = :billingId")
@NamedQuery(name = "Billing.findByInvoiceDate", query = "SELECT b FROM Billing b WHERE b.invoiceDate = :invoiceDate")
@NamedQuery(name = "Billing.findBySettlementDate", query = "SELECT b FROM Billing b WHERE b.settlementDate = :settlementDate")
@NamedQuery(name = "Billing.findByPenaltyAccrual", query = "SELECT b FROM Billing b WHERE b.penaltyAccrual = :penaltyAccrual")
@NamedQuery(name = "Billing.findByInterestAccrual", query = "SELECT b FROM Billing b WHERE b.interestAccrual = :interestAccrual")
@NamedQuery(name = "Billing.findBySettlementcycle", query = "SELECT b FROM Billing b WHERE b.settlementcycle = :settlementcycle")
@NamedQuery(name = "Billing.findByAmount", query = "SELECT b FROM Billing b WHERE b.amount = :amount")
public class Billing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BILLING_ID")
    private BigDecimal billingId;
    @Column(name = "INVOICE_DATE")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    @Column(name = "SETTLEMENT_DATE")
    @Temporal(TemporalType.DATE)
    private Date settlementDate;
    @Column(name = "PENALTY_ACCRUAL")
    private String penaltyAccrual;
    @Column(name = "INTEREST_ACCRUAL")
    private String interestAccrual;
    @Column(name = "SETTLEMENTCYCLE")
    private String settlementcycle;
    @Column(name = "AMOUNT")
    private BigInteger amount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billingId")
    private Collection<ProjectBillingEmployee> projectBillingEmployeeCollection;
    @JoinColumn(name = "CUSTOMER_CODE", referencedColumnName = "CUSTOMER_CODE")
    @ManyToOne(optional = false)
    private Customer customerCode;
    @JoinColumn(name = "CUSTOMER_BILLING_CODE", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(optional = false)
    private Employee customerBillingCode;

    public Billing() {
    }

    public Billing(BigDecimal billingId) {
        this.billingId = billingId;
    }

    public BigDecimal getBillingId() {
        return billingId;
    }

    public void setBillingId(BigDecimal billingId) {
        this.billingId = billingId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getPenaltyAccrual() {
        return penaltyAccrual;
    }

    public void setPenaltyAccrual(String penaltyAccrual) {
        this.penaltyAccrual = penaltyAccrual;
    }

    public String getInterestAccrual() {
        return interestAccrual;
    }

    public void setInterestAccrual(String interestAccrual) {
        this.interestAccrual = interestAccrual;
    }

    public String getSettlementcycle() {
        return settlementcycle;
    }

    public void setSettlementcycle(String settlementcycle) {
        this.settlementcycle = settlementcycle;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public Collection<ProjectBillingEmployee> getProjectBillingEmployeeCollection() {
        return projectBillingEmployeeCollection;
    }

    public void setProjectBillingEmployeeCollection(Collection<ProjectBillingEmployee> projectBillingEmployeeCollection) {
        this.projectBillingEmployeeCollection = projectBillingEmployeeCollection;
    }

    public Customer getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(Customer customerCode) {
        this.customerCode = customerCode;
    }

    public Employee getCustomerBillingCode() {
        return customerBillingCode;
    }

    public void setCustomerBillingCode(Employee customerBillingCode) {
        this.customerBillingCode = customerBillingCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billingId != null ? billingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
    	boolean isEqual = false;
    	
    	if(object instanceof Billing) {
    		
    		Billing other = (Billing) object;
            
    		if ((this.billingId != null && other.billingId != null) && (this.billingId.equals(other.billingId))) {
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
        return "Billing[ billingId=" + billingId + " ]";
    }
    
}
