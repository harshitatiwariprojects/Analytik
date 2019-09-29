package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "EMPLOYEE")
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
@NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId")
@NamedQuery(name = "Employee.findByFirstname", query = "SELECT e FROM Employee e WHERE e.firstname = :firstname")
@NamedQuery(name = "Employee.findByLastname", query = "SELECT e FROM Employee e WHERE e.lastname = :lastname")
@NamedQuery(name = "Employee.findByMiddlename", query = "SELECT e FROM Employee e WHERE e.middlename = :middlename")
@NamedQuery(name = "Employee.findByDeptId", query = "SELECT e FROM Employee e WHERE e.deptId = :deptId")
@NamedQuery(name = "Employee.findByEmptype", query = "SELECT e FROM Employee e WHERE e.emptype = :emptype")
@NamedQuery(name = "Employee.findByCostCenterCode", query = "SELECT e FROM Employee e WHERE e.costCenterCode = :costCenterCode")
@NamedQuery(name = "Employee.findByRevenueCenterCode", query = "SELECT e FROM Employee e WHERE e.revenueCenterCode = :revenueCenterCode")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEE_ID")
    private BigDecimal employeeId;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "MIDDLENAME")
    private String middlename;
    @Column(name = "DEPT_ID")
    private BigInteger deptId;
    @Column(name = "EMPTYPE")
    private String emptype;
    @Column(name = "COST_CENTER_CODE")
    private BigInteger costCenterCode;
    @Column(name = "REVENUE_CENTER_CODE")
    private BigInteger revenueCenterCode;
    @OneToMany(mappedBy = "orgLocationHead")
    private Collection<Hr> hrCollection;
    @OneToMany(mappedBy = "orgHead")
    private Collection<Hr> hrCollection1;
    @OneToMany(mappedBy = "opsHead")
    private Collection<OuOps> ouOpsCollection;
    @OneToMany(mappedBy = "opsManager")
    private Collection<OuOps> ouOpsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketEscalationOwner")
    private Collection<HelpdeskTicket> helpdeskTicketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketOwner")
    private Collection<HelpdeskTicket> helpdeskTicketCollection1;
    @OneToMany(mappedBy = "processContact")
    private Collection<Process> processCollection;
    @OneToMany(mappedBy = "processOwner")
    private Collection<Process> processCollection1;
    @OneToMany(mappedBy = "employeeId")
    private Collection<Deboarding> deboardingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeeProjectMapping> employeeProjectMappingCollection;
    @OneToMany(mappedBy = "employeeId")
    private Collection<Onboarding> onboardingCollection;
    @OneToMany(mappedBy = "employeeId")
    private Collection<EmployeeProfile> employeeprofileCollection;
    @OneToMany(mappedBy = "programLeader")
    private Collection<Program> programCollection;
    @OneToMany(mappedBy = "programManager")
    private Collection<Program> programCollection1;
    @OneToMany(mappedBy = "employeeId")
    private Collection<Supplier> supplierCollection;
    @OneToMany(mappedBy = "businessOpsHead")
    private Collection<OuBusinessOps> ouBusinessOpsCollection;
    @OneToMany(mappedBy = "businessOpsManager")
    private Collection<OuBusinessOps> ouBusinessOpsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<ProjectBillingEmployee> projectBillingEmployeeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerBillingCode")
    private Collection<Billing> billingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeePromotion> employeePromotionCollection;
    @OneToMany(mappedBy = "excepAcceptMgr")
    private Collection<EmployeePromotion> employeePromotionCollection1;
    @OneToMany(mappedBy = "confirmMgrId")
    private Collection<EmployeePromotion> employeePromotionCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeeMsi> employeeMsiCollection;
    @OneToMany(mappedBy = "excepAcceptMgr")
    private Collection<EmployeeMsi> employeeMsiCollection1;
    @OneToMany(mappedBy = "confirmMgrId")
    private Collection<EmployeeMsi> employeeMsiCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<Salary> salaryCollection;
    @OneToMany(mappedBy = "buContactId")
    private Collection<Orders> ordersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "confirmMgrId")
    private Collection<EmployeeBonus> employeeBonusCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeeBonus> employeeBonusCollection1;
    @OneToMany(mappedBy = "excepAcceptMgr")
    private Collection<EmployeeBonus> employeeBonusCollection2;
    @OneToMany(mappedBy = "employeeId")
    private Collection<Recruitment> recruitmentCollection;
    @OneToMany(mappedBy = "buContactId")
    private Collection<Demand> demandCollection;
    @OneToMany(mappedBy = "customerManager")
    private Collection<CustomerProject> customerProjectCollection;
    @OneToMany(mappedBy = "employeeId")
    private Collection<EmployeeDetail> employeedetailCollection;
    @OneToMany(mappedBy = "excepAcceptanceMgrId")
    private Collection<SalaryBand> salaryBandCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endUser")
    private Collection<StepActivityDetails> stepActivityDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activityOwner")
    private Collection<StepActivityDetails> stepActivityDetailsCollection1;
    @OneToMany(mappedBy = "supervisorId")
    private Collection<Resources> resourcesCollection;
    @OneToMany(mappedBy = "managerId")
    private Collection<Management> managementCollection;
    @OneToMany(mappedBy = "reportsTo")
    private Collection<Practice> practiceCollection;
    @OneToMany(mappedBy = "empId")
    private Collection<Attendance> attendanceCollection;
    @OneToMany(mappedBy = "employeeId")
    private Collection<ProjectEmployeeMapping> projectEmployeeMappingCollection;

    public Employee() {
    }

    public Employee(BigDecimal employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(BigDecimal employeeId) {
        this.employeeId = employeeId;
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

    public BigInteger getDeptId() {
        return deptId;
    }

    public void setDeptId(BigInteger deptId) {
        this.deptId = deptId;
    }

    public String getEmptype() {
        return emptype;
    }

    public void setEmptype(String emptype) {
        this.emptype = emptype;
    }

    public BigInteger getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(BigInteger costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public BigInteger getRevenueCenterCode() {
        return revenueCenterCode;
    }

    public void setRevenueCenterCode(BigInteger revenueCenterCode) {
        this.revenueCenterCode = revenueCenterCode;
    }

    public Collection<Hr> getHrCollection() {
        return hrCollection;
    }

    public void setHrCollection(Collection<Hr> hrCollection) {
        this.hrCollection = hrCollection;
    }

    public Collection<Hr> getHrCollection1() {
        return hrCollection1;
    }

    public void setHrCollection1(Collection<Hr> hrCollection1) {
        this.hrCollection1 = hrCollection1;
    }

    public Collection<OuOps> getOuOpsCollection() {
        return ouOpsCollection;
    }

    public void setOuOpsCollection(Collection<OuOps> ouOpsCollection) {
        this.ouOpsCollection = ouOpsCollection;
    }

    public Collection<OuOps> getOuOpsCollection1() {
        return ouOpsCollection1;
    }

    public void setOuOpsCollection1(Collection<OuOps> ouOpsCollection1) {
        this.ouOpsCollection1 = ouOpsCollection1;
    }

    public Collection<HelpdeskTicket> getHelpdeskTicketCollection() {
        return helpdeskTicketCollection;
    }

    public void setHelpdeskTicketCollection(Collection<HelpdeskTicket> helpdeskTicketCollection) {
        this.helpdeskTicketCollection = helpdeskTicketCollection;
    }

    public Collection<HelpdeskTicket> getHelpdeskTicketCollection1() {
        return helpdeskTicketCollection1;
    }

    public void setHelpdeskTicketCollection1(Collection<HelpdeskTicket> helpdeskTicketCollection1) {
        this.helpdeskTicketCollection1 = helpdeskTicketCollection1;
    }

    public Collection<Process> getProcessCollection() {
        return processCollection;
    }

    public void setProcessCollection(Collection<Process> processCollection) {
        this.processCollection = processCollection;
    }

    public Collection<Process> getProcessCollection1() {
        return processCollection1;
    }

    public void setProcessCollection1(Collection<Process> processCollection1) {
        this.processCollection1 = processCollection1;
    }

    public Collection<Deboarding> getDeboardingCollection() {
        return deboardingCollection;
    }

    public void setDeboardingCollection(Collection<Deboarding> deboardingCollection) {
        this.deboardingCollection = deboardingCollection;
    }

    public Collection<EmployeeProjectMapping> getEmployeeProjectMappingCollection() {
        return employeeProjectMappingCollection;
    }

    public void setEmployeeProjectMappingCollection(Collection<EmployeeProjectMapping> employeeProjectMappingCollection) {
        this.employeeProjectMappingCollection = employeeProjectMappingCollection;
    }

    public Collection<Onboarding> getOnboardingCollection() {
        return onboardingCollection;
    }

    public void setOnboardingCollection(Collection<Onboarding> onboardingCollection) {
        this.onboardingCollection = onboardingCollection;
    }

    public Collection<EmployeeProfile> getEmployeeprofileCollection() {
        return employeeprofileCollection;
    }

    public void setEmployeeprofileCollection(Collection<EmployeeProfile> employeeprofileCollection) {
        this.employeeprofileCollection = employeeprofileCollection;
    }

    public Collection<Program> getProgramCollection() {
        return programCollection;
    }

    public void setProgramCollection(Collection<Program> programCollection) {
        this.programCollection = programCollection;
    }

    public Collection<Program> getProgramCollection1() {
        return programCollection1;
    }

    public void setProgramCollection1(Collection<Program> programCollection1) {
        this.programCollection1 = programCollection1;
    }

    public Collection<Supplier> getSupplierCollection() {
        return supplierCollection;
    }

    public void setSupplierCollection(Collection<Supplier> supplierCollection) {
        this.supplierCollection = supplierCollection;
    }

    public Collection<OuBusinessOps> getOuBusinessOpsCollection() {
        return ouBusinessOpsCollection;
    }

    public void setOuBusinessOpsCollection(Collection<OuBusinessOps> ouBusinessOpsCollection) {
        this.ouBusinessOpsCollection = ouBusinessOpsCollection;
    }

    public Collection<OuBusinessOps> getOuBusinessOpsCollection1() {
        return ouBusinessOpsCollection1;
    }

    public void setOuBusinessOpsCollection1(Collection<OuBusinessOps> ouBusinessOpsCollection1) {
        this.ouBusinessOpsCollection1 = ouBusinessOpsCollection1;
    }

    public Collection<ProjectBillingEmployee> getProjectBillingEmployeeCollection() {
        return projectBillingEmployeeCollection;
    }

    public void setProjectBillingEmployeeCollection(Collection<ProjectBillingEmployee> projectBillingEmployeeCollection) {
        this.projectBillingEmployeeCollection = projectBillingEmployeeCollection;
    }

    public Collection<Billing> getBillingCollection() {
        return billingCollection;
    }

    public void setBillingCollection(Collection<Billing> billingCollection) {
        this.billingCollection = billingCollection;
    }

    public Collection<EmployeePromotion> getEmployeePromotionCollection() {
        return employeePromotionCollection;
    }

    public void setEmployeePromotionCollection(Collection<EmployeePromotion> employeePromotionCollection) {
        this.employeePromotionCollection = employeePromotionCollection;
    }

    public Collection<EmployeePromotion> getEmployeePromotionCollection1() {
        return employeePromotionCollection1;
    }

    public void setEmployeePromotionCollection1(Collection<EmployeePromotion> employeePromotionCollection1) {
        this.employeePromotionCollection1 = employeePromotionCollection1;
    }

    public Collection<EmployeePromotion> getEmployeePromotionCollection2() {
        return employeePromotionCollection2;
    }

    public void setEmployeePromotionCollection2(Collection<EmployeePromotion> employeePromotionCollection2) {
        this.employeePromotionCollection2 = employeePromotionCollection2;
    }

    public Collection<EmployeeMsi> getEmployeeMsiCollection() {
        return employeeMsiCollection;
    }

    public void setEmployeeMsiCollection(Collection<EmployeeMsi> employeeMsiCollection) {
        this.employeeMsiCollection = employeeMsiCollection;
    }

    public Collection<EmployeeMsi> getEmployeeMsiCollection1() {
        return employeeMsiCollection1;
    }

    public void setEmployeeMsiCollection1(Collection<EmployeeMsi> employeeMsiCollection1) {
        this.employeeMsiCollection1 = employeeMsiCollection1;
    }

    public Collection<EmployeeMsi> getEmployeeMsiCollection2() {
        return employeeMsiCollection2;
    }

    public void setEmployeeMsiCollection2(Collection<EmployeeMsi> employeeMsiCollection2) {
        this.employeeMsiCollection2 = employeeMsiCollection2;
    }

    public Collection<Salary> getSalaryCollection() {
        return salaryCollection;
    }

    public void setSalaryCollection(Collection<Salary> salaryCollection) {
        this.salaryCollection = salaryCollection;
    }

    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Collection<EmployeeBonus> getEmployeeBonusCollection() {
        return employeeBonusCollection;
    }

    public void setEmployeeBonusCollection(Collection<EmployeeBonus> employeeBonusCollection) {
        this.employeeBonusCollection = employeeBonusCollection;
    }

    public Collection<EmployeeBonus> getEmployeeBonusCollection1() {
        return employeeBonusCollection1;
    }

    public void setEmployeeBonusCollection1(Collection<EmployeeBonus> employeeBonusCollection1) {
        this.employeeBonusCollection1 = employeeBonusCollection1;
    }

    public Collection<EmployeeBonus> getEmployeeBonusCollection2() {
        return employeeBonusCollection2;
    }

    public void setEmployeeBonusCollection2(Collection<EmployeeBonus> employeeBonusCollection2) {
        this.employeeBonusCollection2 = employeeBonusCollection2;
    }

    public Collection<Recruitment> getRecruitmentCollection() {
        return recruitmentCollection;
    }

    public void setRecruitmentCollection(Collection<Recruitment> recruitmentCollection) {
        this.recruitmentCollection = recruitmentCollection;
    }

    public Collection<Demand> getDemandCollection() {
        return demandCollection;
    }

    public void setDemandCollection(Collection<Demand> demandCollection) {
        this.demandCollection = demandCollection;
    }

    public Collection<CustomerProject> getCustomerProjectCollection() {
        return customerProjectCollection;
    }

    public void setCustomerProjectCollection(Collection<CustomerProject> customerProjectCollection) {
        this.customerProjectCollection = customerProjectCollection;
    }

    public Collection<EmployeeDetail> getEmployeedetailCollection() {
        return employeedetailCollection;
    }

    public void setEmployeedetailCollection(Collection<EmployeeDetail> employeedetailCollection) {
        this.employeedetailCollection = employeedetailCollection;
    }

    public Collection<SalaryBand> getSalaryBandCollection() {
        return salaryBandCollection;
    }

    public void setSalaryBandCollection(Collection<SalaryBand> salaryBandCollection) {
        this.salaryBandCollection = salaryBandCollection;
    }

    public Collection<StepActivityDetails> getStepActivityDetailsCollection() {
        return stepActivityDetailsCollection;
    }

    public void setStepActivityDetailsCollection(Collection<StepActivityDetails> stepActivityDetailsCollection) {
        this.stepActivityDetailsCollection = stepActivityDetailsCollection;
    }

    public Collection<StepActivityDetails> getStepActivityDetailsCollection1() {
        return stepActivityDetailsCollection1;
    }

    public void setStepActivityDetailsCollection1(Collection<StepActivityDetails> stepActivityDetailsCollection1) {
        this.stepActivityDetailsCollection1 = stepActivityDetailsCollection1;
    }

    public Collection<Resources> getResourcesCollection() {
        return resourcesCollection;
    }

    public void setResourcesCollection(Collection<Resources> resourcesCollection) {
        this.resourcesCollection = resourcesCollection;
    }

    public Collection<Management> getManagementCollection() {
        return managementCollection;
    }

    public void setManagementCollection(Collection<Management> managementCollection) {
        this.managementCollection = managementCollection;
    }

    public Collection<Practice> getPracticeCollection() {
        return practiceCollection;
    }

    public void setPracticeCollection(Collection<Practice> practiceCollection) {
        this.practiceCollection = practiceCollection;
    }

    public Collection<Attendance> getAttendanceCollection() {
        return attendanceCollection;
    }

    public void setAttendanceCollection(Collection<Attendance> attendanceCollection) {
        this.attendanceCollection = attendanceCollection;
    }

    public Collection<ProjectEmployeeMapping> getProjectEmployeeMappingCollection() {
        return projectEmployeeMappingCollection;
    }

    public void setProjectEmployeeMappingCollection(Collection<ProjectEmployeeMapping> projectEmployeeMappingCollection) {
        this.projectEmployeeMappingCollection = projectEmployeeMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
     	boolean isEqual = false;
      	
      	if(object instanceof Employee) {
      		
      		Employee other = (Employee) object;
              
      		if ((this.employeeId != null && other.employeeId != null) && (this.employeeId.equals(other.employeeId))) {
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
        return "Employee[ employeeId=" + employeeId + " ]";
    }
    
}
