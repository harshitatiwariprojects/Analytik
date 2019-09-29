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
@Table(name = "JOB_DESCRIPTION")
@NamedQuery(name = "JobDescription.findAll", query = "SELECT j FROM JobDescription j")
@NamedQuery(name = "JobDescription.findByJobId", query = "SELECT j FROM JobDescription j WHERE j.jobId = :jobId")
@NamedQuery(name = "JobDescription.findByJobName", query = "SELECT j FROM JobDescription j WHERE j.jobName = :jobName")
@NamedQuery(name = "JobDescription.findByValidfrom", query = "SELECT j FROM JobDescription j WHERE j.validfrom = :validfrom")
@NamedQuery(name = "JobDescription.findByValidto", query = "SELECT j FROM JobDescription j WHERE j.validto = :validto")
@NamedQuery(name = "JobDescription.findByStatus", query = "SELECT j FROM JobDescription j WHERE j.status = :status")
public class JobDescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "JOB_ID")
    private BigDecimal jobId;
    @Column(name = "JOB_NAME")
    private String jobName;
    @Column(name = "VALIDFROM")
    @Temporal(TemporalType.DATE)
    private Date validfrom;
    @Column(name = "VALIDTO")
    @Temporal(TemporalType.DATE)
    private Date validto;
    @Column(name = "STATUS")
    private String status;
    @OneToMany(mappedBy = "jobId")
    private Collection<RecruitmentDetails> recruitmentDetailsCollection;
    @JoinColumn(name = "BU_ID", referencedColumnName = "BU_ID")
    @ManyToOne
    private Bu buId;
    @OneToMany(mappedBy = "jobId")
    private Collection<JobSkillMapping> jobSkillMappingCollection;

    public JobDescription() {
    }

    public JobDescription(BigDecimal jobId) {
        this.jobId = jobId;
    }

    public BigDecimal getJobId() {
        return jobId;
    }

    public void setJobId(BigDecimal jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Date getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(Date validfrom) {
        this.validfrom = validfrom;
    }

    public Date getValidto() {
        return validto;
    }

    public void setValidto(Date validto) {
        this.validto = validto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<RecruitmentDetails> getRecruitmentDetailsCollection() {
        return recruitmentDetailsCollection;
    }

    public void setRecruitmentDetailsCollection(Collection<RecruitmentDetails> recruitmentDetailsCollection) {
        this.recruitmentDetailsCollection = recruitmentDetailsCollection;
    }

    public Bu getBuId() {
        return buId;
    }

    public void setBuId(Bu buId) {
        this.buId = buId;
    }

    public Collection<JobSkillMapping> getJobSkillMappingCollection() {
        return jobSkillMappingCollection;
    }

    public void setJobSkillMappingCollection(Collection<JobSkillMapping> jobSkillMappingCollection) {
        this.jobSkillMappingCollection = jobSkillMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobId != null ? jobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
     	boolean isEqual = false;
      	
      	if(object instanceof JobDescription) {
      		
      		JobDescription other = (JobDescription) object;
              
      		if ((this.jobId != null && other.jobId != null) && (this.jobId.equals(other.jobId))) {
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
        return "JobDescription[ jobId=" + jobId + " ]";
    }
    
}
