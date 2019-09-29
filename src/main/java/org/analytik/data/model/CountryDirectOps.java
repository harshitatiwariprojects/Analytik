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
@Table(name = "COUNTRY_DIRECT_OPS")
@NamedQuery(name = "CountryDirectOps.findAll", query = "SELECT c FROM CountryDirectOps c")
@NamedQuery(name = "CountryDirectOps.findByCountryDirectId", query = "SELECT c FROM CountryDirectOps c WHERE c.countryDirectId = :countryDirectId")
@NamedQuery(name = "CountryDirectOps.findByName", query = "SELECT c FROM CountryDirectOps c WHERE c.name = :name")
public class CountryDirectOps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COUNTRY_DIRECT_ID")
    private BigDecimal countryDirectId;
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne(optional = false)
    private OfficeAddress addressId;

    public CountryDirectOps() {
    }

    public CountryDirectOps(BigDecimal countryDirectId) {
        this.countryDirectId = countryDirectId;
    }

    public BigDecimal getCountryDirectId() {
        return countryDirectId;
    }

    public void setCountryDirectId(BigDecimal countryDirectId) {
        this.countryDirectId = countryDirectId;
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
        hash += (countryDirectId != null ? countryDirectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
    	boolean isEqual = false;
     	
     	if(object instanceof CountryDirectOps) {
     		
     		CountryDirectOps other = (CountryDirectOps) object;
             
     		if ((this.countryDirectId != null && other.countryDirectId != null) && (this.countryDirectId.equals(other.countryDirectId))) {
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
        return "CountryDirectOps[ countryDirectId=" + countryDirectId + " ]";
    }
    
}
