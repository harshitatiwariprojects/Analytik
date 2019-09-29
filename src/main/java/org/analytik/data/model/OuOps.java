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
@Table(name = "OU_OPS")
@NamedQuery(name = "OuOps.findAll", query = "SELECT o FROM OuOps o")
@NamedQuery(name = "OuOps.findByOpsId", query = "SELECT o FROM OuOps o WHERE o.opsId = :opsId")
@NamedQuery(name = "OuOps.findByName", query = "SELECT o FROM OuOps o WHERE o.name = :name")
@NamedQuery(name = "OuOps.findByType", query = "SELECT o FROM OuOps o WHERE o.type = :type")
public class OuOps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "OPS_ID")
    private BigDecimal opsId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    private String type;
    @JoinColumn(name = "OPS_HEAD", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee opsHead;
    @JoinColumn(name = "OPS_MANAGER", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee opsManager;
    @JoinColumn(name = "WORKFLOW_ID", referencedColumnName = "WORKFLOW_ID")
    @ManyToOne
    private Workflow workflowId;

    public OuOps() {
    }

    public OuOps(BigDecimal opsId) {
        this.opsId = opsId;
    }

    public BigDecimal getOpsId() {
        return opsId;
    }

    public void setOpsId(BigDecimal opsId) {
        this.opsId = opsId;
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

    public Employee getOpsHead() {
        return opsHead;
    }

    public void setOpsHead(Employee opsHead) {
        this.opsHead = opsHead;
    }

    public Employee getOpsManager() {
        return opsManager;
    }

    public void setOpsManager(Employee opsManager) {
        this.opsManager = opsManager;
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
        hash += (opsId != null ? opsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof OuOps) {
      		
      		OuOps other = (OuOps) object;
              
      		if ((this.opsId != null && other.opsId != null) && (this.opsId.equals(other.opsId))) {
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
        return "OuOps[ opsId=" + opsId + " ]";
    }
    
}
