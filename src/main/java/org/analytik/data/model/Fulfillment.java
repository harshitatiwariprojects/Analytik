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
@Table(name = "FULFILLMENT")
@NamedQuery(name = "Fulfillment.findAll", query = "SELECT f FROM Fulfillment f")
@NamedQuery(name = "Fulfillment.findByFulfillmentId", query = "SELECT f FROM Fulfillment f WHERE f.fulfillmentId = :fulfillmentId")
public class Fulfillment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FULFILLMENT_ID")
    private BigDecimal fulfillmentId;
    @JoinColumn(name = "SETTLEMENT_ID", referencedColumnName = "SETTLEMENT_ID")
    @ManyToOne
    private Settlement settlementId;
    @JoinColumn(name = "SUPPLY_ID", referencedColumnName = "SUPPLY_ID")
    @ManyToOne
    private Supply supplyId;
    @JoinColumn(name = "TAX_ID", referencedColumnName = "TAX_ID")
    @ManyToOne
    private TaxStatement taxId;

    public Fulfillment() {
    }

    public Fulfillment(BigDecimal fulfillmentId) {
        this.fulfillmentId = fulfillmentId;
    }

    public BigDecimal getFulfillmentId() {
        return fulfillmentId;
    }

    public void setFulfillmentId(BigDecimal fulfillmentId) {
        this.fulfillmentId = fulfillmentId;
    }

    public Settlement getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(Settlement settlementId) {
        this.settlementId = settlementId;
    }

    public Supply getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Supply supplyId) {
        this.supplyId = supplyId;
    }

    public TaxStatement getTaxId() {
        return taxId;
    }

    public void setTaxId(TaxStatement taxId) {
        this.taxId = taxId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fulfillmentId != null ? fulfillmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
     	boolean isEqual = false;
      	
      	if(object instanceof Fulfillment) {
      		
      		Fulfillment other = (Fulfillment) object;
              
      		if ((this.fulfillmentId != null && other.fulfillmentId != null) && (this.fulfillmentId.equals(other.fulfillmentId))) {
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
        return "Fulfillment[ fulfillmentId=" + fulfillmentId + " ]";
    }
    
}
