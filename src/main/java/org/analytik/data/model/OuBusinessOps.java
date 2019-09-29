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
@Table(name = "OU_BUSINESS_OPS")
@NamedQuery(name = "OuBusinessOps.findAll", query = "SELECT o FROM OuBusinessOps o")
@NamedQuery(name = "OuBusinessOps.findByBusinessOpsId", query = "SELECT o FROM OuBusinessOps o WHERE o.businessOpsId = :businessOpsId")
@NamedQuery(name = "OuBusinessOps.findByName", query = "SELECT o FROM OuBusinessOps o WHERE o.name = :name")
@NamedQuery(name = "OuBusinessOps.findByType", query = "SELECT o FROM OuBusinessOps o WHERE o.type = :type")
public class OuBusinessOps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BUSINESS_OPS_ID")
    private BigDecimal businessOpsId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    private String type;
    @JoinColumn(name = "BUSINESS_OPS_HEAD", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee businessOpsHead;
    @JoinColumn(name = "BUSINESS_OPS_MANAGER", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee businessOpsManager;
    @JoinColumn(name = "WORKFLOW_ID", referencedColumnName = "WORKFLOW_ID")
    @ManyToOne
    private Workflow workflowId;

    public OuBusinessOps() {
    }

    public OuBusinessOps(BigDecimal businessOpsId) {
        this.businessOpsId = businessOpsId;
    }

    public BigDecimal getBusinessOpsId() {
        return businessOpsId;
    }

    public void setBusinessOpsId(BigDecimal businessOpsId) {
        this.businessOpsId = businessOpsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Employee getBusinessOpsHead() {
        return businessOpsHead;
    }

    public void setBusinessOpsHead(Employee businessOpsHead) {
        this.businessOpsHead = businessOpsHead;
    }

    public Employee getBusinessOpsManager() {
        return businessOpsManager;
    }

    public void setBusinessOpsManager(Employee businessOpsManager) {
        this.businessOpsManager = businessOpsManager;
    }

    public Workflow getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Workflow workflowId) {
        this.workflowId = workflowId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (businessOpsId != null ? businessOpsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof OuBusinessOps) {
      		
      		OuBusinessOps other = (OuBusinessOps) object;
              
      		if ((this.businessOpsId != null && other.businessOpsId != null) && (this.businessOpsId.equals(other.businessOpsId))) {
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
        return "OuBusinessOps[ businessOpsId=" + businessOpsId + " ]";
    }
    
}
