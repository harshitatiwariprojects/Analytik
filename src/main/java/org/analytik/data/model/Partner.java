
package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "PARTNER")
@NamedQuery(name = "Partner.findAll", query = "SELECT p FROM Partner p")
@NamedQuery(name = "Partner.findByPartnerId", query = "SELECT p FROM Partner p WHERE p.partnerId = :partnerId")
@NamedQuery(name = "Partner.findByOpsPartnerId", query = "SELECT p FROM Partner p WHERE p.opsPartnerId = :opsPartnerId")
@NamedQuery(name = "Partner.findByOpsType", query = "SELECT p FROM Partner p WHERE p.opsType = :opsType")
@NamedQuery(name = "Partner.findByPartnerName", query = "SELECT p FROM Partner p WHERE p.partnerName = :partnerName")
@NamedQuery(name = "Partner.findByPartnerMarketCap", query = "SELECT p FROM Partner p WHERE p.partnerMarketCap = :partnerMarketCap")
@NamedQuery(name = "Partner.findByEstdDate", query = "SELECT p FROM Partner p WHERE p.estdDate = :estdDate")
public class Partner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PARTNER_ID")
    private BigDecimal partnerId;
    @Column(name = "OPS_PARTNER_ID")
    private BigInteger opsPartnerId;
    @Column(name = "OPS_TYPE")
    private String opsType;
    @Column(name = "PARTNER_NAME")
    private String partnerName;
    @Column(name = "PARTNER_MARKET_CAP")
    private BigInteger partnerMarketCap;
    @Column(name = "ESTD_DATE")
    @Temporal(TemporalType.DATE)
    private Date estdDate;

    public Partner() {
    }

    public Partner(BigDecimal partnerId) {
        this.partnerId = partnerId;
    }

    public BigDecimal getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(BigDecimal partnerId) {
        this.partnerId = partnerId;
    }

    public BigInteger getOpsPartnerId() {
        return opsPartnerId;
    }

    public void setOpsPartnerId(BigInteger opsPartnerId) {
        this.opsPartnerId = opsPartnerId;
    }

    public String getOpsType() {
        return opsType;
    }

    public void setOpsType(String opsType) {
        this.opsType = opsType;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public BigInteger getPartnerMarketCap() {
        return partnerMarketCap;
    }

    public void setPartnerMarketCap(BigInteger partnerMarketCap) {
        this.partnerMarketCap = partnerMarketCap;
    }

    public Date getEstdDate() {
        return estdDate;
    }

    public void setEstdDate(Date estdDate) {
        this.estdDate = estdDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partnerId != null ? partnerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof Partner) {
      		
      		Partner other = (Partner) object;
              
      		if ((this.partnerId != null && other.partnerId != null) && (this.partnerId.equals(other.partnerId))) {
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
        return "Partner[ partnerId=" + partnerId + " ]";
    }
    
}
