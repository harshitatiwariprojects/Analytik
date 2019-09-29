package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Defines Model.
 * @author Harshita Tiwari
 * Copyright 2019 by Harshita Tiwari. All rights reserved.
 *
 */

@Entity
@Table(name = "COUNTRY_INDIRECT_OPS")
@NamedQuery(name = "CountryIndirectOps.findAll", query = "SELECT c FROM CountryIndirectOps c")
@NamedQuery(name = "CountryIndirectOps.findByCountryIndirectId", query = "SELECT c FROM CountryIndirectOps c WHERE c.countryIndirectId = :countryIndirectId")
@NamedQuery(name = "CountryIndirectOps.findByName", query = "SELECT c FROM CountryIndirectOps c WHERE c.name = :name")
public class CountryIndirectOps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COUNTRY_INDIRECT_ID")
    private BigDecimal countryIndirectId;
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne(optional = false)
    private OfficeAddress addressId;

    public CountryIndirectOps() {
    }

    public CountryIndirectOps(BigDecimal countryIndirectId) {
        this.countryIndirectId = countryIndirectId;
    }

    public BigDecimal getCountryIndirectId() {
        return countryIndirectId;
    }

    public void setCountryIndirectId(BigDecimal countryIndirectId) {
        this.countryIndirectId = countryIndirectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OfficeAddress getAddressId() {
        return addressId;
    }

    public void setAddressId(OfficeAddress addressId) {
        this.addressId = addressId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryIndirectId != null ? countryIndirectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
      
    	boolean isEqual = false;
     	
     	if(object instanceof CountryIndirectOps) {
     		
     		CountryIndirectOps other = (CountryIndirectOps) object;
             
     		if ((this.countryIndirectId != null && other.countryIndirectId != null) && (this.countryIndirectId.equals(other.countryIndirectId))) {
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
        return "CountryIndirectOps[ countryIndirectId=" + countryIndirectId + " ]";
    }
    
}
