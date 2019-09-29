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
@Table(name = "ALLIANCES")
@NamedQuery(name = "Alliances.findAll", query = "SELECT a FROM Alliances a")
@NamedQuery(name = "Alliances.findByAllianceId", query = "SELECT a FROM Alliances a WHERE a.allianceId = :allianceId")
@NamedQuery(name = "Alliances.findByOpsAllianceId", query = "SELECT a FROM Alliances a WHERE a.opsAllianceId = :opsAllianceId")
@NamedQuery(name = "Alliances.findByOpsType", query = "SELECT a FROM Alliances a WHERE a.opsType = :opsType")
@NamedQuery(name = "Alliances.findByAllianceName", query = "SELECT a FROM Alliances a WHERE a.allianceName = :allianceName")
@NamedQuery(name = "Alliances.findByAllianceMarketCap", query = "SELECT a FROM Alliances a WHERE a.allianceMarketCap = :allianceMarketCap")
@NamedQuery(name = "Alliances.findByEstdDate", query = "SELECT a FROM Alliances a WHERE a.estdDate = :estdDate")
public class Alliances implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ALLIANCE_ID")
    private BigDecimal allianceId;
    @Column(name = "OPS_ALLIANCE_ID")
    private BigInteger opsAllianceId;
    @Column(name = "OPS_TYPE")
    private String opsType;
    @Column(name = "ALLIANCE_NAME")
    private String allianceName;
    @Column(name = "ALLIANCE_MARKET_CAP")
    private BigInteger allianceMarketCap;
    @Column(name = "ESTD_DATE")
    @Temporal(TemporalType.DATE)
    private Date estdDate;

    public Alliances() {
    }

    public Alliances(BigDecimal allianceId) {
        this.allianceId = allianceId;
    }

    public BigDecimal getAllianceId() {
        return allianceId;
    }

    public void setAllianceId(BigDecimal allianceId) {
        this.allianceId = allianceId;
    }

    public BigInteger getOpsAllianceId() {
        return opsAllianceId;
    }

    public void setOpsAllianceId(BigInteger opsAllianceId) {
        this.opsAllianceId = opsAllianceId;
    }

    public String getOpsType() {
        return opsType;
    }

    public void setOpsType(String opsType) {
        this.opsType = opsType;
    }

    public String getAllianceName() {
        return allianceName;
    }

    public void setAllianceName(String allianceName) {
        this.allianceName = allianceName;
    }

    public BigInteger getAllianceMarketCap() {
        return allianceMarketCap;
    }

    public void setAllianceMarketCap(BigInteger allianceMarketCap) {
        this.allianceMarketCap = allianceMarketCap;
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
        hash += (allianceId != null ? allianceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
    	boolean isEqual = false;
    	
    	if(object instanceof Alliances) {
    		
    		Alliances other = (Alliances) object;
            
    		if ((this.allianceId != null && other.allianceId != null) && (this.allianceId.equals(other.allianceId))) {
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
        return "Alliances[ allianceId=" + allianceId + " ]";
    }
    
}
