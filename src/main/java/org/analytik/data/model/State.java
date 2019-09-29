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
@Table(name = "STATE")
@NamedQuery(name = "State.findAll", query = "SELECT s FROM State s")
@NamedQuery(name = "State.findByStateId", query = "SELECT s FROM State s WHERE s.stateId = :stateId")
@NamedQuery(name = "State.findByStateName", query = "SELECT s FROM State s WHERE s.stateName = :stateName")
@NamedQuery(name = "State.findByStatePopulation", query = "SELECT s FROM State s WHERE s.statePopulation = :statePopulation")
@NamedQuery(name = "State.findByLanguageSpoken", query = "SELECT s FROM State s WHERE s.languageSpoken = :languageSpoken")
@NamedQuery(name = "State.findByReligions", query = "SELECT s FROM State s WHERE s.religions = :religions")
public class State implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STATE_ID")
    private BigDecimal stateId;
    @Column(name = "STATE_NAME")
    private String stateName;
    @Column(name = "STATE_POPULATION")
    private BigInteger statePopulation;
    @Column(name = "LANGUAGE_SPOKEN")
    private String languageSpoken;
    @Column(name = "RELIGIONS")
    private String religions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<StateZipMapping> stateZipMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<StateLanguageMapping> stateLanguageMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<OfficeAddress> officeAddressCollection;

    public State() {
    }

    public State(BigDecimal stateId) {
        this.stateId = stateId;
    }

    public BigDecimal getStateId() {
        return stateId;
    }

    public void setStateId(BigDecimal stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public BigInteger getStatePopulation() {
        return statePopulation;
    }

    public void setStatePopulation(BigInteger statePopulation) {
        this.statePopulation = statePopulation;
    }

    public String getLanguageSpoken() {
        return languageSpoken;
    }

    public void setLanguageSpoken(String languageSpoken) {
        this.languageSpoken = languageSpoken;
    }

    public String getReligions() {
        return religions;
    }

    public void setReligions(String religions) {
        this.religions = religions;
    }

    public Collection<StateZipMapping> getStateZipMappingCollection() {
        return stateZipMappingCollection;
    }

    public void setStateZipMappingCollection(Collection<StateZipMapping> stateZipMappingCollection) {
        this.stateZipMappingCollection = stateZipMappingCollection;
    }

    public Collection<StateLanguageMapping> getStateLanguageMappingCollection() {
        return stateLanguageMappingCollection;
    }

    public void setStateLanguageMappingCollection(Collection<StateLanguageMapping> stateLanguageMappingCollection) {
        this.stateLanguageMappingCollection = stateLanguageMappingCollection;
    }

    public Collection<OfficeAddress> getOfficeAddressCollection() {
        return officeAddressCollection;
    }

    public void setOfficeAddressCollection(Collection<OfficeAddress> officeAddressCollection) {
        this.officeAddressCollection = officeAddressCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof State) {
      		
      		State other = (State) object;
              
      		if ((this.stateId != null && other.stateId != null) && (this.stateId.equals(other.stateId))) {
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
        return "State[ stateId=" + stateId + " ]";
    }
    
}
