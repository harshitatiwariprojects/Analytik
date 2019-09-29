package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Defines Model.
 * @author Harshita Tiwari
 * Copyright 2019 by Harshita Tiwari. All rights reserved.
 *
 */

@Entity
@Table(name = "WORKFLOW_DETAILS")
@NamedQuery(name = "WorkflowDetails.findAll", query = "SELECT w FROM WorkflowDetails w")
@NamedQuery(name = "WorkflowDetails.findByWorkflowDetailsId", query = "SELECT w FROM WorkflowDetails w WHERE w.workflowDetailsId = :workflowDetailsId")
@NamedQuery(name = "WorkflowDetails.findByStartTime", query = "SELECT w FROM WorkflowDetails w WHERE w.startTime = :startTime")
@NamedQuery(name = "WorkflowDetails.findByEndTime", query = "SELECT w FROM WorkflowDetails w WHERE w.endTime = :endTime")
@NamedQuery(name = "WorkflowDetails.findByStatus", query = "SELECT w FROM WorkflowDetails w WHERE w.status = :status")
public class WorkflowDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "WORKFLOW_DETAILS_ID")
    private BigDecimal workflowDetailsId;
    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "WORKFLOW_ID", referencedColumnName = "WORKFLOW_ID")
    @ManyToOne(optional = false)
    private Workflow workflowId;

    public WorkflowDetails() {
    }

    public WorkflowDetails(BigDecimal workflowDetailsId) {
        this.workflowDetailsId = workflowDetailsId;
    }

    public BigDecimal getWorkflowDetailsId() {
        return workflowDetailsId;
    }

    public void setWorkflowDetailsId(BigDecimal workflowDetailsId) {
        this.workflowDetailsId = workflowDetailsId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        hash += (workflowDetailsId != null ? workflowDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof WorkflowDetails) {
      		
      		WorkflowDetails other = (WorkflowDetails) object;
              
      		if ((this.workflowDetailsId != null && other.workflowDetailsId != null) && (this.workflowDetailsId.equals(other.workflowDetailsId))) {
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
        return "WorkflowDetails[ workflowDetailsId=" + workflowDetailsId + " ]";
    }
    
}
