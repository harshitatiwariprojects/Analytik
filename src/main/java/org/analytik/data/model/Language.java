package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "LANGUAGE")
@NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l")
@NamedQuery(name = "Language.findByLanguageId", query = "SELECT l FROM Language l WHERE l.languageId = :languageId")
@NamedQuery(name = "Language.findByLanguageName", query = "SELECT l FROM Language l WHERE l.languageName = :languageName")
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LANGUAGE_ID")
    private BigDecimal languageId;
    @Basic(optional = false)
    @Column(name = "LANGUAGE_NAME")
    private String languageName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageId")
    private Collection<StateLanguageMapping> stateLanguageMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageId")
    private Collection<CountryLanguageMapping> countryLanguageMappingCollection;

    public Language() {
    }

    public Language(BigDecimal languageId) {
        this.languageId = languageId;
    }

    public Language(BigDecimal languageId, String languageName) {
        this.languageId = languageId;
        this.languageName = languageName;
    }

    public BigDecimal getLanguageId() {
        return languageId;
    }

    public void setLanguageId(BigDecimal languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Collection<StateLanguageMapping> getStateLanguageMappingCollection() {
        return stateLanguageMappingCollection;
    }

    public void setStateLanguageMappingCollection(Collection<StateLanguageMapping> stateLanguageMappingCollection) {
        this.stateLanguageMappingCollection = stateLanguageMappingCollection;
    }

    public Collection<CountryLanguageMapping> getCountryLanguageMappingCollection() {
        return countryLanguageMappingCollection;
    }

    public void setCountryLanguageMappingCollection(Collection<CountryLanguageMapping> countryLanguageMappingCollection) {
        this.countryLanguageMappingCollection = countryLanguageMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (languageId != null ? languageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
     	boolean isEqual = false;
      	
      	if(object instanceof Language) {
      		
      		Language other = (Language) object;
              
      		if ((this.languageId != null && other.languageId != null) && (this.languageId.equals(other.languageId))) {
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
        return "Language[ languageId=" + languageId + " ]";
    }
    
}
