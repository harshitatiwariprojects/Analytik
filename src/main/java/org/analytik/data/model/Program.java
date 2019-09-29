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
@Table(name = "PROGRAM")
@NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p")
@NamedQuery(name = "Program.findByProgramId", query = "SELECT p FROM Program p WHERE p.programId = :programId")
@NamedQuery(name = "Program.findByProgramType", query = "SELECT p FROM Program p WHERE p.programType = :programType")
@NamedQuery(name = "Program.findByIspaid", query = "SELECT p FROM Program p WHERE p.ispaid = :ispaid")
public class Program implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROGRAM_ID")
    private BigDecimal programId;
    @Column(name = "PROGRAM_TYPE")
    private String programType;
    @Column(name = "ISPAID")
    private String ispaid;
    @JoinColumn(name = "BU_ID", referencedColumnName = "BU_ID")
    @ManyToOne
    private Bu buId;
    @JoinColumn(name = "PROGRAM_LEADER", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee programLeader;
    @JoinColumn(name = "PROGRAM_MANAGER", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee programManager;
    @JoinColumn(name = "PRACTICE_REVENUE_CENTER_CODE", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private OfficeAddress practiceRevenueCenterCode;
    @JoinColumn(name = "BU_COST_CENTER_CODE", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private OfficeAddress buCostCenterCode;
    @JoinColumn(name = "PRACTICE_COST_CENTER_CODE", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private OfficeAddress practiceCostCenterCode;
    @JoinColumn(name = "BU_REVENUE_CENTER_CODE", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private OfficeAddress buRevenueCenterCode;
    @JoinColumn(name = "PROGRAM_ORGANISATION_ID", referencedColumnName = "ORG_ID")
    @ManyToOne
    private Organisation programOrganisationId;
    @JoinColumn(name = "PRACTICE_ID", referencedColumnName = "PRACTICE_ID")
    @ManyToOne
    private Practice practiceId;

    public Program() {
    }

    public Program(BigDecimal programId) {
        this.programId = programId;
    }

    public BigDecimal getProgramId() {
        return programId;
    }

    public void setProgramId(BigDecimal programId) {
        this.programId = programId;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getIspaid() {
        return ispaid;
    }

    public void setIspaid(String ispaid) {
        this.ispaid = ispaid;
    }

    public Bu getBuId() {
        return buId;
    }

    public void setBuId(Bu buId) {
        this.buId = buId;
    }

    public Employee getProgramLeader() {
        return programLeader;
    }

    public void setProgramLeader(Employee programLeader) {
        this.programLeader = programLeader;
    }

    public Employee getProgramManager() {
        return programManager;
    }

    public void setProgramManager(Employee programManager) {
        this.programManager = programManager;
    }

    public OfficeAddress getPracticeRevenueCenterCode() {
        return practiceRevenueCenterCode;
    }

    public void setPracticeRevenueCenterCode(OfficeAddress practiceRevenueCenterCode) {
        this.practiceRevenueCenterCode = practiceRevenueCenterCode;
    }

    public OfficeAddress getBuCostCenterCode() {
        return buCostCenterCode;
    }

    public void setBuCostCenterCode(OfficeAddress buCostCenterCode) {
        this.buCostCenterCode = buCostCenterCode;
    }

    public OfficeAddress getPracticeCostCenterCode() {
        return practiceCostCenterCode;
    }

    public void setPracticeCostCenterCode(OfficeAddress practiceCostCenterCode) {
        this.practiceCostCenterCode = practiceCostCenterCode;
    }

    public OfficeAddress getBuRevenueCenterCode() {
        return buRevenueCenterCode;
    }

    public void setBuRevenueCenterCode(OfficeAddress buRevenueCenterCode) {
        this.buRevenueCenterCode = buRevenueCenterCode;
    }

    public Organisation getProgramOrganisationId() {
        return programOrganisationId;
    }

    public void setProgramOrganisationId(Organisation programOrganisationId) {
        this.programOrganisationId = programOrganisationId;
    }

    public Practice getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(Practice practiceId) {
        this.practiceId = practiceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programId != null ? programId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof Program) {
      		
      		Program other = (Program) object;
              
      		if ((this.programId != null && other.programId != null) && (this.programId.equals(other.programId))) {
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
        return "Program[ programId=" + programId + " ]";
    }
    
}
