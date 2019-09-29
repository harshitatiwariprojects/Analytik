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
@Table(name = "WORKFLOW_STEP_DETAILS")
@NamedQuery(name = "WorkflowStepDetails.findAll", query = "SELECT w FROM WorkflowStepDetails w")
@NamedQuery(name = "WorkflowStepDetails.findByStepDetailsId", query = "SELECT w FROM WorkflowStepDetails w WHERE w.stepDetailsId = :stepDetailsId")
@NamedQuery(name = "WorkflowStepDetails.findByStartTime", query = "SELECT w FROM WorkflowStepDetails w WHERE w.startTime = :startTime")
@NamedQuery(name = "WorkflowStepDetails.findByEndTime", query = "SELECT w FROM WorkflowStepDetails w WHERE w.endTime = :endTime")
@NamedQuery(name = "WorkflowStepDetails.findByStatus", query = "SELECT w FROM WorkflowStepDetails w WHERE w.status = :status")
public class WorkflowStepDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STEP_DETAILS_ID")
    private BigDecimal stepDetailsId;
    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "STEP_ID", referencedColumnName = "STEP_ID")
    @ManyToOne(optional = false)
    private WorkflowStep stepId;

    public WorkflowStepDetails() {
    }

    public WorkflowStepDetails(BigDecimal stepDetailsId) {
        this.stepDetailsId = stepDetailsId;
    }

    public BigDecimal getStepDetailsId() {
        return stepDetailsId;
    }

    public void setStepDetailsId(BigDecimal stepDetailsId) {
        this.stepDetailsId = stepDetailsId;
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

    public WorkflowStep getStepId() {
        return stepId;
    }

    public void setStepId(WorkflowStep stepId) {
        this.stepId = stepId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stepDetailsId != null ? stepDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof WorkflowStepDetails) {
      		
      		WorkflowStepDetails other = (WorkflowStepDetails) object;
              
      		if ((this.stepDetailsId != null && other.stepDetailsId != null) && (this.stepDetailsId.equals(other.stepDetailsId))) {
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
        return "WorkflowStepDetails[ stepDetailsId=" + stepDetailsId + " ]";
    }
    
}
