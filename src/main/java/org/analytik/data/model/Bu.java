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
@Table(name = "BU")
@NamedQuery(name = "Bu.findAll", query = "SELECT b FROM Bu b")
@NamedQuery(name = "Bu.findByBuId", query = "SELECT b FROM Bu b WHERE b.buId = :buId")
@NamedQuery(name = "Bu.findByUnitName", query = "SELECT b FROM Bu b WHERE b.unitName = :unitName")
@NamedQuery(name = "Bu.findByBuType", query = "SELECT b FROM Bu b WHERE b.buType = :buType")
@NamedQuery(name = "Bu.findByContractorId", query = "SELECT b FROM Bu b WHERE b.contractorId = :contractorId")
@NamedQuery(name = "Bu.findByContractorName", query = "SELECT b FROM Bu b WHERE b.contractorName = :contractorName")
@NamedQuery(name = "Bu.findByCostCenterCode", query = "SELECT b FROM Bu b WHERE b.costCenterCode = :costCenterCode")
@NamedQuery(name = "Bu.findByRevenueCenterCode", query = "SELECT b FROM Bu b WHERE b.revenueCenterCode = :revenueCenterCode")
public class Bu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BU_ID")
    private BigDecimal buId;
    @Column(name = "UNIT_NAME")
    private String unitName;
    @Column(name = "BU_TYPE")
    private String buType;
    @Column(name = "CONTRACTOR_ID")
    private BigInteger contractorId;
    @Column(name = "CONTRACTOR_NAME")
    private String contractorName;
    @Column(name = "COST_CENTER_CODE")
    private BigInteger costCenterCode;
    @Column(name = "REVENUE_CENTER_CODE")
    private BigInteger revenueCenterCode;
    @OneToMany(mappedBy = "buId")
    private Collection<JobDescription> jobDescriptionCollection;
    @OneToMany(mappedBy = "buId")
    private Collection<Program> programCollection;
    @OneToMany(mappedBy = "buId")
    private Collection<ProjectBuMapping> projectBuMappingCollection;
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private OfficeAddress addressId;
    @OneToMany(mappedBy = "buId")
    private Collection<Orders> ordersCollection;
    @OneToMany(mappedBy = "orgId")
    private Collection<Supply> supplyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buId")
    private Collection<Project> projectCollection;
    @OneToMany(mappedBy = "buId")
    private Collection<Demand> demandCollection;
    @OneToMany(mappedBy = "buId")
    private Collection<Practice> practiceCollection;

    public Bu() {
    }

    public Bu(BigDecimal buId) {
        this.buId = buId;
    }

    public BigDecimal getBuId() {
        return buId;
    }

    public void setBuId(BigDecimal buId) {
        this.buId = buId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getBuType() {
        return buType;
    }

    public void setBuType(String buType) {
        this.buType = buType;
    }

    public BigInteger getContractorId() {
        return contractorId;
    }

    public void setContractorId(BigInteger contractorId) {
        this.contractorId = contractorId;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public BigInteger getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(BigInteger costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public BigInteger getRevenueCenterCode() {
        return revenueCenterCode;
    }

    public void setRevenueCenterCode(BigInteger revenueCenterCode) {
        this.revenueCenterCode = revenueCenterCode;
    }

    public Collection<JobDescription> getJobDescriptionCollection() {
        return jobDescriptionCollection;
    }

    public void setJobDescriptionCollection(Collection<JobDescription> jobDescriptionCollection) {
        this.jobDescriptionCollection = jobDescriptionCollection;
    }

    public Collection<Program> getProgramCollection() {
        return programCollection;
    }

    public void setProgramCollection(Collection<Program> programCollection) {
        this.programCollection = programCollection;
    }

    public Collection<ProjectBuMapping> getProjectBuMappingCollection() {
        return projectBuMappingCollection;
    }

    public void setProjectBuMappingCollection(Collection<ProjectBuMapping> projectBuMappingCollection) {
        this.projectBuMappingCollection = projectBuMappingCollection;
    }

    public OfficeAddress getAddressId() {
        return addressId;
    }

    public void setAddressId(OfficeAddress addressId) {
        this.addressId = addressId;
    }

    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Collection<Supply> getSupplyCollection() {
        return supplyCollection;
    }

    public void setSupplyCollection(Collection<Supply> supplyCollection) {
        this.supplyCollection = supplyCollection;
    }

    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    public Collection<Demand> getDemandCollection() {
        return demandCollection;
    }

    public void setDemandCollection(Collection<Demand> demandCollection) {
        this.demandCollection = demandCollection;
    }

    public Collection<Practice> getPracticeCollection() {
        return practiceCollection;
    }

    public void setPracticeCollection(Collection<Practice> practiceCollection) {
        this.practiceCollection = practiceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (buId != null ? buId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
    	boolean isEqual = false;
    	
    	if(object instanceof Bu) {
    		
    		Bu other = (Bu) object;
            
    		if ((this.buId != null && other.buId != null) && (this.buId.equals(other.buId))) {
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
        return "Bu[ buId=" + buId + " ]";
    }
    
}
