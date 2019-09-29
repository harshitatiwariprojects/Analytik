package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "SALARY_BAND")
@NamedQuery(name = "SalaryBand.findAll", query = "SELECT s FROM SalaryBand s")
@NamedQuery(name = "SalaryBand.findByBandId", query = "SELECT s FROM SalaryBand s WHERE s.bandId = :bandId")
@NamedQuery(name = "SalaryBand.findByMinimumSalary", query = "SELECT s FROM SalaryBand s WHERE s.minimumSalary = :minimumSalary")
@NamedQuery(name = "SalaryBand.findByMaximumSalary", query = "SELECT s FROM SalaryBand s WHERE s.maximumSalary = :maximumSalary")
@NamedQuery(name = "SalaryBand.findByMarketSalary", query = "SELECT s FROM SalaryBand s WHERE s.marketSalary = :marketSalary")
@NamedQuery(name = "SalaryBand.findByJoiningBonus", query = "SELECT s FROM SalaryBand s WHERE s.joiningBonus = :joiningBonus")
@NamedQuery(name = "SalaryBand.findByJoiningBonusEffDt", query = "SELECT s FROM SalaryBand s WHERE s.joiningBonusEffDt = :joiningBonusEffDt")
@NamedQuery(name = "SalaryBand.findByDemandOutlook", query = "SELECT s FROM SalaryBand s WHERE s.demandOutlook = :demandOutlook")
@NamedQuery(name = "SalaryBand.findBySupplyOutlook", query = "SELECT s FROM SalaryBand s WHERE s.supplyOutlook = :supplyOutlook")
@NamedQuery(name = "SalaryBand.findByInhouseOutlook", query = "SELECT s FROM SalaryBand s WHERE s.inhouseOutlook = :inhouseOutlook")
@NamedQuery(name = "SalaryBand.findByInhouseOutlookMonth", query = "SELECT s FROM SalaryBand s WHERE s.inhouseOutlookMonth = :inhouseOutlookMonth")
@NamedQuery(name = "SalaryBand.findBySpecialistScale", query = "SELECT s FROM SalaryBand s WHERE s.specialistScale = :specialistScale")
@NamedQuery(name = "SalaryBand.findByAcceptanceScale", query = "SELECT s FROM SalaryBand s WHERE s.acceptanceScale = :acceptanceScale")
@NamedQuery(name = "SalaryBand.findByExcepAcceptanceScale", query = "SELECT s FROM SalaryBand s WHERE s.excepAcceptanceScale = :excepAcceptanceScale")
@NamedQuery(name = "SalaryBand.findByRemarks", query = "SELECT s FROM SalaryBand s WHERE s.remarks = :remarks")
public class SalaryBand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BAND_ID")
    private BigDecimal bandId;
    @Column(name = "MINIMUM_SALARY")
    private BigInteger minimumSalary;
    @Column(name = "MAXIMUM_SALARY")
    private BigInteger maximumSalary;
    @Column(name = "MARKET_SALARY")
    private BigInteger marketSalary;
    @Column(name = "JOINING_BONUS")
    private BigInteger joiningBonus;
    @Column(name = "JOINING_BONUS_EFF_DT")
    @Temporal(TemporalType.DATE)
    private Date joiningBonusEffDt;
    @Column(name = "DEMAND_OUTLOOK")
    private BigInteger demandOutlook;
    @Column(name = "SUPPLY_OUTLOOK")
    private BigInteger supplyOutlook;
    @Column(name = "INHOUSE_OUTLOOK")
    private BigInteger inhouseOutlook;
    @Column(name = "INHOUSE_OUTLOOK_MONTH")
    private BigInteger inhouseOutlookMonth;
    @Column(name = "SPECIALIST_SCALE")
    private BigInteger specialistScale;
    @Column(name = "ACCEPTANCE_SCALE")
    private BigInteger acceptanceScale;
    @Column(name = "EXCEP_ACCEPTANCE_SCALE")
    private BigInteger excepAcceptanceScale;
    @Column(name = "REMARKS")
    private Character remarks;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bandId")
    private Collection<EmployeePromotion> employeePromotionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bandId")
    private Collection<EmployeeMsi> employeeMsiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bandId")
    private Collection<EmployeeBonus> employeeBonusCollection;
    @OneToMany(mappedBy = "bandId")
    private Collection<EmployeeDetail> employeedetailCollection;
    @JoinColumn(name = "EXCEP_ACCEPTANCE_MGR_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee excepAcceptanceMgrId;
    @JoinColumn(name = "SKILLID", referencedColumnName = "SKILLID")
    @ManyToOne
    private Skillset skillid;

    public SalaryBand() {
    }

    public SalaryBand(BigDecimal bandId) {
        this.bandId = bandId;
    }

    public BigDecimal getBandId() {
        return bandId;
    }

    public void setBandId(BigDecimal bandId) {
        this.bandId = bandId;
    }

    public BigInteger getMinimumSalary() {
        return minimumSalary;
    }

    public void setMinimumSalary(BigInteger minimumSalary) {
        this.minimumSalary = minimumSalary;
    }

    public BigInteger getMaximumSalary() {
        return maximumSalary;
    }

    public void setMaximumSalary(BigInteger maximumSalary) {
        this.maximumSalary = maximumSalary;
    }

    public BigInteger getMarketSalary() {
        return marketSalary;
    }

    public void setMarketSalary(BigInteger marketSalary) {
        this.marketSalary = marketSalary;
    }

    public BigInteger getJoiningBonus() {
        return joiningBonus;
    }

    public void setJoiningBonus(BigInteger joiningBonus) {
        this.joiningBonus = joiningBonus;
    }

    public Date getJoiningBonusEffDt() {
        return joiningBonusEffDt;
    }

    public void setJoiningBonusEffDt(Date joiningBonusEffDt) {
        this.joiningBonusEffDt = joiningBonusEffDt;
    }

    public BigInteger getDemandOutlook() {
        return demandOutlook;
    }

    public void setDemandOutlook(BigInteger demandOutlook) {
        this.demandOutlook = demandOutlook;
    }

    public BigInteger getSupplyOutlook() {
        return supplyOutlook;
    }

    public void setSupplyOutlook(BigInteger supplyOutlook) {
        this.supplyOutlook = supplyOutlook;
    }

    public BigInteger getInhouseOutlook() {
        return inhouseOutlook;
    }

    public void setInhouseOutlook(BigInteger inhouseOutlook) {
        this.inhouseOutlook = inhouseOutlook;
    }

    public BigInteger getInhouseOutlookMonth() {
        return inhouseOutlookMonth;
    }

    public void setInhouseOutlookMonth(BigInteger inhouseOutlookMonth) {
        this.inhouseOutlookMonth = inhouseOutlookMonth;
    }

    public BigInteger getSpecialistScale() {
        return specialistScale;
    }

    public void setSpecialistScale(BigInteger specialistScale) {
        this.specialistScale = specialistScale;
    }

    public BigInteger getAcceptanceScale() {
        return acceptanceScale;
    }

    public void setAcceptanceScale(BigInteger acceptanceScale) {
        this.acceptanceScale = acceptanceScale;
    }

    public BigInteger getExcepAcceptanceScale() {
        return excepAcceptanceScale;
    }

    public void setExcepAcceptanceScale(BigInteger excepAcceptanceScale) {
        this.excepAcceptanceScale = excepAcceptanceScale;
    }

    public Character getRemarks() {
        return remarks;
    }

    public void setRemarks(Character remarks) {
        this.remarks = remarks;
    }

    public Collection<EmployeePromotion> getEmployeePromotionCollection() {
        return employeePromotionCollection;
    }

    public void setEmployeePromotionCollection(Collection<EmployeePromotion> employeePromotionCollection) {
        this.employeePromotionCollection = employeePromotionCollection;
    }

    public Collection<EmployeeMsi> getEmployeeMsiCollection() {
        return employeeMsiCollection;
    }

    public void setEmployeeMsiCollection(Collection<EmployeeMsi> employeeMsiCollection) {
        this.employeeMsiCollection = employeeMsiCollection;
    }

    public Collection<EmployeeBonus> getEmployeeBonusCollection() {
        return employeeBonusCollection;
    }

    public void setEmployeeBonusCollection(Collection<EmployeeBonus> employeeBonusCollection) {
        this.employeeBonusCollection = employeeBonusCollection;
    }

    public Collection<EmployeeDetail> getEmployeedetailCollection() {
        return employeedetailCollection;
    }

    public void setEmployeedetailCollection(Collection<EmployeeDetail> employeedetailCollection) {
        this.employeedetailCollection = employeedetailCollection;
    }

    public Employee getExcepAcceptanceMgrId() {
        return excepAcceptanceMgrId;
    }

    public void setExcepAcceptanceMgrId(Employee excepAcceptanceMgrId) {
        this.excepAcceptanceMgrId = excepAcceptanceMgrId;
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
        hash += (bandId != null ? bandId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof SalaryBand) {
      		
      		SalaryBand other = (SalaryBand) object;
              
      		if ((this.bandId != null && other.bandId != null) && (this.bandId.equals(other.bandId))) {
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
        return "SalaryBand[ bandId=" + bandId + " ]";
    }
    
}
