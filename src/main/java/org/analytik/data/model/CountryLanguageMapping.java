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
@Table(name = "COUNTRY_LANGUAGE_MAPPING")
@NamedQuery(name = "CountryLanguageMapping.findAll", query = "SELECT c FROM CountryLanguageMapping c")
@NamedQuery(name = "CountryLanguageMapping.findByCountryLangId", query = "SELECT c FROM CountryLanguageMapping c WHERE c.countryLangId = :countryLangId")
@NamedQuery(name = "CountryLanguageMapping.findByIsofficial", query = "SELECT c FROM CountryLanguageMapping c WHERE c.isofficial = :isofficial")
@NamedQuery(name = "CountryLanguageMapping.findByPercentage", query = "SELECT c FROM CountryLanguageMapping c WHERE c.percentage = :percentage")
public class CountryLanguageMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COUNTRY_LANG_ID")
    private BigDecimal countryLangId;
    @Column(name = "ISOFFICIAL")
    private String isofficial;
    @Column(name = "PERCENTAGE")
    private Double percentage;
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    @ManyToOne(optional = false)
    private Country countryId;
    @JoinColumn(name = "LANGUAGE_ID", referencedColumnName = "LANGUAGE_ID")
    @ManyToOne(optional = false)
    private Language languageId;

    public CountryLanguageMapping() {
    }

    public CountryLanguageMapping(BigDecimal countryLangId) {
        this.countryLangId = countryLangId;
    }

    public BigDecimal getCountryLangId() {
        return countryLangId;
    }

    public void setCountryLangId(BigDecimal countryLangId) {
        this.countryLangId = countryLangId;
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

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryLangId != null ? countryLangId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
     	
     	if(object instanceof CountryLanguageMapping) {
     		
     		CountryLanguageMapping other = (CountryLanguageMapping) object;
             
     		if ((this.countryLangId != null && other.countryLangId != null) && (this.countryLangId.equals(other.countryLangId))) {
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
        return "CountryLanguageMapping[ countryLangId=" + countryLangId + " ]";
    }
    
}
