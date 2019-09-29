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
@Table(name = "CONTINENT")
@NamedQuery(name = "Continent.findAll", query = "SELECT c FROM Continent c")
@NamedQuery(name = "Continent.findByContinentId", query = "SELECT c FROM Continent c WHERE c.continentId = :continentId")
@NamedQuery(name = "Continent.findByContinentName", query = "SELECT c FROM Continent c WHERE c.continentName = :continentName")
@NamedQuery(name = "Continent.findByNoofcountries", query = "SELECT c FROM Continent c WHERE c.noofcountries = :noofcountries")
@NamedQuery(name = "Continent.findByContinentPopulation", query = "SELECT c FROM Continent c WHERE c.continentPopulation = :continentPopulation")
public class Continent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CONTINENT_ID")
    private BigDecimal continentId;
    @Basic(optional = false)
    @Column(name = "CONTINENT_NAME")
    private String continentName;
    @Column(name = "NOOFCOUNTRIES")
    private BigInteger noofcountries;
    @Column(name = "CONTINENT_POPULATION")
    private BigInteger continentPopulation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "continentId")
    private Collection<Country> countryCollection;

    public Continent() {
    }

    public Continent(BigDecimal continentId) {
        this.continentId = continentId;
    }

    public Continent(BigDecimal continentId, String continentName) {
        this.continentId = continentId;
        this.continentName = continentName;
    }

    public BigDecimal getContinentId() {
        return continentId;
    }

    public void setContinentId(BigDecimal continentId) {
        this.continentId = continentId;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public BigInteger getNoofcountries() {
        return noofcountries;
    }

    public void setNoofcountries(BigInteger noofcountries) {
        this.noofcountries = noofcountries;
    }

    public BigInteger getContinentPopulation() {
        return continentPopulation;
    }

    public void setContinentPopulation(BigInteger continentPopulation) {
        this.continentPopulation = continentPopulation;
    }

    public Collection<Country> getCountryCollection() {
        return countryCollection;
    }

    public void setCountryCollection(Collection<Country> countryCollection) {
        this.countryCollection = countryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (continentId != null ? continentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
    	boolean isEqual = false;
    	
    	if(object instanceof Continent) {
    		
    		Continent other = (Continent) object;
            
    		if ((this.continentId != null && other.continentId != null) && (this.continentId.equals(other.continentId))) {
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
        return "Continent[ continentId=" + continentId + " ]";
    }
    
}
