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
@Table(name = "PROJECT_BU_MAPPING")
@NamedQuery(name = "ProjectBuMapping.findAll", query = "SELECT p FROM ProjectBuMapping p")
@NamedQuery(name = "ProjectBuMapping.findByMappingid", query = "SELECT p FROM ProjectBuMapping p WHERE p.mappingId = :mappingId")
public class ProjectBuMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MAPPINGID")
    private BigDecimal mappingId;
    @JoinColumn(name = "BU_ID", referencedColumnName = "BU_ID")
    @ManyToOne
    private Bu buId;
    @JoinColumn(name = "PROJECT_CODE", referencedColumnName = "PROJECT_CODE")
    @ManyToOne
    private Project projectCode;

    public ProjectBuMapping() {
    }

    public ProjectBuMapping(BigDecimal mappingId) {
        this.mappingId = mappingId;
    }

    public BigDecimal getMappingId() {
        return mappingId;
    }

    public void setMappingid(BigDecimal mappingId) {
        this.mappingId = mappingId;
    }

    public Bu getBuId() {
        return buId;
    }

    public void setBuId(Bu buId) {
        this.buId = buId;
    }

    public Project getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(Project projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mappingId != null ? mappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof ProjectBuMapping) {
      		
      		ProjectBuMapping other = (ProjectBuMapping) object;
              
      		if ((this.mappingId != null && other.mappingId != null) && (this.mappingId.equals(other.mappingId))) {
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
        return "ProjectBuMapping[ mappingid=" + mappingId + " ]";
    }
    
}
