package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "COUNTRY")
@NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")
@NamedQuery(name = "Country.findByCountryId", query = "SELECT c FROM Country c WHERE c.countryId = :countryId")
@NamedQuery(name = "Country.findByCountryName", query = "SELECT c FROM Country c WHERE c.countryName = :countryName")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COUNTRY_ID")
    private BigDecimal countryId;
    @Basic(optional = false)
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryId")
    private Collection<Religion> religionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryId")
    private Collection<CountryLanguageMapping> countryLanguageMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryId")
    private Collection<CountryDetails> countryDetailsCollection;
    @JoinColumn(name = "CONTINENT_ID", referencedColumnName = "CONTINENT_ID")
    @ManyToOne(optional = false)
    private Continent continentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryId")
    private Collection<OfficeAddress> officeAddressCollection;

    public Country() {
    }

    public Country(BigDecimal countryId) {
        this.countryId = countryId;
    }

    public Country(BigDecimal countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    public BigDecimal getCountryId() {
        return countryId;
    }

    public void setCountryId(BigDecimal countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Collection<Religion> getReligionCollection() {
        return religionCollection;
    }

    public void setReligionCollection(Collection<Religion> religionCollection) {
        this.religionCollection = religionCollection;
    }

    public Collection<CountryLanguageMapping> getCountryLanguageMappingCollection() {
        return countryLanguageMappingCollection;
    }

    public void setCountryLanguageMappingCollection(Collection<CountryLanguageMapping> countryLanguageMappingCollection) {
        this.countryLanguageMappingCollection = countryLanguageMappingCollection;
    }

    public Collection<CountryDetails> getCountryDetailsCollection() {
        return countryDetailsCollection;
    }

    public void setCountryDetailsCollection(Collection<CountryDetails> countryDetailsCollection) {
        this.countryDetailsCollection = countryDetailsCollection;
    }

    public Continent getContinentId() {
        return continentId;
    }

    public void setContinentId(Continent continentId) {
        this.continentId = continentId;
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
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
    	
    	if(object instanceof Country) {
    		
    		Country other = (Country) object;
            
    		if ((this.countryId != null && other.countryId != null) && (this.countryId.equals(other.countryId))) {
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
        return "Country[ countryId=" + countryId + " ]";
    }
    
}
