
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
@Table(name = "OFFICE_ADDRESS")
@NamedQuery(name = "OfficeAddress.findAll", query = "SELECT o FROM OfficeAddress o")
@NamedQuery(name = "OfficeAddress.findByAddressId", query = "SELECT o FROM OfficeAddress o WHERE o.addressId = :addressId")
@NamedQuery(name = "OfficeAddress.findByAddress", query = "SELECT o FROM OfficeAddress o WHERE o.address = :address")
@NamedQuery(name = "OfficeAddress.findByZipcode", query = "SELECT o FROM OfficeAddress o WHERE o.zipcode = :zipcode")
@NamedQuery(name = "OfficeAddress.findByEmail1", query = "SELECT o FROM OfficeAddress o WHERE o.email1 = :email1")
@NamedQuery(name = "OfficeAddress.findByEmail2", query = "SELECT o FROM OfficeAddress o WHERE o.email2 = :email2")
@NamedQuery(name = "OfficeAddress.findByEmail3", query = "SELECT o FROM OfficeAddress o WHERE o.email3 = :email3")
@NamedQuery(name = "OfficeAddress.findByPhoneNo1", query = "SELECT o FROM OfficeAddress o WHERE o.phoneNo1 = :phoneNo1")
@NamedQuery(name = "OfficeAddress.findByPhoneNo2", query = "SELECT o FROM OfficeAddress o WHERE o.phoneNo2 = :phoneNo2")
@NamedQuery(name = "OfficeAddress.findByPhoneNo3", query = "SELECT o FROM OfficeAddress o WHERE o.phoneNo3 = :phoneNo3")
@NamedQuery(name = "OfficeAddress.findByPhoneNo4", query = "SELECT o FROM OfficeAddress o WHERE o.phoneNo4 = :phoneNo4")
@NamedQuery(name = "OfficeAddress.findByPhoneNo5", query = "SELECT o FROM OfficeAddress o WHERE o.phoneNo5 = :phoneNo5")
@NamedQuery(name = "OfficeAddress.findByPhoneNo6", query = "SELECT o FROM OfficeAddress o WHERE o.phoneNo6 = :phoneNo6")
public class OfficeAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ADDRESS_ID")
    private BigDecimal addressId;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "ZIPCODE")
    private BigInteger zipcode;
    @Column(name = "EMAIL1")
    private String email1;
    @Column(name = "EMAIL2")
    private String email2;
    @Column(name = "EMAIL3")
    private String email3;
    @Column(name = "PHONE_NO_1")
    private BigInteger phoneNo1;
    @Column(name = "PHONE_NO_2")
    private BigInteger phoneNo2;
    @Column(name = "PHONE_NO_3")
    private BigInteger phoneNo3;
    @Column(name = "PHONE_NO_4")
    private BigInteger phoneNo4;
    @Column(name = "PHONE_NO_5")
    private BigInteger phoneNo5;
    @Column(name = "PHONE_NO_6")
    private BigInteger phoneNo6;
    @OneToMany(mappedBy = "addressId")
    private Collection<Hr> hrCollection;
    @OneToMany(mappedBy = "addressId")
    private Collection<Deboarding> deboardingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
    private Collection<CountryDirectOps> countryDirectOpsCollection;
    @OneToMany(mappedBy = "addressId")
    private Collection<Onboarding> onboardingCollection;
    @OneToMany(mappedBy = "practiceRevenueCenterCode")
    private Collection<Program> programCollection;
    @OneToMany(mappedBy = "buCostCenterCode")
    private Collection<Program> programCollection1;
    @OneToMany(mappedBy = "practiceCostCenterCode")
    private Collection<Program> programCollection2;
    @OneToMany(mappedBy = "buRevenueCenterCode")
    private Collection<Program> programCollection3;
    @OneToMany(mappedBy = "addressId")
    private Collection<Bu> buCollection;
    @OneToMany(mappedBy = "addressId")
    private Collection<Recruitment> recruitmentCollection;
    @OneToMany(mappedBy = "address3")
    private Collection<Organisation> organisationCollection;
    @OneToMany(mappedBy = "address1")
    private Collection<Organisation> organisationCollection1;
    @OneToMany(mappedBy = "address2")
    private Collection<Organisation> organisationCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
    private Collection<CountryIndirectOps> countryIndirectOpsCollection;
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    @ManyToOne(optional = false)
    private Country countryId;
    @JoinColumn(name = "STATE_ID", referencedColumnName = "STATE_ID")
    @ManyToOne(optional = false)
    private State stateId;

    public OfficeAddress() {
    }

    public OfficeAddress(BigDecimal addressId) {
        this.addressId = addressId;
    }

    public BigDecimal getAddressId() {
        return addressId;
    }

    public void setAddressId(BigDecimal addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getZipcode() {
        return zipcode;
    }

    public void setZipcode(BigInteger zipcode) {
        this.zipcode = zipcode;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public BigInteger getPhoneNo1() {
        return phoneNo1;
    }

    public void setPhoneNo1(BigInteger phoneNo1) {
        this.phoneNo1 = phoneNo1;
    }

    public BigInteger getPhoneNo2() {
        return phoneNo2;
    }

    public void setPhoneNo2(BigInteger phoneNo2) {
        this.phoneNo2 = phoneNo2;
    }

    public BigInteger getPhoneNo3() {
        return phoneNo3;
    }

    public void setPhoneNo3(BigInteger phoneNo3) {
        this.phoneNo3 = phoneNo3;
    }

    public BigInteger getPhoneNo4() {
        return phoneNo4;
    }

    public void setPhoneNo4(BigInteger phoneNo4) {
        this.phoneNo4 = phoneNo4;
    }

    public BigInteger getPhoneNo5() {
        return phoneNo5;
    }

    public void setPhoneNo5(BigInteger phoneNo5) {
        this.phoneNo5 = phoneNo5;
    }

    public BigInteger getPhoneNo6() {
        return phoneNo6;
    }

    public void setPhoneNo6(BigInteger phoneNo6) {
        this.phoneNo6 = phoneNo6;
    }

    public Collection<Hr> getHrCollection() {
        return hrCollection;
    }

    public void setHrCollection(Collection<Hr> hrCollection) {
        this.hrCollection = hrCollection;
    }

    public Collection<Deboarding> getDeboardingCollection() {
        return deboardingCollection;
    }

    public void setDeboardingCollection(Collection<Deboarding> deboardingCollection) {
        this.deboardingCollection = deboardingCollection;
    }

    public Collection<CountryDirectOps> getCountryDirectOpsCollection() {
        return countryDirectOpsCollection;
    }

    public void setCountryDirectOpsCollection(Collection<CountryDirectOps> countryDirectOpsCollection) {
        this.countryDirectOpsCollection = countryDirectOpsCollection;
    }

    public Collection<Onboarding> getOnboardingCollection() {
        return onboardingCollection;
    }

    public void setOnboardingCollection(Collection<Onboarding> onboardingCollection) {
        this.onboardingCollection = onboardingCollection;
    }

    public Collection<Program> getProgramCollection() {
        return programCollection;
    }

    public void setProgramCollection(Collection<Program> programCollection) {
        this.programCollection = programCollection;
    }

    public Collection<Program> getProgramCollection1() {
        return programCollection1;
    }

    public void setProgramCollection1(Collection<Program> programCollection1) {
        this.programCollection1 = programCollection1;
    }

    public Collection<Program> getProgramCollection2() {
        return programCollection2;
    }

    public void setProgramCollection2(Collection<Program> programCollection2) {
        this.programCollection2 = programCollection2;
    }

    public Collection<Program> getProgramCollection3() {
        return programCollection3;
    }

    public void setProgramCollection3(Collection<Program> programCollection3) {
        this.programCollection3 = programCollection3;
    }

    public Collection<Bu> getBuCollection() {
        return buCollection;
    }

    public void setBuCollection(Collection<Bu> buCollection) {
        this.buCollection = buCollection;
    }

    public Collection<Recruitment> getRecruitmentCollection() {
        return recruitmentCollection;
    }

    public void setRecruitmentCollection(Collection<Recruitment> recruitmentCollection) {
        this.recruitmentCollection = recruitmentCollection;
    }

    public Collection<Organisation> getOrganisationCollection() {
        return organisationCollection;
    }

    public void setOrganisationCollection(Collection<Organisation> organisationCollection) {
        this.organisationCollection = organisationCollection;
    }

    public Collection<Organisation> getOrganisationCollection1() {
        return organisationCollection1;
    }

    public void setOrganisationCollection1(Collection<Organisation> organisationCollection1) {
        this.organisationCollection1 = organisationCollection1;
    }

    public Collection<Organisation> getOrganisationCollection2() {
        return organisationCollection2;
    }

    public void setOrganisationCollection2(Collection<Organisation> organisationCollection2) {
        this.organisationCollection2 = organisationCollection2;
    }

    public Collection<CountryIndirectOps> getCountryIndirectOpsCollection() {
        return countryIndirectOpsCollection;
    }

    public void setCountryIndirectOpsCollection(Collection<CountryIndirectOps> countryIndirectOpsCollection) {
        this.countryIndirectOpsCollection = countryIndirectOpsCollection;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
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
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
     	boolean isEqual = false;
      	
      	if(object instanceof OfficeAddress) {
      		
      		OfficeAddress other = (OfficeAddress) object;
              
      		if ((this.addressId != null && other.addressId != null) && (this.addressId.equals(other.addressId))) {
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
        return "OfficeAddress[ addressId=" + addressId + " ]";
    }
    
}
