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
@Table(name = "SUPPLIER")
@NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s")
@NamedQuery(name = "Supplier.findBySupplierId", query = "SELECT s FROM Supplier s WHERE s.supplierId = :supplierId")
@NamedQuery(name = "Supplier.findByOpsSupplierId", query = "SELECT s FROM Supplier s WHERE s.opsSupplierId = :opsSupplierId")
@NamedQuery(name = "Supplier.findByOpsType", query = "SELECT s FROM Supplier s WHERE s.opsType = :opsType")
@NamedQuery(name = "Supplier.findBySupplierName", query = "SELECT s FROM Supplier s WHERE s.supplierName = :supplierName")
@NamedQuery(name = "Supplier.findBySupplierMarketCap", query = "SELECT s FROM Supplier s WHERE s.supplierMarketCap = :supplierMarketCap")
@NamedQuery(name = "Supplier.findByEstdDate", query = "SELECT s FROM Supplier s WHERE s.estdDate = :estdDate")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SUPPLIER_ID")
    private BigDecimal supplierId;
    @Column(name = "OPS_SUPPLIER_ID")
    private BigInteger opsSupplierId;
    @Column(name = "OPS_TYPE")
    private String opsType;
    @Column(name = "SUPPLIER_NAME")
    private String supplierName;
    @Column(name = "SUPPLIER_MARKET_CAP")
    private BigInteger supplierMarketCap;
    @Column(name = "ESTD_DATE")
    @Temporal(TemporalType.DATE)
    private Date estdDate;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee employeeId;

    public Supplier() {
    }

    public Supplier(BigDecimal supplierId) {
        this.supplierId = supplierId;
    }

    public BigDecimal getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(BigDecimal supplierId) {
        this.supplierId = supplierId;
    }

    public BigInteger getOpsSupplierId() {
        return opsSupplierId;
    }

    public void setOpsSupplierId(BigInteger opsSupplierId) {
        this.opsSupplierId = opsSupplierId;
    }

    public String getOpsType() {
        return opsType;
    }

    public void setOpsType(String opsType) {
        this.opsType = opsType;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public BigInteger getSupplierMarketCap() {
        return supplierMarketCap;
    }

    public void setSupplierMarketCap(BigInteger supplierMarketCap) {
        this.supplierMarketCap = supplierMarketCap;
    }

    public Date getEstdDate() {
        return estdDate;
    }

    public void setEstdDate(Date estdDate) {
        this.estdDate = estdDate;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierId != null ? supplierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof Supplier) {
      		
      		Supplier other = (Supplier) object;
              
      		if ((this.supplierId != null && other.supplierId != null) && (this.supplierId.equals(other.supplierId))) {
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
        return "Supplier[ supplierId=" + supplierId + " ]";
    }
    
}
