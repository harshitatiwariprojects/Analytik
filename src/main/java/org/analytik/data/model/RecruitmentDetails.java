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
@Table(name = "RECRUITMENT_DETAILS")
@NamedQuery(name = "RecruitmentDetails.findAll", query = "SELECT r FROM RecruitmentDetails r")
@NamedQuery(name = "RecruitmentDetails.findByRecruitmentDetId", query = "SELECT r FROM RecruitmentDetails r WHERE r.recruitmentDetId = :recruitmentDetId")
@NamedQuery(name = "RecruitmentDetails.findByStepType", query = "SELECT r FROM RecruitmentDetails r WHERE r.stepType = :stepType")
public class RecruitmentDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RECRUITMENT_DET_ID")
    private BigDecimal recruitmentDetId;
    @Column(name = "STEP_TYPE")
    private String stepType;
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")
    @ManyToOne
    private JobDescription jobId;
    @JoinColumn(name = "RECRUITMENT_ID", referencedColumnName = "RECRUITMENT_ID")
    @ManyToOne
    private Recruitment recruitmentId;

    public RecruitmentDetails() {
    }

    public RecruitmentDetails(BigDecimal recruitmentDetId) {
        this.recruitmentDetId = recruitmentDetId;
    }

    public BigDecimal getRecruitmentDetId() {
        return recruitmentDetId;
    }

    public void setRecruitmentDetId(BigDecimal recruitmentDetId) {
        this.recruitmentDetId = recruitmentDetId;
    }

    public String getStepType() {
        return stepType;
    }

    public void setStepType(String stepType) {
        this.stepType = stepType;
    }

    public JobDescription getJobId() {
        return jobId;
    }

    public void setJobId(JobDescription jobId) {
        this.jobId = jobId;
    }

    public Recruitment getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(Recruitment recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recruitmentDetId != null ? recruitmentDetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof RecruitmentDetails) {
      		
      		RecruitmentDetails other = (RecruitmentDetails) object;
              
      		if ((this.recruitmentDetId != null && other.recruitmentDetId != null) && (this.recruitmentDetId.equals(other.recruitmentDetId))) {
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
        return "RecruitmentDetails[ recruitmentDetId=" + recruitmentDetId + " ]";
    }
    
}
