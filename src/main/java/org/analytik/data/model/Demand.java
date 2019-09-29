package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "DEMAND")
@NamedQuery(name = "Demand.findAll", query = "SELECT d FROM Demand d")
@NamedQuery(name = "Demand.findByDemandId", query = "SELECT d FROM Demand d WHERE d.demandId = :demandId")
@NamedQuery(name = "Demand.findByOrderBookedDate", query = "SELECT d FROM Demand d WHERE d.orderBookedDate = :orderBookedDate")
@NamedQuery(name = "Demand.findByOrderArrivalDate", query = "SELECT d FROM Demand d WHERE d.orderArrivalDate = :orderArrivalDate")
@NamedQuery(name = "Demand.findByOrderCategory", query = "SELECT d FROM Demand d WHERE d.orderCategory = :orderCategory")
@NamedQuery(name = "Demand.findByOrderStatus", query = "SELECT d FROM Demand d WHERE d.orderStatus = :orderStatus")
@NamedQuery(name = "Demand.findByOrderExpirationDate", query = "SELECT d FROM Demand d WHERE d.orderExpirationDate = :orderExpirationDate")
@NamedQuery(name = "Demand.findByPaymentStatus", query = "SELECT d FROM Demand d WHERE d.paymentStatus = :paymentStatus")
public class Demand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DEMAND_ID")
    private BigDecimal demandId;
    @Column(name = "ORDER_BOOKED_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderBookedDate;
    @Column(name = "ORDER_ARRIVAL_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderArrivalDate;
    @Column(name = "ORDER_CATEGORY")
    private String orderCategory;
    @Column(name = "ORDER_STATUS")
    private String orderStatus;
    @Column(name = "ORDER_EXPIRATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderExpirationDate;
    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;
    @JoinColumn(name = "BU_ID", referencedColumnName = "BU_ID")
    @ManyToOne
    private Bu buId;
    @JoinColumn(name = "CUSTOMER_CODE", referencedColumnName = "CUSTOMER_CODE")
    @ManyToOne(optional = false)
    private Customer customerCode;
    @JoinColumn(name = "BU_CONTACT_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee buContactId;

    public Demand() {
    }

    public Demand(BigDecimal demandId) {
        this.demandId = demandId;
    }

    public BigDecimal getDemandId() {
        return demandId;
    }

    public void setDemandId(BigDecimal demandId) {
        this.demandId = demandId;
    }

    public Date getOrderBookedDate() {
        return orderBookedDate;
    }

    public void setOrderBookedDate(Date orderBookedDate) {
        this.orderBookedDate = orderBookedDate;
    }

    public Date getOrderArrivalDate() {
        return orderArrivalDate;
    }

    public void setOrderArrivalDate(Date orderArrivalDate) {
        this.orderArrivalDate = orderArrivalDate;
    }

    public String getOrderCategory() {
        return orderCategory;
    }

    public void setOrderCategory(String orderCategory) {
        this.orderCategory = orderCategory;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderExpirationDate() {
        return orderExpirationDate;
    }

    public void setOrderExpirationDate(Date orderExpirationDate) {
        this.orderExpirationDate = orderExpirationDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Bu getBuId() {
        return buId;
    }

    public void setBuId(Bu buId) {
        this.buId = buId;
    }

    public Customer getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(Customer customerCode) {
        this.customerCode = customerCode;
    }

    public Employee getBuContactId() {
        return buContactId;
    }

    public void setBuContactId(Employee buContactId) {
        this.buContactId = buContactId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (demandId != null ? demandId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
     	boolean isEqual = false;
      	
      	if(object instanceof Demand) {
      		
      		Demand other = (Demand) object;
              
      		if ((this.demandId != null && other.demandId != null) && (this.demandId.equals(other.demandId))) {
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
        return "Demand[ demandId=" + demandId + " ]";
    }
    
}
