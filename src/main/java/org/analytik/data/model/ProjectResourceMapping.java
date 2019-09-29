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
@Table(name = "PROJECT_RESOURCE_MAPPING")
@NamedQuery(name = "ProjectResourceMapping.findAll", query = "SELECT p FROM ProjectResourceMapping p")
@NamedQuery(name = "ProjectResourceMapping.findByPrmid", query = "SELECT p FROM ProjectResourceMapping p WHERE p.prmId = :prmId")
public class ProjectResourceMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRMID")
    private BigDecimal prmId;
    @JoinColumn(name = "PROJECT_CODE", referencedColumnName = "PROJECT_CODE")
    @ManyToOne
    private Project projectCode;
    @JoinColumn(name = "RESOURCE_ID", referencedColumnName = "RESOURCE_ID")
    @ManyToOne
    private Resources resourceId;

    public ProjectResourceMapping() {
    }

    public ProjectResourceMapping(BigDecimal prmId) {
        this.prmId = prmId;
    }

    public BigDecimal getPrmId() {
        return prmId;
    }

    public void setPrmid(BigDecimal prmid) {
        this.prmId = prmid;
    }

    public Project getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(Project projectCode) {
        this.projectCode = projectCode;
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
        hash += (prmId != null ? prmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof ProjectResourceMapping) {
      		
      		ProjectResourceMapping other = (ProjectResourceMapping) object;
              
      		if ((this.prmId != null && other.prmId != null) && (this.prmId.equals(other.prmId))) {
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
        return "ProjectResourceMapping[ prmId=" + prmId + " ]";
    }
    
}
