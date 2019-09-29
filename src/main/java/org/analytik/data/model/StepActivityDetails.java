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
@Table(name = "STEP_ACTIVITY_DETAILS")
@NamedQuery(name = "StepActivityDetails.findAll", query = "SELECT s FROM StepActivityDetails s")
@NamedQuery(name = "StepActivityDetails.findByActivityDetailsId", query = "SELECT s FROM StepActivityDetails s WHERE s.activityDetailsId = :activityDetailsId")
@NamedQuery(name = "StepActivityDetails.findByStartTime", query = "SELECT s FROM StepActivityDetails s WHERE s.startTime = :startTime")
@NamedQuery(name = "StepActivityDetails.findByEndTime", query = "SELECT s FROM StepActivityDetails s WHERE s.endTime = :endTime")
@NamedQuery(name = "StepActivityDetails.findByStatus", query = "SELECT s FROM StepActivityDetails s WHERE s.status = :status")
public class StepActivityDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ACTIVITY_DETAILS_ID")
    private BigDecimal activityDetailsId;
    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "END_USER", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(optional = false)
    private Employee endUser;
    @JoinColumn(name = "ACTIVITY_OWNER", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(optional = false)
    private Employee activityOwner;
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ACTIVITY_ID")
    @ManyToOne(optional = false)
    private WorkflowStepActivity activityId;

    public StepActivityDetails() {
    }

    public StepActivityDetails(BigDecimal activityDetailsId) {
        this.activityDetailsId = activityDetailsId;
    }

    public BigDecimal getActivityDetailsId() {
        return activityDetailsId;
    }

    public void setActivityDetailsId(BigDecimal activityDetailsId) {
        this.activityDetailsId = activityDetailsId;
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

    public Employee getEndUser() {
        return endUser;
    }

    public void setEndUser(Employee endUser) {
        this.endUser = endUser;
    }

    public Employee getActivityOwner() {
        return activityOwner;
    }

    public void setActivityOwner(Employee activityOwner) {
        this.activityOwner = activityOwner;
    }

    public WorkflowStepActivity getActivityId() {
        return activityId;
    }

    public void setActivityId(WorkflowStepActivity activityId) {
        this.activityId = activityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activityDetailsId != null ? activityDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof StepActivityDetails) {
      		
      		StepActivityDetails other = (StepActivityDetails) object;
              
      		if ((this.activityDetailsId != null && other.activityDetailsId != null) && (this.activityDetailsId.equals(other.activityDetailsId))) {
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
        return "StepActivityDetails[ activityDetailsId=" + activityDetailsId + " ]";
    }
    
}
