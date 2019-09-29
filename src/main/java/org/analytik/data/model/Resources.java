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
@Table(name = "RESOURCES")
@NamedQuery(name = "Resources.findAll", query = "SELECT r FROM Resources r")
@NamedQuery(name = "Resources.findByResourceId", query = "SELECT r FROM Resources r WHERE r.resourceId = :resourceId")
@NamedQuery(name = "Resources.findByResourceType", query = "SELECT r FROM Resources r WHERE r.resourceType = :resourceType")
@NamedQuery(name = "Resources.findByResourcePersonnelType", query = "SELECT r FROM Resources r WHERE r.resourcePersonnelType = :resourcePersonnelType")
@NamedQuery(name = "Resources.findByResourceHardwareType", query = "SELECT r FROM Resources r WHERE r.resourceHardwareType = :resourceHardwareType")
@NamedQuery(name = "Resources.findByResourceSoftwareType", query = "SELECT r FROM Resources r WHERE r.resourceSoftwareType = :resourceSoftwareType")
@NamedQuery(name = "Resources.findByResourceFacilityType", query = "SELECT r FROM Resources r WHERE r.resourceFacilityType = :resourceFacilityType")
@NamedQuery(name = "Resources.findByResourceFinanceType", query = "SELECT r FROM Resources r WHERE r.resourceFinanceType = :resourceFinanceType")
public class Resources implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RESOURCE_ID")
    private BigDecimal resourceId;
    @Column(name = "RESOURCE_TYPE")
    private String resourceType;
    @Column(name = "RESOURCE_PERSONNEL_TYPE")
    private String resourcePersonnelType;
    @Column(name = "RESOURCE_HARDWARE_TYPE")
    private String resourceHardwareType;
    @Column(name = "RESOURCE_SOFTWARE_TYPE")
    private String resourceSoftwareType;
    @Column(name = "RESOURCE_FACILITY_TYPE")
    private String resourceFacilityType;
    @Column(name = "RESOURCE_FINANCE_TYPE")
    private String resourceFinanceType;
    @OneToMany(mappedBy = "resourceId")
    private Collection<ProjectResourceMapping> projectResourceMappingCollection;
    @JoinColumn(name = "SUPERVISOR_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee supervisorId;
    @OneToMany(mappedBy = "resourceId")
    private Collection<Practice> practiceCollection;

    public Resources() {
    }

    public Resources(BigDecimal resourceId) {
        this.resourceId = resourceId;
    }

    public BigDecimal getResourceId() {
        return resourceId;
    }

    public void setResourceId(BigDecimal resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourcePersonnelType() {
        return resourcePersonnelType;
    }

    public void setResourcePersonnelType(String resourcePersonnelType) {
        this.resourcePersonnelType = resourcePersonnelType;
    }

    public String getResourceHardwareType() {
        return resourceHardwareType;
    }

    public void setResourceHardwareType(String resourceHardwareType) {
        this.resourceHardwareType = resourceHardwareType;
    }

    public String getResourceSoftwareType() {
        return resourceSoftwareType;
    }

    public void setResourceSoftwareType(String resourceSoftwareType) {
        this.resourceSoftwareType = resourceSoftwareType;
    }

    public String getResourceFacilityType() {
        return resourceFacilityType;
    }

    public void setResourceFacilityType(String resourceFacilityType) {
        this.resourceFacilityType = resourceFacilityType;
    }

    public String getResourceFinanceType() {
        return resourceFinanceType;
    }

    public void setResourceFinanceType(String resourceFinanceType) {
        this.resourceFinanceType = resourceFinanceType;
    }

    public Collection<ProjectResourceMapping> getProjectResourceMappingCollection() {
        return projectResourceMappingCollection;
    }

    public void setProjectResourceMappingCollection(Collection<ProjectResourceMapping> projectResourceMappingCollection) {
        this.projectResourceMappingCollection = projectResourceMappingCollection;
    }

    public Employee getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Employee supervisorId) {
        this.supervisorId = supervisorId;
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
        hash += (resourceId != null ? resourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
    	boolean isEqual = false;
      	
      	if(object instanceof Resources) {
      		
      		Resources other = (Resources) object;
              
      		if ((this.resourceId != null && other.resourceId != null) && (this.resourceId.equals(other.resourceId))) {
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
        return "Resources[ resourceId=" + resourceId + " ]";
    }
    
}
