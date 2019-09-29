package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

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
@Table(name = "RESOURCE_FACILITY")
@NamedQuery(name = "ResourceFacility.findAll", query = "SELECT r FROM ResourceFacility r")
@NamedQuery(name = "ResourceFacility.findByFacilityCode", query = "SELECT r FROM ResourceFacility r WHERE r.facilityCode = :facilityCode")
@NamedQuery(name = "ResourceFacility.findByFacilityName", query = "SELECT r FROM ResourceFacility r WHERE r.facilityName = :facilityName")
@NamedQuery(name = "ResourceFacility.findByUtilised", query = "SELECT r FROM ResourceFacility r WHERE r.utilised = :utilised")
@NamedQuery(name = "ResourceFacility.findByVacant", query = "SELECT r FROM ResourceFacility r WHERE r.vacant = :vacant")
public class ResourceFacility implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FACILITY_CODE")
    private BigDecimal facilityCode;
    @Column(name = "FACILITY_NAME")
    private String facilityName;
    @Column(name = "UTILISED")
    private BigInteger utilised;
    @Column(name = "VACANT")
    private BigInteger vacant;

    public ResourceFacility() {
    }

    public ResourceFacility(BigDecimal facilityCode) {
        this.facilityCode = facilityCode;
    }

    public BigDecimal getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(BigDecimal facilityCode) {
        this.facilityCode = facilityCode;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public BigInteger getUtilised() {
        return utilised;
    }

    public void setUtilised(BigInteger utilised) {
        this.utilised = utilised;
    }

    public BigInteger getVacant() {
        return vacant;
    }

    public void setVacant(BigInteger vacant) {
        this.vacant = vacant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facilityCode != null ? facilityCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof ResourceFacility) {
      		
      		ResourceFacility other = (ResourceFacility) object;
              
      		if ((this.facilityCode != null && other.facilityCode != null) && (this.facilityCode.equals(other.facilityCode))) {
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
        return "ResourceFacility[ facilityCode=" + facilityCode + " ]";
    }
    
}
