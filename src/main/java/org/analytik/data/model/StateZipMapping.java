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
@Table(name = "STATE_ZIP_MAPPING")
@NamedQuery(name = "StateZipMapping.findAll", query = "SELECT s FROM StateZipMapping s")
@NamedQuery(name = "StateZipMapping.findByMappingId", query = "SELECT s FROM StateZipMapping s WHERE s.mappingId = :mappingId")
@NamedQuery(name = "StateZipMapping.findByZipcode", query = "SELECT s FROM StateZipMapping s WHERE s.zipcode = :zipcode")
public class StateZipMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MAPPING_ID")
    private BigDecimal mappingId;
    @Basic(optional = false)
    @Column(name = "ZIPCODE")
    private String zipcode;
    @JoinColumn(name = "STATE_ID", referencedColumnName = "STATE_ID")
    @ManyToOne(optional = false)
    private State stateId;

    public StateZipMapping() {
    }

    public StateZipMapping(BigDecimal mappingId) {
        this.mappingId = mappingId;
    }

    public StateZipMapping(BigDecimal mappingId, String zipcode) {
        this.mappingId = mappingId;
        this.zipcode = zipcode;
    }

    public BigDecimal getMappingId() {
        return mappingId;
    }

    public void setMappingId(BigDecimal mappingId) {
        this.mappingId = mappingId;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mappingId != null ? mappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof StateZipMapping) {
      		
      		StateZipMapping other = (StateZipMapping) object;
              
      		if ((this.mappingId != null && other.mappingId != null) && (this.mappingId.equals(other.mappingId))) {
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
        return "StateZipMapping[ mappingId=" + mappingId + " ]";
    }
    
}
