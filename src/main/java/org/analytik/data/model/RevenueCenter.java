package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Defines Model.
 * @author Harshita Tiwari
 * Copyright 2019 by Harshita Tiwari. All rights reserved.
 *
 */

@Entity
@Table(name = "REVENUE_CENTER")
@NamedQuery(name = "RevenueCenter.findAll", query = "SELECT r FROM RevenueCenter r")
@NamedQuery(name = "RevenueCenter.findByRevenueCenterCode", query = "SELECT r FROM RevenueCenter r WHERE r.revenueCenterCode = :revenueCenterCode")
public class RevenueCenter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "REVENUE_CENTER_CODE")
    private BigDecimal revenueCenterCode;

    public RevenueCenter() {
    }

    public RevenueCenter(BigDecimal revenueCenterCode) {
        this.revenueCenterCode = revenueCenterCode;
    }

    public BigDecimal getRevenueCenterCode() {
        return revenueCenterCode;
    }

    public void setRevenueCenterCode(BigDecimal revenueCenterCode) {
        this.revenueCenterCode = revenueCenterCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (revenueCenterCode != null ? revenueCenterCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof RevenueCenter) {
      		
      		RevenueCenter other = (RevenueCenter) object;
              
      		if ((this.revenueCenterCode != null && other.revenueCenterCode != null) && (this.revenueCenterCode.equals(other.revenueCenterCode))) {
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
        return "RevenueCenter[ revenueCenterCode=" + revenueCenterCode + " ]";
    }
    
}
