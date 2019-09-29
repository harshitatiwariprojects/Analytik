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
@Table(name = "WORKFLOW_STEP_ACTIVITY")
@NamedQuery(name = "WorkflowStepActivity.findAll", query = "SELECT w FROM WorkflowStepActivity w")
@NamedQuery(name = "WorkflowStepActivity.findByActivityId", query = "SELECT w FROM WorkflowStepActivity w WHERE w.activityId = :activityId")
@NamedQuery(name = "WorkflowStepActivity.findByName", query = "SELECT w FROM WorkflowStepActivity w WHERE w.name = :name")
@NamedQuery(name = "WorkflowStepActivity.findBySequence", query = "SELECT w FROM WorkflowStepActivity w WHERE w.sequence = :sequence")
@NamedQuery(name = "WorkflowStepActivity.findByRemarks", query = "SELECT w FROM WorkflowStepActivity w WHERE w.remarks = :remarks")
@NamedQuery(name = "WorkflowStepActivity.findByActions", query = "SELECT w FROM WorkflowStepActivity w WHERE w.actions = :actions")
public class WorkflowStepActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ACTIVITY_ID")
    private BigDecimal activityId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SEQUENCE")
    private BigInteger sequence;
    @Column(name = "REMARKS")
    private Character remarks;
    @Column(name = "ACTIONS")
    private String actions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activityId")
    private Collection<StepActivityDetails> stepActivityDetailsCollection;
    @JoinColumn(name = "STEP_ID", referencedColumnName = "STEP_ID")
    @ManyToOne(optional = false)
    private WorkflowStep stepId;

    public WorkflowStepActivity() {
    }

    public WorkflowStepActivity(BigDecimal activityId) {
        this.activityId = activityId;
    }

    public BigDecimal getActivityId() {
        return activityId;
    }

    public void setActivityId(BigDecimal activityId) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getSequence() {
        return sequence;
    }

    public void setSequence(BigInteger sequence) {
        this.sequence = sequence;
    }

    public Character getRemarks() {
        return remarks;
    }

    public void setRemarks(Character remarks) {
        this.remarks = remarks;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public Collection<StepActivityDetails> getStepActivityDetailsCollection() {
        return stepActivityDetailsCollection;
    }

    public void setStepActivityDetailsCollection(Collection<StepActivityDetails> stepActivityDetailsCollection) {
        this.stepActivityDetailsCollection = stepActivityDetailsCollection;
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
        hash += (activityId != null ? activityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof WorkflowStepActivity) {
      		
      		WorkflowStepActivity other = (WorkflowStepActivity) object;
              
      		if ((this.activityId != null && other.activityId != null) && (this.activityId.equals(other.activityId))) {
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
        return "WorkflowStepActivity[ activityId=" + activityId + " ]";
    }
    
}
