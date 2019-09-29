package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Basic;
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
@Table(name = "SKILLSET")
@NamedQuery(name = "Skillset.findAll", query = "SELECT s FROM Skillset s")
@NamedQuery(name = "Skillset.findBySkillid", query = "SELECT s FROM Skillset s WHERE s.skillId = :skillId")
@NamedQuery(name = "Skillset.findBySkillName", query = "SELECT s FROM Skillset s WHERE s.skillName = :skillName")
public class Skillset implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SKILLID")
    private BigDecimal skillId;
    @Column(name = "SKILL_NAME")
    private String skillName;
    @OneToMany(mappedBy = "skillid1")
    private Collection<EmployeeProfile> employeeprofileCollection;
    @OneToMany(mappedBy = "skillid3")
    private Collection<EmployeeProfile> employeeprofileCollection1;
    @OneToMany(mappedBy = "skillid2")
    private Collection<EmployeeProfile> employeeprofileCollection2;
    @OneToMany(mappedBy = "skillid")
    private Collection<JobSkillMapping> jobSkillMappingCollection;
    @OneToMany(mappedBy = "skillid")
    private Collection<Project> projectCollection;
    @OneToMany(mappedBy = "skillid")
    private Collection<SalaryBand> salaryBandCollection;

    public Skillset() {
    }

    public Skillset(BigDecimal skillid) {
        this.skillId = skillid;
    }

    public BigDecimal getSkillid() {
        return skillId;
    }

    public void setSkillid(BigDecimal skillid) {
        this.skillId = skillid;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Collection<EmployeeProfile> getEmployeeprofileCollection() {
        return employeeprofileCollection;
    }

    public void setEmployeeprofileCollection(Collection<EmployeeProfile> employeeprofileCollection) {
        this.employeeprofileCollection = employeeprofileCollection;
    }

    public Collection<EmployeeProfile> getEmployeeprofileCollection1() {
        return employeeprofileCollection1;
    }

    public void setEmployeeprofileCollection1(Collection<EmployeeProfile> employeeprofileCollection1) {
        this.employeeprofileCollection1 = employeeprofileCollection1;
    }

    public Collection<EmployeeProfile> getEmployeeprofileCollection2() {
        return employeeprofileCollection2;
    }

    public void setEmployeeprofileCollection2(Collection<EmployeeProfile> employeeprofileCollection2) {
        this.employeeprofileCollection2 = employeeprofileCollection2;
    }

    public Collection<JobSkillMapping> getJobSkillMappingCollection() {
        return jobSkillMappingCollection;
    }

    public void setJobSkillMappingCollection(Collection<JobSkillMapping> jobSkillMappingCollection) {
        this.jobSkillMappingCollection = jobSkillMappingCollection;
    }

    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    public Collection<SalaryBand> getSalaryBandCollection() {
        return salaryBandCollection;
    }

    public void setSalaryBandCollection(Collection<SalaryBand> salaryBandCollection) {
        this.salaryBandCollection = salaryBandCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skillId != null ? skillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof Skillset) {
      		
      		Skillset other = (Skillset) object;
              
      		if ((this.skillId != null && other.skillId != null) && (this.skillId.equals(other.skillId))) {
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
        return "Skillset[ skillId=" + skillId + " ]";
    }
    
}
