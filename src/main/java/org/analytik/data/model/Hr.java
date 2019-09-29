package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Basic;
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
@Table(name = "HR")
@NamedQuery(name = "Hr.findAll", query = "SELECT h FROM Hr h")
@NamedQuery(name = "Hr.findByHrId", query = "SELECT h FROM Hr h WHERE h.hrId = :hrId")
public class Hr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "HR_ID")
    private BigDecimal hrId;
    @OneToMany(mappedBy = "hr")
    private Collection<Candidate> candidateCollection;
    @JoinColumn(name = "ORG_LOCATION_HEAD", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee orgLocationHead;
    @JoinColumn(name = "ORG_HEAD", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee orgHead;
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private OfficeAddress addressId;
    @OneToMany(mappedBy = "hr")
    private Collection<Deboarding> deboardingCollection;
    @OneToMany(mappedBy = "hr")
    private Collection<Onboarding> onboardingCollection;
    @OneToMany(mappedBy = "hr")
    private Collection<Recruitment> recruitmentCollection;

    public Hr() {
    }

    public Hr(BigDecimal hrId) {
        this.hrId = hrId;
    }

    public BigDecimal getHrId() {
        return hrId;
    }

    public void setHrId(BigDecimal hrId) {
        this.hrId = hrId;
    }

    public Collection<Candidate> getCandidateCollection() {
        return candidateCollection;
    }

    public void setCandidateCollection(Collection<Candidate> candidateCollection) {
        this.candidateCollection = candidateCollection;
    }

    public Employee getOrgLocationHead() {
        return orgLocationHead;
    }

    public void setOrgLocationHead(Employee orgLocationHead) {
        this.orgLocationHead = orgLocationHead;
    }

    public Employee getOrgHead() {
        return orgHead;
    }

    public void setOrgHead(Employee orgHead) {
        this.orgHead = orgHead;
    }

    public OfficeAddress getAddressId() {
        return addressId;
    }

    public void setAddressId(OfficeAddress addressId) {
        this.addressId = addressId;
    }

    public Collection<Deboarding> getDeboardingCollection() {
        return deboardingCollection;
    }

    public void setDeboardingCollection(Collection<Deboarding> deboardingCollection) {
        this.deboardingCollection = deboardingCollection;
    }

    public Collection<Onboarding> getOnboardingCollection() {
        return onboardingCollection;
    }

    public void setOnboardingCollection(Collection<Onboarding> onboardingCollection) {
        this.onboardingCollection = onboardingCollection;
    }

    public Collection<Recruitment> getRecruitmentCollection() {
        return recruitmentCollection;
    }

    public void setRecruitmentCollection(Collection<Recruitment> recruitmentCollection) {
        this.recruitmentCollection = recruitmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hrId != null ? hrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
     	boolean isEqual = false;
      	
      	if(object instanceof Hr) {
      		
      		Hr other = (Hr) object;
              
      		if ((this.hrId != null && other.hrId != null) && (this.hrId.equals(other.hrId))) {
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
        return "Hr[ hrId=" + hrId + " ]";
    }
    
}
