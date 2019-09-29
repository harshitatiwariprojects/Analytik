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
@Table(name = "HELPDESK")
@NamedQuery(name = "Helpdesk.findAll", query = "SELECT h FROM Helpdesk h")
@NamedQuery(name = "Helpdesk.findByHelpdeskId", query = "SELECT h FROM Helpdesk h WHERE h.helpdeskId = :helpdeskId")
@NamedQuery(name = "Helpdesk.findByHelpdeskTollNo", query = "SELECT h FROM Helpdesk h WHERE h.helpdeskTollNo = :helpdeskTollNo")
@NamedQuery(name = "Helpdesk.findByHelpdeskTollfreeNo", query = "SELECT h FROM Helpdesk h WHERE h.helpdeskTollfreeNo = :helpdeskTollfreeNo")
@NamedQuery(name = "Helpdesk.findByHelpdeskExtensionNo", query = "SELECT h FROM Helpdesk h WHERE h.helpdeskExtensionNo = :helpdeskExtensionNo")
@NamedQuery(name = "Helpdesk.findByHelpdeskEmail", query = "SELECT h FROM Helpdesk h WHERE h.helpdeskEmail = :helpdeskEmail")
@NamedQuery(name = "Helpdesk.findByHelpdeskChat", query = "SELECT h FROM Helpdesk h WHERE h.helpdeskChat = :helpdeskChat")
public class Helpdesk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "HELPDESK_ID")
    private BigDecimal helpdeskId;
    @Column(name = "HELPDESK_TOLL_NO")
    private BigInteger helpdeskTollNo;
    @Column(name = "HELPDESK_TOLLFREE_NO")
    private BigInteger helpdeskTollfreeNo;
    @Column(name = "HELPDESK_EXTENSION_NO")
    private BigInteger helpdeskExtensionNo;
    @Column(name = "HELPDESK_EMAIL")
    private String helpdeskEmail;
    @Column(name = "HELPDESK_CHAT")
    private String helpdeskChat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "helpdeskId")
    private Collection<HelpdeskTicket> helpdeskTicketCollection;
    @OneToMany(mappedBy = "processHelpdesk")
    private Collection<Process> processCollection;

    public Helpdesk() {
    }

    public Helpdesk(BigDecimal helpdeskId) {
        this.helpdeskId = helpdeskId;
    }

    public BigDecimal getHelpdeskId() {
        return helpdeskId;
    }

    public void setHelpdeskId(BigDecimal helpdeskId) {
        this.helpdeskId = helpdeskId;
    }

    public BigInteger getHelpdeskTollNo() {
        return helpdeskTollNo;
    }

    public void setHelpdeskTollNo(BigInteger helpdeskTollNo) {
        this.helpdeskTollNo = helpdeskTollNo;
    }

    public BigInteger getHelpdeskTollfreeNo() {
        return helpdeskTollfreeNo;
    }

    public void setHelpdeskTollfreeNo(BigInteger helpdeskTollfreeNo) {
        this.helpdeskTollfreeNo = helpdeskTollfreeNo;
    }

    public BigInteger getHelpdeskExtensionNo() {
        return helpdeskExtensionNo;
    }

    public void setHelpdeskExtensionNo(BigInteger helpdeskExtensionNo) {
        this.helpdeskExtensionNo = helpdeskExtensionNo;
    }

    public String getHelpdeskEmail() {
        return helpdeskEmail;
    }

    public void setHelpdeskEmail(String helpdeskEmail) {
        this.helpdeskEmail = helpdeskEmail;
    }

    public String getHelpdeskChat() {
        return helpdeskChat;
    }

    public void setHelpdeskChat(String helpdeskChat) {
        this.helpdeskChat = helpdeskChat;
    }

    public Collection<HelpdeskTicket> getHelpdeskTicketCollection() {
        return helpdeskTicketCollection;
    }

    public void setHelpdeskTicketCollection(Collection<HelpdeskTicket> helpdeskTicketCollection) {
        this.helpdeskTicketCollection = helpdeskTicketCollection;
    }

    public Collection<Process> getProcessCollection() {
        return processCollection;
    }

    public void setProcessCollection(Collection<Process> processCollection) {
        this.processCollection = processCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (helpdeskId != null ? helpdeskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
     	boolean isEqual = false;
      	
      	if(object instanceof Helpdesk) {
      		
      		Helpdesk other = (Helpdesk) object;
              
      		if ((this.helpdeskId != null && other.helpdeskId != null) && (this.helpdeskId.equals(other.helpdeskId))) {
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
        return "Helpdesk[ helpdeskId=" + helpdeskId + " ]";
    }
    
}
