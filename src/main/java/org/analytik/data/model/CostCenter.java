package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Defines Model.
 * @author Harshita Tiwari
 * Copyright 2019 by Harshita Tiwari. All rights reserved.
 *
 */

@Entity
@Table(name = "COST_CENTER")
@NamedQuery(name = "CostCenter.findAll", query = "SELECT c FROM CostCenter c")
@NamedQuery(name = "CostCenter.findByCostCenterCode", query = "SELECT c FROM CostCenter c WHERE c.costCenterCode = :costCenterCode")
public class CostCenter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COST_CENTER_CODE")
    private BigDecimal costCenterCode;

    public CostCenter() {
    }

    public CostCenter(BigDecimal costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public BigDecimal getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(BigDecimal costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (costCenterCode != null ? costCenterCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
    	boolean isEqual = false;
    	
    	if(object instanceof CostCenter) {
    		
    		CostCenter other = (CostCenter) object;
            
    		if ((this.costCenterCode != null && other.costCenterCode != null) && (this.costCenterCode.equals(other.costCenterCode))) {
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
        return "CostCenter[ costCenterCode=" + costCenterCode + " ]";
    }
    
}
