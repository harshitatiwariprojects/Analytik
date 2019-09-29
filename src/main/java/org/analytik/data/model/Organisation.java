package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ORGANISATION")
@NamedQuery(name = "Organisation.findAll", query = "SELECT o FROM Organisation o")
@NamedQuery(name = "Organisation.findByOrgId", query = "SELECT o FROM Organisation o WHERE o.orgId = :orgId")
@NamedQuery(name = "Organisation.findByOrgName", query = "SELECT o FROM Organisation o WHERE o.orgName = :orgName")
public class Organisation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORG_ID")
    private BigDecimal orgId;
    @Column(name = "ORG_NAME")
    private String orgName;
    @OneToMany(mappedBy = "programOrganisationId")
    private Collection<Program> programCollection;
    @JoinColumn(name = "ADDRESS_3", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private OfficeAddress address3;
    @JoinColumn(name = "ADDRESS_1", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private OfficeAddress address1;
    @JoinColumn(name = "ADDRESS_2", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private OfficeAddress address2;
    @OneToMany(mappedBy = "practiceOrgId")
    private Collection<Practice> practiceCollection;

    public Organisation() {
    }

    public Organisation(BigDecimal orgId) {
        this.orgId = orgId;
    }

    public BigDecimal getOrgId() {
        return orgId;
    }

    public void setOrgId(BigDecimal orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Collection<Program> getProgramCollection() {
        return programCollection;
    }

    public void setProgramCollection(Collection<Program> programCollection) {
        this.programCollection = programCollection;
    }

    public OfficeAddress getAddress3() {
        return address3;
    }

    public void setAddress3(OfficeAddress address3) {
        this.address3 = address3;
    }

    public OfficeAddress getAddress1() {
        return address1;
    }

    public void setAddress1(OfficeAddress address1) {
        this.address1 = address1;
    }

    public OfficeAddress getAddress2() {
        return address2;
    }

    public void setAddress2(OfficeAddress address2) {
        this.address2 = address2;
    }

    public Collection<Practice> getPracticeCollection() {
        return practiceCollection;
    }

    public void setPracticeCollection(Collection<Practice> practiceCollection) {
        this.practiceCollection = practiceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orgId != null ? orgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
    	boolean isEqual = false;
      	
      	if(object instanceof Organisation) {
      		
      		Organisation other = (Organisation) object;
              
      		if ((this.orgId != null && other.orgId != null) && (this.orgId.equals(other.orgId))) {
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
        return "Organisation[ orgId=" + orgId + " ]";
    }
    
}
