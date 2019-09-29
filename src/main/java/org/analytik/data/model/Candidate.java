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
@Table(name = "CANDIDATE")
@NamedQuery(name = "Candidate.findAll", query = "SELECT c FROM Candidate c")
@NamedQuery(name = "Candidate.findByCandidateId", query = "SELECT c FROM Candidate c WHERE c.candidateId = :candidateId")
@NamedQuery(name = "Candidate.findByFirstname", query = "SELECT c FROM Candidate c WHERE c.firstname = :firstname")
@NamedQuery(name = "Candidate.findByLastname", query = "SELECT c FROM Candidate c WHERE c.lastname = :lastname")
@NamedQuery(name = "Candidate.findByMiddlename", query = "SELECT c FROM Candidate c WHERE c.middlename = :middlename")
@NamedQuery(name = "Candidate.findByGender", query = "SELECT c FROM Candidate c WHERE c.gender = :gender")
@NamedQuery(name = "Candidate.findByDob", query = "SELECT c FROM Candidate c WHERE c.dob = :dob")
@NamedQuery(name = "Candidate.findByPhonenumber", query = "SELECT c FROM Candidate c WHERE c.phonenumber = :phonenumber")
@NamedQuery(name = "Candidate.findByEmail", query = "SELECT c FROM Candidate c WHERE c.email = :email")
@NamedQuery(name = "Candidate.findByRegistrationDate", query = "SELECT c FROM Candidate c WHERE c.registrationDate = :registrationDate")
@NamedQuery(name = "Candidate.findByExamDate", query = "SELECT c FROM Candidate c WHERE c.examDate = :examDate")
@NamedQuery(name = "Candidate.findByInterviewDate", query = "SELECT c FROM Candidate c WHERE c.interviewDate = :interviewDate")
@NamedQuery(name = "Candidate.findByOfferDate", query = "SELECT c FROM Candidate c WHERE c.offerDate = :offerDate")
@NamedQuery(name = "Candidate.findByJoiningDate", query = "SELECT c FROM Candidate c WHERE c.joiningDate = :joiningDate")
@NamedQuery(name = "Candidate.findByLastAttempted", query = "SELECT c FROM Candidate c WHERE c.lastAttempted = :lastAttempted")
@NamedQuery(name = "Candidate.findByLastAttemptedStatus", query = "SELECT c FROM Candidate c WHERE c.lastAttemptedStatus = :lastAttemptedStatus")
@NamedQuery(name = "Candidate.findByProcessGestationPeriod", query = "SELECT c FROM Candidate c WHERE c.processGestationPeriod = :processGestationPeriod")
@NamedQuery(name = "Candidate.findByPreviousSalary", query = "SELECT c FROM Candidate c WHERE c.previousSalary = :previousSalary")
@NamedQuery(name = "Candidate.findByExpectedSalary", query = "SELECT c FROM Candidate c WHERE c.expectedSalary = :expectedSalary")
@NamedQuery(name = "Candidate.findByOfferSalary", query = "SELECT c FROM Candidate c WHERE c.offerSalary = :offerSalary")
@NamedQuery(name = "Candidate.findByStatus", query = "SELECT c FROM Candidate c WHERE c.status = :status")
@NamedQuery(name = "Candidate.findByRemarks", query = "SELECT c FROM Candidate c WHERE c.remarks = :remarks")
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CANDIDATE_ID")
    private BigDecimal candidateId;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "MIDDLENAME")
    private String middlename;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "PHONENUMBER")
    private BigInteger phonenumber;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "REGISTRATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    @Column(name = "EXAM_DATE")
    @Temporal(TemporalType.DATE)
    private Date examDate;
    @Column(name = "INTERVIEW_DATE")
    @Temporal(TemporalType.DATE)
    private Date interviewDate;
    @Column(name = "OFFER_DATE")
    @Temporal(TemporalType.DATE)
    private Date offerDate;
    @Column(name = "JOINING_DATE")
    @Temporal(TemporalType.DATE)
    private Date joiningDate;
    @Column(name = "LAST_ATTEMPTED")
    @Temporal(TemporalType.DATE)
    private Date lastAttempted;
    @Column(name = "LAST_ATTEMPTED_STATUS")
    private String lastAttemptedStatus;
    @Column(name = "PROCESS_GESTATION_PERIOD")
    @Temporal(TemporalType.DATE)
    private Date processGestationPeriod;
    @Column(name = "PREVIOUS_SALARY")
    private BigInteger previousSalary;
    @Column(name = "EXPECTED_SALARY")
    private BigInteger expectedSalary;
    @Column(name = "OFFER_SALARY")
    private BigInteger offerSalary;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "REMARKS")
    private String remarks;
    @JoinColumn(name = "HR", referencedColumnName = "HR_ID")
    @ManyToOne
    private Hr hr;

    public Candidate() {
    }

    public Candidate(BigDecimal candidateId) {
        this.candidateId = candidateId;
    }

    public BigDecimal getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(BigDecimal candidateId) {
        this.candidateId = candidateId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public BigInteger getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(BigInteger phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public Date getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getLastAttempted() {
        return lastAttempted;
    }

    public void setLastAttempted(Date lastAttempted) {
        this.lastAttempted = lastAttempted;
    }

    public String getLastAttemptedStatus() {
        return lastAttemptedStatus;
    }

    public void setLastAttemptedStatus(String lastAttemptedStatus) {
        this.lastAttemptedStatus = lastAttemptedStatus;
    }

    public Date getProcessGestationPeriod() {
        return processGestationPeriod;
    }

    public void setProcessGestationPeriod(Date processGestationPeriod) {
        this.processGestationPeriod = processGestationPeriod;
    }

    public BigInteger getPreviousSalary() {
        return previousSalary;
    }

    public void setPreviousSalary(BigInteger previousSalary) {
        this.previousSalary = previousSalary;
    }

    public BigInteger getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(BigInteger expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public BigInteger getOfferSalary() {
        return offerSalary;
    }

    public void setOfferSalary(BigInteger offerSalary) {
        this.offerSalary = offerSalary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Hr getHr() {
        return hr;
    }

    public void setHr(Hr hr) {
        this.hr = hr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (candidateId != null ? candidateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
    	boolean isEqual = false;
    	
    	if(object instanceof Candidate) {
    		
    		Candidate other = (Candidate) object;
            
    		if ((this.candidateId != null && other.candidateId != null) && (this.candidateId.equals(other.candidateId))) {
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
        return "Candidate[ candidateId=" + candidateId + " ]";
    }
    
}
