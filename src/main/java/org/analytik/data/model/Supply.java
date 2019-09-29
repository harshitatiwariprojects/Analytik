package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SUPPLY")
@NamedQuery(name = "Supply.findAll", query = "SELECT s FROM Supply s")
@NamedQuery(name = "Supply.findBySupplyId", query = "SELECT s FROM Supply s WHERE s.supplyId = :supplyId")
@NamedQuery(name = "Supply.findByOrderBookedDate", query = "SELECT s FROM Supply s WHERE s.orderBookedDate = :orderBookedDate")
@NamedQuery(name = "Supply.findByOrderArrivalDate", query = "SELECT s FROM Supply s WHERE s.orderArrivalDate = :orderArrivalDate")
@NamedQuery(name = "Supply.findByOrderCategory", query = "SELECT s FROM Supply s WHERE s.orderCategory = :orderCategory")
@NamedQuery(name = "Supply.findByOrderType", query = "SELECT s FROM Supply s WHERE s.orderType = :orderType")
@NamedQuery(name = "Supply.findByOrderStatus", query = "SELECT s FROM Supply s WHERE s.orderStatus = :orderStatus")
@NamedQuery(name = "Supply.findByOrderExpirationDate", query = "SELECT s FROM Supply s WHERE s.orderExpirationDate = :orderExpirationDate")
@NamedQuery(name = "Supply.findByPaymentStatus", query = "SELECT s FROM Supply s WHERE s.paymentStatus = :paymentStatus")
public class Supply implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SUPPLY_ID")
    private BigDecimal supplyId;
    @Column(name = "ORDER_BOOKED_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderBookedDate;
    @Column(name = "ORDER_ARRIVAL_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderArrivalDate;
    @Column(name = "ORDER_CATEGORY")
    private String orderCategory;
    @Column(name = "ORDER_TYPE")
    private String orderType;
    @Column(name = "ORDER_STATUS")
    private String orderStatus;
    @Column(name = "ORDER_EXPIRATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderExpirationDate;
    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;
    @JoinColumn(name = "ORG_ID", referencedColumnName = "BU_ID")
    @ManyToOne
    private Bu orgId;
    @OneToMany(mappedBy = "supplyId")
    private Collection<Fulfillment> fulfillmentCollection;

    public Supply() {
    }

    public Supply(BigDecimal supplyId) {
        this.supplyId = supplyId;
    }

    public BigDecimal getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(BigDecimal supplyId) {
        this.supplyId = supplyId;
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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
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

    public Bu getOrgId() {
        return orgId;
    }

    public void setOrgId(Bu orgId) {
        this.orgId = orgId;
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
        hash += (supplyId != null ? supplyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof Supply) {
      		
      		Supply other = (Supply) object;
              
      		if ((this.supplyId != null && other.supplyId != null) && (this.supplyId.equals(other.supplyId))) {
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
        return "Supply[ supplyId=" + supplyId + " ]";
    }
    
}
