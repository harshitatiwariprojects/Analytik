package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

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
@Table(name = "RESOURCE_AVAILABILITY")
@NamedQuery(name = "ResourceAvailability.findAll", query = "SELECT r FROM ResourceAvailability r")
@NamedQuery(name = "ResourceAvailability.findByAvailabilityId", query = "SELECT r FROM ResourceAvailability r WHERE r.availabilityId = :availabilityId")
@NamedQuery(name = "ResourceAvailability.findByAvailabilityType", query = "SELECT r FROM ResourceAvailability r WHERE r.availabilityType = :availabilityType")
@NamedQuery(name = "ResourceAvailability.findByUnitsRequirement", query = "SELECT r FROM ResourceAvailability r WHERE r.unitsRequirement = :unitsRequirement")
public class ResourceAvailability implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AVAILABILITY_ID")
    private BigDecimal availabilityId;
    @Column(name = "AVAILABILITY_TYPE")
    private String availabilityType;
    @Column(name = "UNITS_REQUIREMENT")
    private BigInteger unitsRequirement;
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ACTIVITY_ID")
    @ManyToOne
    private Activity activityId;

    public ResourceAvailability() {
    }

    public ResourceAvailability(BigDecimal availabilityId) {
        this.availabilityId = availabilityId;
    }

    public BigDecimal getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(BigDecimal availabilityId) {
        this.availabilityId = availabilityId;
    }

    public String getAvailabilityType() {
        return availabilityType;
    }

    public void setAvailabilityType(String availabilityType) {
        this.availabilityType = availabilityType;
    }

    public BigInteger getUnitsRequirement() {
        return unitsRequirement;
    }

    public void setUnitsRequirement(BigInteger unitsRequirement) {
        this.unitsRequirement = unitsRequirement;
    }

    public Activity getActivityId() {
        return activityId;
    }

    public void setActivityId(Activity activityId) {
        this.activityId = activityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (availabilityId != null ? availabilityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof ResourceAvailability) {
      		
      		ResourceAvailability other = (ResourceAvailability) object;
              
      		if ((this.availabilityId != null && other.availabilityId != null) && (this.availabilityId.equals(other.availabilityId))) {
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
        return "ResourceAvailability[ availabilityId=" + availabilityId + " ]";
    }
    
}
