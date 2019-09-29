package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "ACTIVITY")
@NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a")
@NamedQuery(name = "Activity.findByActivityId", query = "SELECT a FROM Activity a WHERE a.activityId = :activityId")
@NamedQuery(name = "Activity.findByActivityName", query = "SELECT a FROM Activity a WHERE a.activityName = :activityName")
@NamedQuery(name = "Activity.findByPriorityLevel", query = "SELECT a FROM Activity a WHERE a.priorityLevel = :priorityLevel")
@NamedQuery(name = "Activity.findByDescription", query = "SELECT a FROM Activity a WHERE a.description = :description")
@NamedQuery(name = "Activity.findByPlannedStartDate", query = "SELECT a FROM Activity a WHERE a.plannedStartDate = :plannedStartDate")
@NamedQuery(name = "Activity.findByPlannedEndDate", query = "SELECT a FROM Activity a WHERE a.plannedEndDate = :plannedEndDate")
@NamedQuery(name = "Activity.findByPlannedBudget", query = "SELECT a FROM Activity a WHERE a.plannedBudget = :plannedBudget")
@NamedQuery(name = "Activity.findByActualStartDate", query = "SELECT a FROM Activity a WHERE a.actualStartDate = :actualStartDate")
@NamedQuery(name = "Activity.findByActualEndDate", query = "SELECT a FROM Activity a WHERE a.actualEndDate = :actualEndDate")
@NamedQuery(name = "Activity.findByActualBudget", query = "SELECT a FROM Activity a WHERE a.actualBudget = :actualBudget")
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ACTIVITY_ID")
    private BigDecimal activityId;
    @Column(name = "ACTIVITY_NAME")
    private String activityName;
    @Column(name = "PRIORITY_LEVEL")
    private String priorityLevel;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PLANNED_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date plannedStartDate;
    @Column(name = "PLANNED_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date plannedEndDate;
    @Column(name = "PLANNED_BUDGET")
    private BigInteger plannedBudget;
    @Column(name = "ACTUAL_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date actualStartDate;
    @Column(name = "ACTUAL_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date actualEndDate;
    @Column(name = "ACTUAL_BUDGET")
    private BigInteger actualBudget;
    @OneToMany(mappedBy = "activityId")
    private Collection<ResourceAvailability> resourceAvailabilityCollection;
    @JoinColumn(name = "PROJECT_CODE", referencedColumnName = "PROJECT_CODE")
    @ManyToOne
    private Project projectCode;

    public Activity() {
    }

    public Activity(BigDecimal activityId) {
        this.activityId = activityId;
    }

    public BigDecimal getActivityId() {
        return activityId;
    }

    public void setActivityId(BigDecimal activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(Date plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public BigInteger getPlannedBudget() {
        return plannedBudget;
    }

    public void setPlannedBudget(BigInteger plannedBudget) {
        this.plannedBudget = plannedBudget;
    }

    public Date getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(Date actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public BigInteger getActualBudget() {
        return actualBudget;
    }

    public void setActualBudget(BigInteger actualBudget) {
        this.actualBudget = actualBudget;
    }

    public Collection<ResourceAvailability> getResourceAvailabilityCollection() {
        return resourceAvailabilityCollection;
    }

    public void setResourceAvailabilityCollection(Collection<ResourceAvailability> resourceAvailabilityCollection) {
        this.resourceAvailabilityCollection = resourceAvailabilityCollection;
    }

    public Project getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(Project projectCode) {
        this.projectCode = projectCode;
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
    	
    	if(object instanceof Activity) {
    		
    		Activity other = (Activity) object;
            
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
        return "Activity[ activityId=" + activityId + " ]";
    }
    
}
