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
@Table(name = "STATE_LANGUAGE_MAPPING")
@NamedQuery(name = "StateLanguageMapping.findAll", query = "SELECT s FROM StateLanguageMapping s")
@NamedQuery(name = "StateLanguageMapping.findByStateLangId", query = "SELECT s FROM StateLanguageMapping s WHERE s.stateLangId = :stateLangId")
@NamedQuery(name = "StateLanguageMapping.findByIsofficial", query = "SELECT s FROM StateLanguageMapping s WHERE s.isofficial = :isofficial")
@NamedQuery(name = "StateLanguageMapping.findByPercentage", query = "SELECT s FROM StateLanguageMapping s WHERE s.percentage = :percentage")
public class StateLanguageMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STATE_LANG_ID")
    private BigDecimal stateLangId;
    @Column(name = "ISOFFICIAL")
    private String isofficial;
    @Column(name = "PERCENTAGE")
    private Double percentage;
    @JoinColumn(name = "LANGUAGE_ID", referencedColumnName = "LANGUAGE_ID")
    @ManyToOne(optional = false)
    private Language languageId;
    @JoinColumn(name = "STATE_ID", referencedColumnName = "STATE_ID")
    @ManyToOne(optional = false)
    private State stateId;

    public StateLanguageMapping() {
    }

    public StateLanguageMapping(BigDecimal stateLangId) {
        this.stateLangId = stateLangId;
    }

    public BigDecimal getStateLangId() {
        return stateLangId;
    }

    public void setStateLangId(BigDecimal stateLangId) {
        this.stateLangId = stateLangId;
    }

    public String getIsofficial() {
        return isofficial;
    }

    public void setIsofficial(String isofficial) {
        this.isofficial = isofficial;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
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
        hash += (stateLangId != null ? stateLangId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof StateLanguageMapping) {
      		
      		StateLanguageMapping other = (StateLanguageMapping) object;
              
      		if ((this.stateLangId != null && other.stateLangId != null) && (this.stateLangId.equals(other.stateLangId))) {
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
        return "StateLanguageMapping[ stateLangId=" + stateLangId + " ]";
    }
    
}
