package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "VENDOR")
@NamedQuery(name = "Vendor.findAll", query = "SELECT v FROM Vendor v")
@NamedQuery(name = "Vendor.findByVendorId", query = "SELECT v FROM Vendor v WHERE v.vendorId = :vendorId")
@NamedQuery(name = "Vendor.findByOpsVendorId", query = "SELECT v FROM Vendor v WHERE v.opsVendorId = :opsVendorId")
@NamedQuery(name = "Vendor.findByOpsType", query = "SELECT v FROM Vendor v WHERE v.opsType = :opsType")
@NamedQuery(name = "Vendor.findByVendorName", query = "SELECT v FROM Vendor v WHERE v.vendorName = :vendorName")
@NamedQuery(name = "Vendor.findByVendorMarketCap", query = "SELECT v FROM Vendor v WHERE v.vendorMarketCap = :vendorMarketCap")
@NamedQuery(name = "Vendor.findByEstdDate", query = "SELECT v FROM Vendor v WHERE v.estdDate = :estdDate")
public class Vendor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "VENDOR_ID")
    private BigDecimal vendorId;
    @Column(name = "OPS_VENDOR_ID")
    private BigInteger opsVendorId;
    @Column(name = "OPS_TYPE")
    private String opsType;
    @Column(name = "VENDOR_NAME")
    private String vendorName;
    @Column(name = "VENDOR_MARKET_CAP")
    private BigInteger vendorMarketCap;
    @Column(name = "ESTD_DATE")
    @Temporal(TemporalType.DATE)
    private Date estdDate;

    public Vendor() {
    }

    public Vendor(BigDecimal vendorId) {
        this.vendorId = vendorId;
    }

    public BigDecimal getVendorId() {
        return vendorId;
    }

    public void setVendorId(BigDecimal vendorId) {
        this.vendorId = vendorId;
    }

    public BigInteger getOpsVendorId() {
        return opsVendorId;
    }

    public void setOpsVendorId(BigInteger opsVendorId) {
        this.opsVendorId = opsVendorId;
    }

    public String getOpsType() {
        return opsType;
    }

    public void setOpsType(String opsType) {
        this.opsType = opsType;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public BigInteger getVendorMarketCap() {
        return vendorMarketCap;
    }

    public void setVendorMarketCap(BigInteger vendorMarketCap) {
        this.vendorMarketCap = vendorMarketCap;
    }

    public Date getEstdDate() {
        return estdDate;
    }

    public void setEstdDate(Date estdDate) {
        this.estdDate = estdDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendorId != null ? vendorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
    	boolean isEqual = false;
      	
      	if(object instanceof Vendor) {
      		
      		Vendor other = (Vendor) object;
              
      		if ((this.vendorId != null && other.vendorId != null) && (this.vendorId.equals(other.vendorId))) {
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
        return "Vendor[ vendorId=" + vendorId + " ]";
    }
    
}
