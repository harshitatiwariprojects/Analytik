package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Defines Model.
 * @author Harshita Tiwari
 * Copyright 2019 by Harshita Tiwari. All rights reserved.
 *
 */

@Entity
@Table(name = "COUNTRY_DETAILS")
@NamedQuery(name = "CountryDetails.findAll", query = "SELECT c FROM CountryDetails c")
@NamedQuery(name = "CountryDetails.findByCountryDetailsId", query = "SELECT c FROM CountryDetails c WHERE c.countryDetailsId = :countryDetailsId")
@NamedQuery(name = "CountryDetails.findByGnp", query = "SELECT c FROM CountryDetails c WHERE c.gnp = :gnp")
@NamedQuery(name = "CountryDetails.findByNoofstates", query = "SELECT c FROM CountryDetails c WHERE c.noofstates = :noofstates")
@NamedQuery(name = "CountryDetails.findByIndepYear", query = "SELECT c FROM CountryDetails c WHERE c.indepYear = :indepYear")
@NamedQuery(name = "CountryDetails.findByPopulation", query = "SELECT c FROM CountryDetails c WHERE c.population = :population")
@NamedQuery(name = "CountryDetails.findByArea", query = "SELECT c FROM CountryDetails c WHERE c.area = :area")
@NamedQuery(name = "CountryDetails.findByTypeofrule", query = "SELECT c FROM CountryDetails c WHERE c.typeofrule = :typeofrule")
public class CountryDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COUNTRY_DETAILS_ID")
    private BigDecimal countryDetailsId;
    @Column(name = "GNP")
    private BigInteger gnp;
    @Column(name = "NOOFSTATES")
    private BigInteger noofstates;
    @Column(name = "INDEP_YEAR")
    @Temporal(TemporalType.DATE)
    private Date indepYear;
    @Column(name = "POPULATION")
    private BigInteger population;
    @Column(name = "AREA")
    private BigInteger area;
    @Column(name = "TYPEOFRULE")
    private String typeofrule;
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    @ManyToOne(optional = false)
    private Country countryId;

    public CountryDetails() {
    }

    public CountryDetails(BigDecimal countryDetailsId) {
        this.countryDetailsId = countryDetailsId;
    }

    public BigDecimal getCountryDetailsId() {
        return countryDetailsId;
    }

    public void setCountryDetailsId(BigDecimal countryDetailsId) {
        this.countryDetailsId = countryDetailsId;
    }

    public BigInteger getGnp() {
        return gnp;
    }

    public void setGnp(BigInteger gnp) {
        this.gnp = gnp;
    }

    public BigInteger getNoofstates() {
        return noofstates;
    }

    public void setNoofstates(BigInteger noofstates) {
        this.noofstates = noofstates;
    }

    public Date getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Date indepYear) {
        this.indepYear = indepYear;
    }

    public BigInteger getPopulation() {
        return population;
    }

    public void setPopulation(BigInteger population) {
        this.population = population;
    }

    public BigInteger getArea() {
        return area;
    }

    public void setArea(BigInteger area) {
        this.area = area;
    }

    public String getTypeofrule() {
        return typeofrule;
    }

    public void setTypeofrule(String typeofrule) {
        this.typeofrule = typeofrule;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryDetailsId != null ? countryDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	        
     	boolean isEqual = false;
     	
     	if(object instanceof CountryDetails) {
     		
     		CountryDetails other = (CountryDetails) object;
             
     		if ((this.countryDetailsId != null && other.countryDetailsId != null) && (this.countryDetailsId.equals(other.countryDetailsId))) {
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
        return "CountryDetails[ countryDetailsId=" + countryDetailsId + " ]";
    }
    
}
