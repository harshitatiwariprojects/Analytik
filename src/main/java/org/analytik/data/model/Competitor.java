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
@Table(name = "COMPETITOR")
@NamedQuery(name = "Competitor.findAll", query = "SELECT c FROM Competitor c")
@NamedQuery(name = "Competitor.findByCompetitorId", query = "SELECT c FROM Competitor c WHERE c.competitorId = :competitorId")
@NamedQuery(name = "Competitor.findByOpsCompetitorId", query = "SELECT c FROM Competitor c WHERE c.opsCompetitorId = :opsCompetitorId")
@NamedQuery(name = "Competitor.findByOpsType", query = "SELECT c FROM Competitor c WHERE c.opsType = :opsType")
@NamedQuery(name = "Competitor.findByCompetitorName", query = "SELECT c FROM Competitor c WHERE c.competitorName = :competitorName")
@NamedQuery(name = "Competitor.findByCompetitorMarketCap", query = "SELECT c FROM Competitor c WHERE c.competitorMarketCap = :competitorMarketCap")
@NamedQuery(name = "Competitor.findByEstdDate", query = "SELECT c FROM Competitor c WHERE c.estdDate = :estdDate")
public class Competitor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COMPETITOR_ID")
    private BigDecimal competitorId;
    @Column(name = "OPS_COMPETITOR_ID")
    private BigInteger opsCompetitorId;
    @Column(name = "OPS_TYPE")
    private String opsType;
    @Column(name = "COMPETITOR_NAME")
    private String competitorName;
    @Column(name = "COMPETITOR_MARKET_CAP")
    private BigInteger competitorMarketCap;
    @Column(name = "ESTD_DATE")
    @Temporal(TemporalType.DATE)
    private Date estdDate;

    public Competitor() {
    }

    public Competitor(BigDecimal competitorId) {
        this.competitorId = competitorId;
    }

    public BigDecimal getCompetitorId() {
        return competitorId;
    }

    public void setCompetitorId(BigDecimal competitorId) {
        this.competitorId = competitorId;
    }

    public BigInteger getOpsCompetitorId() {
        return opsCompetitorId;
    }

    public void setOpsCompetitorId(BigInteger opsCompetitorId) {
        this.opsCompetitorId = opsCompetitorId;
    }

    public String getOpsType() {
        return opsType;
    }

    public void setOpsType(String opsType) {
        this.opsType = opsType;
    }

    public String getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(String competitorName) {
        this.competitorName = competitorName;
    }

    public BigInteger getCompetitorMarketCap() {
        return competitorMarketCap;
    }

    public void setCompetitorMarketCap(BigInteger competitorMarketCap) {
        this.competitorMarketCap = competitorMarketCap;
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
        hash += (competitorId != null ? competitorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
    	boolean isEqual = false;
    	
    	if(object instanceof Competitor) {
    		
    		Competitor other = (Competitor) object;
            
    		if ((this.competitorId != null && other.competitorId != null) && (this.competitorId.equals(other.competitorId))) {
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
        return "Competitor[ competitorId=" + competitorId + " ]";
    }
    
}
