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
@Table(name = "ORDERS")
@NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
@NamedQuery(name = "Orders.findByOrderId", query = "SELECT o FROM Orders o WHERE o.orderId = :orderId")
@NamedQuery(name = "Orders.findByOrderBookedDate", query = "SELECT o FROM Orders o WHERE o.orderBookedDate = :orderBookedDate")
@NamedQuery(name = "Orders.findByOrderArrivalDate", query = "SELECT o FROM Orders o WHERE o.orderArrivalDate = :orderArrivalDate")
@NamedQuery(name = "Orders.findByOrderCategory", query = "SELECT o FROM Orders o WHERE o.orderCategory = :orderCategory")
@NamedQuery(name = "Orders.findByOrderStatus", query = "SELECT o FROM Orders o WHERE o.orderStatus = :orderStatus")
@NamedQuery(name = "Orders.findByOrderExpirationDate", query = "SELECT o FROM Orders o WHERE o.orderExpirationDate = :orderExpirationDate")
@NamedQuery(name = "Orders.findByPaymentStatus", query = "SELECT o FROM Orders o WHERE o.paymentStatus = :paymentStatus")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORDER_ID")
    private BigDecimal orderId;
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

    public Orders() {
    }

    public Orders(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getOrderId() {
        return orderId;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
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
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof Orders) {
      		
      		Orders other = (Orders) object;
              
      		if ((this.orderId != null && other.orderId != null) && (this.orderId.equals(other.orderId))) {
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
        return "Orders[ orderId=" + orderId + " ]";
    }
    
}
