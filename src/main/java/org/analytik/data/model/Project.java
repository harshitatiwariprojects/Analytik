package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "PROJECT")
@NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
@NamedQuery(name = "Project.findByProjectCode", query = "SELECT p FROM Project p WHERE p.projectCode = :projectCode")
@NamedQuery(name = "Project.findByProjectType", query = "SELECT p FROM Project p WHERE p.projectType = :projectType")
@NamedQuery(name = "Project.findByProjectRoiType", query = "SELECT p FROM Project p WHERE p.projectRoiType = :projectRoiType")
@NamedQuery(name = "Project.findByExecutionModel", query = "SELECT p FROM Project p WHERE p.executionModel = :executionModel")
@NamedQuery(name = "Project.findByPhase", query = "SELECT p FROM Project p WHERE p.phase = :phase")
@NamedQuery(name = "Project.findByStatus", query = "SELECT p FROM Project p WHERE p.status = :status")
@NamedQuery(name = "Project.findBySla", query = "SELECT p FROM Project p WHERE p.sla = :sla")
@NamedQuery(name = "Project.findByStartDate", query = "SELECT p FROM Project p WHERE p.startDate = :startDate")
@NamedQuery(name = "Project.findByEndDate", query = "SELECT p FROM Project p WHERE p.endDate = :endDate")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROJECT_CODE")
    private BigDecimal projectCode;
    @Column(name = "PROJECT_TYPE")
    private String projectType;
    @Column(name = "PROJECT_ROI_TYPE")
    private String projectRoiType;
    @Column(name = "EXECUTION_MODEL")
    private String executionModel;
    @Column(name = "PHASE")
    private String phase;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "SLA")
    private String sla;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @OneToMany(mappedBy = "projectCode")
    private Collection<ProjectBuMapping> projectBuMappingCollection;
    @OneToMany(mappedBy = "projectCode")
    private Collection<ProjectResourceMapping> projectResourceMappingCollection;
    @JoinColumn(name = "BU_ID", referencedColumnName = "BU_ID")
    @ManyToOne(optional = false)
    private Bu buId;
    @JoinColumn(name = "SKILLID", referencedColumnName = "SKILLID")
    @ManyToOne
    private Skillset skillid;
    @OneToMany(mappedBy = "orgProjectCode")
    private Collection<Timesheet> timesheetCollection;
    @OneToMany(mappedBy = "projectCode")
    private Collection<ProjectEmployeeMapping> projectEmployeeMappingCollection;
    @OneToMany(mappedBy = "projectCode")
    private Collection<Activity> activityCollection;

    public Project() {
    }

    public Project(BigDecimal projectCode) {
        this.projectCode = projectCode;
    }

    public BigDecimal getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(BigDecimal projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectRoiType() {
        return projectRoiType;
    }

    public void setProjectRoiType(String projectRoiType) {
        this.projectRoiType = projectRoiType;
    }

    public String getExecutionModel() {
        return executionModel;
    }

    public void setExecutionModel(String executionModel) {
        this.executionModel = executionModel;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSla() {
        return sla;
    }

    public void setSla(String sla) {
        this.sla = sla;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Collection<ProjectBuMapping> getProjectBuMappingCollection() {
        return projectBuMappingCollection;
    }

    public void setProjectBuMappingCollection(Collection<ProjectBuMapping> projectBuMappingCollection) {
        this.projectBuMappingCollection = projectBuMappingCollection;
    }

    public Collection<ProjectResourceMapping> getProjectResourceMappingCollection() {
        return projectResourceMappingCollection;
    }

    public void setProjectResourceMappingCollection(Collection<ProjectResourceMapping> projectResourceMappingCollection) {
        this.projectResourceMappingCollection = projectResourceMappingCollection;
    }

    public Bu getBuId() {
        return buId;
    }

    public void setBuId(Bu buId) {
        this.buId = buId;
    }

    public Skillset getSkillid() {
        return skillid;
    }

    public void setSkillid(Skillset skillid) {
        this.skillid = skillid;
    }

    public Collection<Timesheet> getTimesheetCollection() {
        return timesheetCollection;
    }

    public void setTimesheetCollection(Collection<Timesheet> timesheetCollection) {
        this.timesheetCollection = timesheetCollection;
    }

    public Collection<ProjectEmployeeMapping> getProjectEmployeeMappingCollection() {
        return projectEmployeeMappingCollection;
    }

    public void setProjectEmployeeMappingCollection(Collection<ProjectEmployeeMapping> projectEmployeeMappingCollection) {
        this.projectEmployeeMappingCollection = projectEmployeeMappingCollection;
    }

    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectCode != null ? projectCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof Project) {
      		
      		Project other = (Project) object;
              
      		if ((this.projectCode != null && other.projectCode != null) && (this.projectCode.equals(other.projectCode))) {
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
        return "Project[ projectCode=" + projectCode + " ]";
    }
    
}
