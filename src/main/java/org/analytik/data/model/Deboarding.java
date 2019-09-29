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
@Table(name = "DEBOARDING")
@NamedQuery(name = "Deboarding.findAll", query = "SELECT d FROM Deboarding d")
@NamedQuery(name = "Deboarding.findByDeboardingId", query = "SELECT d FROM Deboarding d WHERE d.deboardingId = :deboardingId")
@NamedQuery(name = "Deboarding.findByStepType", query = "SELECT d FROM Deboarding d WHERE d.stepType = :stepType")
@NamedQuery(name = "Deboarding.findByStepStatus", query = "SELECT d FROM Deboarding d WHERE d.stepStatus = :stepStatus")
@NamedQuery(name = "Deboarding.findByStepStartTime", query = "SELECT d FROM Deboarding d WHERE d.stepStartTime = :stepStartTime")
@NamedQuery(name = "Deboarding.findByStepEndTime", query = "SELECT d FROM Deboarding d WHERE d.stepEndTime = :stepEndTime")
@NamedQuery(name = "Deboarding.findByStepProcessSla", query = "SELECT d FROM Deboarding d WHERE d.stepProcessSla = :stepProcessSla")
public class Deboarding implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DEBOARDING_ID")
    private BigDecimal deboardingId;
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

    public Deboarding() {
    }

    public Deboarding(BigDecimal deboardingId) {
        this.deboardingId = deboardingId;
    }

    public BigDecimal getDeboardingId() {
        return deboardingId;
    }

    public void setDeboardingId(BigDecimal deboardingId) {
        this.deboardingId = deboardingId;
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
        hash += (deboardingId != null ? deboardingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
               
     	boolean isEqual = false;
      	
      	if(object instanceof Deboarding) {
      		
      		Deboarding other = (Deboarding) object;
              
      		if ((this.deboardingId != null && other.deboardingId != null) && (this.deboardingId.equals(other.deboardingId))) {
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
        return "Deboarding[ deboardingId=" + deboardingId + " ]";
    }
    
}
