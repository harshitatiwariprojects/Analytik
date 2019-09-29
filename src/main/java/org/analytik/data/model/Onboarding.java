package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "ONBOARDING")
@NamedQuery(name = "Onboarding.findAll", query = "SELECT o FROM Onboarding o")
@NamedQuery(name = "Onboarding.findByOnboardingId", query = "SELECT o FROM Onboarding o WHERE o.onboardingId = :onboardingId")
@NamedQuery(name = "Onboarding.findByStepType", query = "SELECT o FROM Onboarding o WHERE o.stepType = :stepType")
@NamedQuery(name = "Onboarding.findByStepStatus", query = "SELECT o FROM Onboarding o WHERE o.stepStatus = :stepStatus")
@NamedQuery(name = "Onboarding.findByStepStartTime", query = "SELECT o FROM Onboarding o WHERE o.stepStartTime = :stepStartTime")
@NamedQuery(name = "Onboarding.findByStepEndTime", query = "SELECT o FROM Onboarding o WHERE o.stepEndTime = :stepEndTime")
@NamedQuery(name = "Onboarding.findByStepProcessSla", query = "SELECT o FROM Onboarding o WHERE o.stepProcessSla = :stepProcessSla")
public class Onboarding implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ONBOARDING_ID")
    private BigDecimal onboardingId;
    @Column(name = "STEP_TYPE")
    private String stepType;
    @Column(name = "STEP_STATUS")
    private String stepStatus;
    @Column(name = "STEP_START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stepStartTime;
    @Column(name = "STEP_END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stepEndTime;
    @Column(name = "STEP_PROCESS_SLA")
    private BigInteger stepProcessSla;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee employeeId;
    @JoinColumn(name = "HR", referencedColumnName = "HR_ID")
    @ManyToOne
    private Hr hr;
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private OfficeAddress addressId;
    @JoinColumn(name = "PROCESS_ID", referencedColumnName = "PROCESS_ID")
    @ManyToOne
    private Process processId;
    @JoinColumn(name = "WORKFLOW_ID", referencedColumnName = "WORKFLOW_ID")
    @ManyToOne
    private Workflow workflowId;

    public Onboarding() {
    }

    public Onboarding(BigDecimal onboardingId) {
        this.onboardingId = onboardingId;
    }

    public BigDecimal getOnboardingId() {
        return onboardingId;
    }

    public void setOnboardingId(BigDecimal onboardingId) {
        this.onboardingId = onboardingId;
    }

    public String getStepType() {
        return stepType;
    }

    public void setStepType(String stepType) {
        this.stepType = stepType;
    }

    public String getStepStatus() {
        return stepStatus;
    }

    public void setStepStatus(String stepStatus) {
        this.stepStatus = stepStatus;
    }

    public Date getStepStartTime() {
        return stepStartTime;
    }

    public void setStepStartTime(Date stepStartTime) {
        this.stepStartTime = stepStartTime;
    }

    public Date getStepEndTime() {
        return stepEndTime;
    }

    public void setStepEndTime(Date stepEndTime) {
        this.stepEndTime = stepEndTime;
    }

    public BigInteger getStepProcessSla() {
        return stepProcessSla;
    }

    public void setStepProcessSla(BigInteger stepProcessSla) {
        this.stepProcessSla = stepProcessSla;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Hr getHr() {
        return hr;
    }

    public void setHr(Hr hr) {
        this.hr = hr;
    }

    public OfficeAddress getAddressId() {
        return addressId;
    }

    public void setAddressId(OfficeAddress addressId) {
        this.addressId = addressId;
    }

    public Process getProcessId() {
        return processId;
    }

    public void setProcessId(Process processId) {
        this.processId = processId;
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
        hash += (onboardingId != null ? onboardingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
     	boolean isEqual = false;
      	
      	if(object instanceof Onboarding) {
      		
      		Onboarding other = (Onboarding) object;
              
      		if ((this.onboardingId != null && other.onboardingId != null) && (this.onboardingId.equals(other.onboardingId))) {
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
        return "Onboarding[ onboardingId=" + onboardingId + " ]";
    }
    
}
