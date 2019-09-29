package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "TAX_STATEMENT")
@NamedQuery(name = "TaxStatement.findAll", query = "SELECT t FROM TaxStatement t")
@NamedQuery(name = "TaxStatement.findByTaxId", query = "SELECT t FROM TaxStatement t WHERE t.taxId = :taxId")
@NamedQuery(name = "TaxStatement.findByBasicSalary", query = "SELECT t FROM TaxStatement t WHERE t.basicSalary = :basicSalary")
@NamedQuery(name = "TaxStatement.findByEmployeeBenefit", query = "SELECT t FROM TaxStatement t WHERE t.employeeBenefit = :employeeBenefit")
@NamedQuery(name = "TaxStatement.findByTaxableAllowance", query = "SELECT t FROM TaxStatement t WHERE t.taxableAllowance = :taxableAllowance")
@NamedQuery(name = "TaxStatement.findByFoodcoupons", query = "SELECT t FROM TaxStatement t WHERE t.foodcoupons = :foodcoupons")
@NamedQuery(name = "TaxStatement.findByTravelallowance", query = "SELECT t FROM TaxStatement t WHERE t.travelallowance = :travelallowance")
@NamedQuery(name = "TaxStatement.findByLta", query = "SELECT t FROM TaxStatement t WHERE t.lta = :lta")
@NamedQuery(name = "TaxStatement.findByPf", query = "SELECT t FROM TaxStatement t WHERE t.pf = :pf")
@NamedQuery(name = "TaxStatement.findByVpf", query = "SELECT t FROM TaxStatement t WHERE t.vpf = :vpf")
@NamedQuery(name = "TaxStatement.findByNpsCompany", query = "SELECT t FROM TaxStatement t WHERE t.npsCompany = :npsCompany")
@NamedQuery(name = "TaxStatement.findByNpsEmployee", query = "SELECT t FROM TaxStatement t WHERE t.npsEmployee = :npsEmployee")
@NamedQuery(name = "TaxStatement.findByHra", query = "SELECT t FROM TaxStatement t WHERE t.hra = :hra")
@NamedQuery(name = "TaxStatement.findByHomeloanprincipal", query = "SELECT t FROM TaxStatement t WHERE t.homeloanprincipal = :homeloanprincipal")
@NamedQuery(name = "TaxStatement.findByHomeloanintrest", query = "SELECT t FROM TaxStatement t WHERE t.homeloanintrest = :homeloanintrest")
@NamedQuery(name = "TaxStatement.findByKidsEducation", query = "SELECT t FROM TaxStatement t WHERE t.kidsEducation = :kidsEducation")
@NamedQuery(name = "TaxStatement.findByEducationLoan", query = "SELECT t FROM TaxStatement t WHERE t.educationLoan = :educationLoan")
@NamedQuery(name = "TaxStatement.findByTax", query = "SELECT t FROM TaxStatement t WHERE t.tax = :tax")
public class TaxStatement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TAX_ID")
    private BigDecimal taxId;
    @Column(name = "BASIC_SALARY")
    private BigInteger basicSalary;
    @Column(name = "EMPLOYEE_BENEFIT")
    private BigInteger employeeBenefit;
    @Column(name = "TAXABLE_ALLOWANCE")
    private BigInteger taxableAllowance;
    @Column(name = "FOODCOUPONS")
    private BigInteger foodcoupons;
    @Column(name = "TRAVELALLOWANCE")
    private BigInteger travelallowance;
    @Column(name = "LTA")
    private BigInteger lta;
    @Column(name = "PF")
    private BigInteger pf;
    @Column(name = "VPF")
    private BigInteger vpf;
    @Column(name = "NPS_COMPANY")
    private BigInteger npsCompany;
    @Column(name = "NPS_EMPLOYEE")
    private BigInteger npsEmployee;
    @Column(name = "HRA")
    private BigInteger hra;
    @Column(name = "HOMELOANPRINCIPAL")
    private BigInteger homeloanprincipal;
    @Column(name = "HOMELOANINTREST")
    private BigInteger homeloanintrest;
    @Column(name = "KIDS_EDUCATION")
    private BigInteger kidsEducation;
    @Column(name = "EDUCATION_LOAN")
    private BigInteger educationLoan;
    @Column(name = "TAX")
    private BigInteger tax;
    @Lob
    @Column(name = "EFFECTIVE_YEAR")
    private Object effectiveYear;
    @OneToMany(mappedBy = "taxId")
    private Collection<Fulfillment> fulfillmentCollection;

    public TaxStatement() {
    }

    public TaxStatement(BigDecimal taxId) {
        this.taxId = taxId;
    }

    public BigDecimal getTaxId() {
        return taxId;
    }

    public void setTaxId(BigDecimal taxId) {
        this.taxId = taxId;
    }

    public BigInteger getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(BigInteger basicSalary) {
        this.basicSalary = basicSalary;
    }

    public BigInteger getEmployeeBenefit() {
        return employeeBenefit;
    }

    public void setEmployeeBenefit(BigInteger employeeBenefit) {
        this.employeeBenefit = employeeBenefit;
    }

    public BigInteger getTaxableAllowance() {
        return taxableAllowance;
    }

    public void setTaxableAllowance(BigInteger taxableAllowance) {
        this.taxableAllowance = taxableAllowance;
    }

    public BigInteger getFoodcoupons() {
        return foodcoupons;
    }

    public void setFoodcoupons(BigInteger foodcoupons) {
        this.foodcoupons = foodcoupons;
    }

    public BigInteger getTravelallowance() {
        return travelallowance;
    }

    public void setTravelallowance(BigInteger travelallowance) {
        this.travelallowance = travelallowance;
    }

    public BigInteger getLta() {
        return lta;
    }

    public void setLta(BigInteger lta) {
        this.lta = lta;
    }

    public BigInteger getPf() {
        return pf;
    }

    public void setPf(BigInteger pf) {
        this.pf = pf;
    }

    public BigInteger getVpf() {
        return vpf;
    }

    public void setVpf(BigInteger vpf) {
        this.vpf = vpf;
    }

    public BigInteger getNpsCompany() {
        return npsCompany;
    }

    public void setNpsCompany(BigInteger npsCompany) {
        this.npsCompany = npsCompany;
    }

    public BigInteger getNpsEmployee() {
        return npsEmployee;
    }

    public void setNpsEmployee(BigInteger npsEmployee) {
        this.npsEmployee = npsEmployee;
    }

    public BigInteger getHra() {
        return hra;
    }

    public void setHra(BigInteger hra) {
        this.hra = hra;
    }

    public BigInteger getHomeloanprincipal() {
        return homeloanprincipal;
    }

    public void setHomeloanprincipal(BigInteger homeloanprincipal) {
        this.homeloanprincipal = homeloanprincipal;
    }

    public BigInteger getHomeloanintrest() {
        return homeloanintrest;
    }

    public void setHomeloanintrest(BigInteger homeloanintrest) {
        this.homeloanintrest = homeloanintrest;
    }

    public BigInteger getKidsEducation() {
        return kidsEducation;
    }

    public void setKidsEducation(BigInteger kidsEducation) {
        this.kidsEducation = kidsEducation;
    }

    public BigInteger getEducationLoan() {
        return educationLoan;
    }

    public void setEducationLoan(BigInteger educationLoan) {
        this.educationLoan = educationLoan;
    }

    public BigInteger getTax() {
        return tax;
    }

    public void setTax(BigInteger tax) {
        this.tax = tax;
    }

    public Object getEffectiveYear() {
        return effectiveYear;
    }

    public void setEffectiveYear(Object effectiveYear) {
        this.effectiveYear = effectiveYear;
    }

    public Collection<Fulfillment> getFulfillmentCollection() {
        return fulfillmentCollection;
    }

    public void setFulfillmentCollection(Collection<Fulfillment> fulfillmentCollection) {
        this.fulfillmentCollection = fulfillmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxId != null ? taxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof TaxStatement) {
      		
      		TaxStatement other = (TaxStatement) object;
              
      		if ((this.taxId != null && other.taxId != null) && (this.taxId.equals(other.taxId))) {
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
        return "TaxStatement[ taxId=" + taxId + " ]";
    }
    
}
