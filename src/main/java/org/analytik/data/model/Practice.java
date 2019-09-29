package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "PRACTICE")
@NamedQuery(name = "Practice.findAll", query = "SELECT p FROM Practice p")
@NamedQuery(name = "Practice.findByPracticeId", query = "SELECT p FROM Practice p WHERE p.practiceId = :practiceId")
@NamedQuery(name = "Practice.findByPracticeType", query = "SELECT p FROM Practice p WHERE p.practiceType = :practiceType")
@NamedQuery(name = "Practice.findByEstimatedDuration", query = "SELECT p FROM Practice p WHERE p.estimatedDuration = :estimatedDuration")
@NamedQuery(name = "Practice.findByIspaid", query = "SELECT p FROM Practice p WHERE p.ispaid = :ispaid")
public class Practice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRACTICE_ID")
    private BigDecimal practiceId;
    @Column(name = "PRACTICE_TYPE")
    private String practiceType;
    @Column(name = "ESTIMATED_DURATION")
    private BigInteger estimatedDuration;
    @Column(name = "ISPAID")
    private String ispaid;
    @OneToMany(mappedBy = "practiceId")
    private Collection<Program> programCollection;
    @JoinColumn(name = "BU_ID", referencedColumnName = "BU_ID")
    @ManyToOne
    private Bu buId;
    @JoinColumn(name = "REPORTS_TO", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee reportsTo;
    @JoinColumn(name = "PRACTICE_ORG_ID", referencedColumnName = "ORG_ID")
    @ManyToOne
    private Organisation practiceOrgId;
    @JoinColumn(name = "RESOURCE_ID", referencedColumnName = "RESOURCE_ID")
    @ManyToOne
    private Resources resourceId;

    public Practice() {
    }

    public Practice(BigDecimal practiceId) {
        this.practiceId = practiceId;
    }

    public BigDecimal getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(BigDecimal practiceId) {
        this.practiceId = practiceId;
    }

    public String getPracticeType() {
        return practiceType;
    }

    public void setPracticeType(String practiceType) {
        this.practiceType = practiceType;
    }

    public BigInteger getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(BigInteger estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public String getIspaid() {
        return ispaid;
    }

    public void setIspaid(String ispaid) {
        this.ispaid = ispaid;
    }

    public Collection<Program> getProgramCollection() {
        return programCollection;
    }

    public void setProgramCollection(Collection<Program> programCollection) {
        this.programCollection = programCollection;
    }

    public Bu getBuId() {
        return buId;
    }

    public void setBuId(Bu buId) {
        this.buId = buId;
    }

    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    public Organisation getPracticeOrgId() {
        return practiceOrgId;
    }

    public void setPracticeOrgId(Organisation practiceOrgId) {
        this.practiceOrgId = practiceOrgId;
    }

    public Resources getResourceId() {
        return resourceId;
    }

    public void setResourceId(Resources resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (practiceId != null ? practiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof Practice) {
      		
      		Practice other = (Practice) object;
              
      		if ((this.practiceId != null && other.practiceId != null) && (this.practiceId.equals(other.practiceId))) {
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
        return "Practice[ practiceId=" + practiceId + " ]";
    }
    
}
