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
@Table(name = "WORKFLOW_STEP")
@NamedQuery(name = "WorkflowStep.findAll", query = "SELECT w FROM WorkflowStep w")
@NamedQuery(name = "WorkflowStep.findByStepId", query = "SELECT w FROM WorkflowStep w WHERE w.stepId = :stepId")
@NamedQuery(name = "WorkflowStep.findByName", query = "SELECT w FROM WorkflowStep w WHERE w.name = :name")
@NamedQuery(name = "WorkflowStep.findBySequence", query = "SELECT w FROM WorkflowStep w WHERE w.sequence = :sequence")
public class WorkflowStep implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STEP_ID")
    private BigDecimal stepId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SEQUENCE")
    private BigInteger sequence;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stepId")
    private Collection<WorkflowStepDetails> workflowStepDetailsCollection;
    @JoinColumn(name = "WORKFLOW_ID", referencedColumnName = "WORKFLOW_ID")
    @ManyToOne(optional = false)
    private Workflow workflowId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stepId")
    private Collection<WorkflowStepActivity> workflowStepActivityCollection;

    public WorkflowStep() {
    }

    public WorkflowStep(BigDecimal stepId) {
        this.stepId = stepId;
    }

    public BigDecimal getStepId() {
        return stepId;
    }

    public void setStepId(BigDecimal stepId) {
        this.stepId = stepId;
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

    public Collection<WorkflowStepDetails> getWorkflowStepDetailsCollection() {
        return workflowStepDetailsCollection;
    }

    public void setWorkflowStepDetailsCollection(Collection<WorkflowStepDetails> workflowStepDetailsCollection) {
        this.workflowStepDetailsCollection = workflowStepDetailsCollection;
    }

    public Workflow getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Workflow workflowId) {
        this.workflowId = workflowId;
    }

    public Collection<WorkflowStepActivity> getWorkflowStepActivityCollection() {
        return workflowStepActivityCollection;
    }

    public void setWorkflowStepActivityCollection(Collection<WorkflowStepActivity> workflowStepActivityCollection) {
        this.workflowStepActivityCollection = workflowStepActivityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stepId != null ? stepId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof WorkflowStep) {
      		
      		WorkflowStep other = (WorkflowStep) object;
              
      		if ((this.stepId != null && other.stepId != null) && (this.stepId.equals(other.stepId))) {
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
        return "WorkflowStep[ stepId=" + stepId + " ]";
    }
    
}
