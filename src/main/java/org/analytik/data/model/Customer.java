package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "CUSTOMER")
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
@NamedQuery(name = "Customer.findByCustomerCode", query = "SELECT c FROM Customer c WHERE c.customerCode = :customerCode")
@NamedQuery(name = "Customer.findByAddressId", query = "SELECT c FROM Customer c WHERE c.addressId = :addressId")
@NamedQuery(name = "Customer.findByPhonenumber", query = "SELECT c FROM Customer c WHERE c.phonenumber = :phonenumber")
@NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CUSTOMER_CODE")
    private BigDecimal customerCode;
    @Column(name = "ADDRESS_ID")
    private BigInteger addressId;
    @Column(name = "PHONENUMBER")
    private BigInteger phonenumber;
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerCode")
    private Collection<Billing> billingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerCode")
    private Collection<Orders> ordersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerCode")
    private Collection<Demand> demandCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerCode")
    private Collection<CustomerProject> customerProjectCollection;

    public Customer() {
    }

    public Customer(BigDecimal customerCode) {
        this.customerCode = customerCode;
    }

    public BigDecimal getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(BigDecimal customerCode) {
        this.customerCode = customerCode;
    }

    public BigInteger getAddressId() {
        return addressId;
    }

    public void setAddressId(BigInteger addressId) {
        this.addressId = addressId;
    }

    public BigInteger getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(BigInteger phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Billing> getBillingCollection() {
        return billingCollection;
    }

    public void setBillingCollection(Collection<Billing> billingCollection) {
        this.billingCollection = billingCollection;
    }

    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Collection<Demand> getDemandCollection() {
        return demandCollection;
    }

    public void setDemandCollection(Collection<Demand> demandCollection) {
        this.demandCollection = demandCollection;
    }

    public Collection<CustomerProject> getCustomerProjectCollection() {
        return customerProjectCollection;
    }

    public void setCustomerProjectCollection(Collection<CustomerProject> customerProjectCollection) {
        this.customerProjectCollection = customerProjectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerCode != null ? customerCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
    	boolean isEqual = false;
     	
     	if(object instanceof Customer) {
     		
     		Customer other = (Customer) object;
             
     		if ((this.customerCode != null && other.customerCode != null) && (this.customerCode.equals(other.customerCode))) {
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
        return "Customer[ customerCode=" + customerCode + " ]";
    }
    
}
