package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Basic;
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
@Table(name = "PROCESS")
@NamedQuery(name = "Process.findAll", query = "SELECT p FROM Process p")
@NamedQuery(name = "Process.findByProcessId", query = "SELECT p FROM Process p WHERE p.processId = :processId")
@NamedQuery(name = "Process.findByProcessType", query = "SELECT p FROM Process p WHERE p.processType = :processType")
public class Process implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROCESS_ID")
    private BigDecimal processId;
    @Column(name = "PROCESS_TYPE")
    private String processType;
    @JoinColumn(name = "PROCESS_CONTACT", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee processContact;
    @JoinColumn(name = "PROCESS_OWNER", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee processOwner;
    @JoinColumn(name = "PROCESS_HELPDESK", referencedColumnName = "HELPDESK_ID")
    @ManyToOne
    private Helpdesk processHelpdesk;
    @JoinColumn(name = "WORKFLOW_ID", referencedColumnName = "WORKFLOW_ID")
    @ManyToOne
    private Workflow workflowId;
    @OneToMany(mappedBy = "processId")
    private Collection<Deboarding> deboardingCollection;
    @OneToMany(mappedBy = "processId")
    private Collection<Onboarding> onboardingCollection;
    @OneToMany(mappedBy = "processId")
    private Collection<Recruitment> recruitmentCollection;

    public Process() {
    }

    public Process(BigDecimal processId) {
        this.processId = processId;
    }

    public BigDecimal getProcessId() {
        return processId;
    }

    public void setProcessId(BigDecimal processId) {
        this.processId = processId;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public Employee getProcessContact() {
        return processContact;
    }

    public void setProcessContact(Employee processContact) {
        this.processContact = processContact;
    }

    public Employee getProcessOwner() {
        return processOwner;
    }

    public void setProcessOwner(Employee processOwner) {
        this.processOwner = processOwner;
    }

    public Helpdesk getProcessHelpdesk() {
        return processHelpdesk;
    }

    public void setProcessHelpdesk(Helpdesk processHelpdesk) {
        this.processHelpdesk = processHelpdesk;
    }

    public Workflow getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Workflow workflowId) {
        this.workflowId = workflowId;
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

    public Collection<Recruitment> getRecruitmentCollection() {
        return recruitmentCollection;
    }

    public void setRecruitmentCollection(Collection<Recruitment> recruitmentCollection) {
        this.recruitmentCollection = recruitmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (processId != null ? processId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof Process) {
      		
      		Process other = (Process) object;
              
      		if ((this.processId != null && other.processId != null) && (this.processId.equals(other.processId))) {
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
        return "Process[ processId=" + processId + " ]";
    }
    
}
