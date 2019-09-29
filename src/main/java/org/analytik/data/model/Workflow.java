package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "WORKFLOW")
@NamedQuery(name = "Workflow.findAll", query = "SELECT w FROM Workflow w")
@NamedQuery(name = "Workflow.findByWorkflowId", query = "SELECT w FROM Workflow w WHERE w.workflowId = :workflowId")
@NamedQuery(name = "Workflow.findByName", query = "SELECT w FROM Workflow w WHERE w.name = :name")
@NamedQuery(name = "Workflow.findByType", query = "SELECT w FROM Workflow w WHERE w.type = :type")
public class Workflow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "WORKFLOW_ID")
    private BigDecimal workflowId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    private String type;
    @OneToMany(mappedBy = "workflowId")
    private Collection<OuOps> ouOpsCollection;
    @OneToMany(mappedBy = "workflowId")
    private Collection<Process> processCollection;
    @OneToMany(mappedBy = "workflowId")
    private Collection<Deboarding> deboardingCollection;
    @OneToMany(mappedBy = "workflowId")
    private Collection<Onboarding> onboardingCollection;
    @OneToMany(mappedBy = "workflowId")
    private Collection<OuBusinessOps> ouBusinessOpsCollection;
    @OneToMany(mappedBy = "workflowId")
    private Collection<Recruitment> recruitmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workflowId")
    private Collection<WorkflowStep> workflowStepCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workflowId")
    private Collection<WorkflowDetails> workflowDetailsCollection;

    public Workflow() {
    }

    public Workflow(BigDecimal workflowId) {
        this.workflowId = workflowId;
    }

    public BigDecimal getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(BigDecimal workflowId) {
        this.workflowId = workflowId;
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

    public Collection<OuOps> getOuOpsCollection() {
        return ouOpsCollection;
    }

    public void setOuOpsCollection(Collection<OuOps> ouOpsCollection) {
        this.ouOpsCollection = ouOpsCollection;
    }

    public Collection<Process> getProcessCollection() {
        return processCollection;
    }

    public void setProcessCollection(Collection<Process> processCollection) {
        this.processCollection = processCollection;
    }

    public Collection<Deboarding> getDeboardingCollection() {
        return deboardingCollection;
    }

    public void setDeboardingCollection(Collection<Deboarding> deboardingCollection) {
        this.deboardingCollection = deboardingCollection;
    }

    public Collection<Onboarding> getOnboardingCollection() {
        return onboardingCollection;
    }

    public void setOnboardingCollection(Collection<Onboarding> onboardingCollection) {
        this.onboardingCollection = onboardingCollection;
    }

    public Collection<OuBusinessOps> getOuBusinessOpsCollection() {
        return ouBusinessOpsCollection;
    }

    public void setOuBusinessOpsCollection(Collection<OuBusinessOps> ouBusinessOpsCollection) {
        this.ouBusinessOpsCollection = ouBusinessOpsCollection;
    }

    public Collection<Recruitment> getRecruitmentCollection() {
        return recruitmentCollection;
    }

    public void setRecruitmentCollection(Collection<Recruitment> recruitmentCollection) {
        this.recruitmentCollection = recruitmentCollection;
    }

    public Collection<WorkflowStep> getWorkflowStepCollection() {
        return workflowStepCollection;
    }

    public void setWorkflowStepCollection(Collection<WorkflowStep> workflowStepCollection) {
        this.workflowStepCollection = workflowStepCollection;
    }

    public Collection<WorkflowDetails> getWorkflowDetailsCollection() {
        return workflowDetailsCollection;
    }

    public void setWorkflowDetailsCollection(Collection<WorkflowDetails> workflowDetailsCollection) {
        this.workflowDetailsCollection = workflowDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workflowId != null ? workflowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof Workflow) {
      		
      		Workflow other = (Workflow) object;
              
      		if ((this.workflowId != null && other.workflowId != null) && (this.workflowId.equals(other.workflowId))) {
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
        return "Workflow[ workflowId=" + workflowId + " ]";
    }
    
}
