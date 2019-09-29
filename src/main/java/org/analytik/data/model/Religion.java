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
@Table(name = "RELIGION")
@NamedQuery(name = "Religion.findAll", query = "SELECT r FROM Religion r")
@NamedQuery(name = "Religion.findByReligionId", query = "SELECT r FROM Religion r WHERE r.religionId = :religionId")
@NamedQuery(name = "Religion.findByOfficialreligion", query = "SELECT r FROM Religion r WHERE r.officialreligion = :officialreligion")
@NamedQuery(name = "Religion.findByOfficialreligionpercentage", query = "SELECT r FROM Religion r WHERE r.officialreligionpercentage = :officialreligionpercentage")
@NamedQuery(name = "Religion.findByReligion1", query = "SELECT r FROM Religion r WHERE r.religion1 = :religion1")
@NamedQuery(name = "Religion.findByReligion1percentage", query = "SELECT r FROM Religion r WHERE r.religion1percentage = :religion1percentage")
@NamedQuery(name = "Religion.findByReligion2", query = "SELECT r FROM Religion r WHERE r.religion2 = :religion2")
@NamedQuery(name = "Religion.findByReligion2percentage", query = "SELECT r FROM Religion r WHERE r.religion2percentage = :religion2percentage")
@NamedQuery(name = "Religion.findByReligion3", query = "SELECT r FROM Religion r WHERE r.religion3 = :religion3")
@NamedQuery(name = "Religion.findByReligion3percentage", query = "SELECT r FROM Religion r WHERE r.religion3percentage = :religion3percentage")
public class Religion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RELIGION_ID")
    private BigDecimal religionId;
    @Column(name = "OFFICIALRELIGION")
    private String officialreligion;
    @Column(name = "OFFICIALRELIGIONPERCENTAGE")
    private Double officialreligionpercentage;
    @Column(name = "RELIGION1")
    private String religion1;
    @Column(name = "RELIGION1PERCENTAGE")
    private Double religion1percentage;
    @Column(name = "RELIGION2")
    private String religion2;
    @Column(name = "RELIGION2PERCENTAGE")
    private Double religion2percentage;
    @Column(name = "RELIGION3")
    private String religion3;
    @Column(name = "RELIGION3PERCENTAGE")
    private Double religion3percentage;
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    @ManyToOne(optional = false)
    private Country countryId;

    public Religion() {
    }

    public Religion(BigDecimal religionId) {
        this.religionId = religionId;
    }

    public BigDecimal getReligionId() {
        return religionId;
    }

    public void setReligionId(BigDecimal religionId) {
        this.religionId = religionId;
    }

    public String getOfficialreligion() {
        return officialreligion;
    }

    public void setOfficialreligion(String officialreligion) {
        this.officialreligion = officialreligion;
    }

    public Double getOfficialreligionpercentage() {
        return officialreligionpercentage;
    }

    public void setOfficialreligionpercentage(Double officialreligionpercentage) {
        this.officialreligionpercentage = officialreligionpercentage;
    }

    public String getReligion1() {
        return religion1;
    }

    public void setReligion1(String religion1) {
        this.religion1 = religion1;
    }

    public Double getReligion1percentage() {
        return religion1percentage;
    }

    public void setReligion1percentage(Double religion1percentage) {
        this.religion1percentage = religion1percentage;
    }

    public String getReligion2() {
        return religion2;
    }

    public void setReligion2(String religion2) {
        this.religion2 = religion2;
    }

    public Double getReligion2percentage() {
        return religion2percentage;
    }

    public void setReligion2percentage(Double religion2percentage) {
        this.religion2percentage = religion2percentage;
    }

    public String getReligion3() {
        return religion3;
    }

    public void setReligion3(String religion3) {
        this.religion3 = religion3;
    }

    public Double getReligion3percentage() {
        return religion3percentage;
    }

    public void setReligion3percentage(Double religion3percentage) {
        this.religion3percentage = religion3percentage;
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
        hash += (religionId != null ? religionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof Religion) {
      		
      		Religion other = (Religion) object;
              
      		if ((this.religionId != null && other.religionId != null) && (this.religionId.equals(other.religionId))) {
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
        return "Religion[ religionId=" + religionId + " ]";
    }
    
}
