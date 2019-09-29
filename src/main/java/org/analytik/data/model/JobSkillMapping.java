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
@Table(name = "JOB_SKILL_MAPPING")
@NamedQuery(name = "JobSkillMapping.findAll", query = "SELECT j FROM JobSkillMapping j")
@NamedQuery(name = "JobSkillMapping.findByJsmId", query = "SELECT j FROM JobSkillMapping j WHERE j.jsmId = :jsmId")
public class JobSkillMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "JSM_ID")
    private BigDecimal jsmId;
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")
    @ManyToOne
    private JobDescription jobId;
    @JoinColumn(name = "SKILLID", referencedColumnName = "SKILLID")
    @ManyToOne
    private Skillset skillid;

    public JobSkillMapping() {
    }

    public JobSkillMapping(BigDecimal jsmId) {
        this.jsmId = jsmId;
    }

    public BigDecimal getJsmId() {
        return jsmId;
    }

    public void setJsmId(BigDecimal jsmId) {
        this.jsmId = jsmId;
    }

    public JobDescription getJobId() {
        return jobId;
    }

    public void setJobId(JobDescription jobId) {
        this.jobId = jobId;
    }

    public Skillset getSkillid() {
        return skillid;
    }

    public void setSkillid(Skillset skillid) {
        this.skillid = skillid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jsmId != null ? jsmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
     	boolean isEqual = false;
      	
      	if(object instanceof JobSkillMapping) {
      		
      		JobSkillMapping other = (JobSkillMapping) object;
              
      		if ((this.jsmId != null && other.jsmId != null) && (this.jsmId.equals(other.jsmId))) {
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
        return "JobSkillMapping[ jsmId=" + jsmId + " ]";
    }
    
}
