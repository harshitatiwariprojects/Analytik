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
@Table(name = "HELPDESK_TICKET")
@NamedQuery(name = "HelpdeskTicket.findAll", query = "SELECT h FROM HelpdeskTicket h")
@NamedQuery(name = "HelpdeskTicket.findByTicketId", query = "SELECT h FROM HelpdeskTicket h WHERE h.ticketId = :ticketId")
@NamedQuery(name = "HelpdeskTicket.findByTicketNo", query = "SELECT h FROM HelpdeskTicket h WHERE h.ticketNo = :ticketNo")
@NamedQuery(name = "HelpdeskTicket.findByTicketReportingTime", query = "SELECT h FROM HelpdeskTicket h WHERE h.ticketReportingTime = :ticketReportingTime")
@NamedQuery(name = "HelpdeskTicket.findByTicketResolutionTime", query = "SELECT h FROM HelpdeskTicket h WHERE h.ticketResolutionTime = :ticketResolutionTime")
@NamedQuery(name = "HelpdeskTicket.findByTicketProcessSla", query = "SELECT h FROM HelpdeskTicket h WHERE h.ticketProcessSla = :ticketProcessSla")
@NamedQuery(name = "HelpdeskTicket.findByTicketStatus", query = "SELECT h FROM HelpdeskTicket h WHERE h.ticketStatus = :ticketStatus")
public class HelpdeskTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TICKET_ID")
    private BigDecimal ticketId;
    @Column(name = "TICKET_NO")
    private BigInteger ticketNo;
    @Column(name = "TICKET_REPORTING_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ticketReportingTime;
    @Column(name = "TICKET_RESOLUTION_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ticketResolutionTime;
    @Column(name = "TICKET_PROCESS_SLA")
    private BigInteger ticketProcessSla;
    @Column(name = "TICKET_STATUS")
    private String ticketStatus;
    @JoinColumn(name = "TICKET_ESCALATION_OWNER", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(optional = false)
    private Employee ticketEscalationOwner;
    @JoinColumn(name = "TICKET_OWNER", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(optional = false)
    private Employee ticketOwner;
    @JoinColumn(name = "HELPDESK_ID", referencedColumnName = "HELPDESK_ID")
    @ManyToOne(optional = false)
    private Helpdesk helpdeskId;

    public HelpdeskTicket() {
    }

    public HelpdeskTicket(BigDecimal ticketId) {
        this.ticketId = ticketId;
    }

    public BigDecimal getTicketId() {
        return ticketId;
    }

    public void setTicketId(BigDecimal ticketId) {
        this.ticketId = ticketId;
    }

    public BigInteger getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(BigInteger ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Date getTicketReportingTime() {
        return ticketReportingTime;
    }

    public void setTicketReportingTime(Date ticketReportingTime) {
        this.ticketReportingTime = ticketReportingTime;
    }

    public Date getTicketResolutionTime() {
        return ticketResolutionTime;
    }

    public void setTicketResolutionTime(Date ticketResolutionTime) {
        this.ticketResolutionTime = ticketResolutionTime;
    }

    public BigInteger getTicketProcessSla() {
        return ticketProcessSla;
    }

    public void setTicketProcessSla(BigInteger ticketProcessSla) {
        this.ticketProcessSla = ticketProcessSla;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Employee getTicketEscalationOwner() {
        return ticketEscalationOwner;
    }

    public void setTicketEscalationOwner(Employee ticketEscalationOwner) {
        this.ticketEscalationOwner = ticketEscalationOwner;
    }

    public Employee getTicketOwner() {
        return ticketOwner;
    }

    public void setTicketOwner(Employee ticketOwner) {
        this.ticketOwner = ticketOwner;
    }

    public Helpdesk getHelpdeskId() {
        return helpdeskId;
    }

    public void setHelpdeskId(Helpdesk helpdeskId) {
        this.helpdeskId = helpdeskId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
     	boolean isEqual = false;
      	
      	if(object instanceof HelpdeskTicket) {
      		
      		HelpdeskTicket other = (HelpdeskTicket) object;
              
      		if ((this.ticketId != null && other.ticketId != null) && (this.ticketId.equals(other.ticketId))) {
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
        return "HelpdeskTicket[ ticketId=" + ticketId + " ]";
    }
    
}
