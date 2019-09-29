package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

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
@Table(name = "TIMESHEET")
@NamedQuery(name = "Timesheet.findAll", query = "SELECT t FROM Timesheet t")
@NamedQuery(name = "Timesheet.findByTimesheetId", query = "SELECT t FROM Timesheet t WHERE t.timesheetId = :timesheetId")
@NamedQuery(name = "Timesheet.findByIsbillable", query = "SELECT t FROM Timesheet t WHERE t.isbillable = :isbillable")
@NamedQuery(name = "Timesheet.findByType", query = "SELECT t FROM Timesheet t WHERE t.type = :type")
@NamedQuery(name = "Timesheet.findByStatus", query = "SELECT t FROM Timesheet t WHERE t.status = :status")
@NamedQuery(name = "Timesheet.findByHours", query = "SELECT t FROM Timesheet t WHERE t.hours = :hours")
public class Timesheet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TIMESHEET_ID")
    private BigDecimal timesheetId;
    @Column(name = "ISBILLABLE")
    private String isbillable;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "HOURS")
    private BigInteger hours;
    @JoinColumn(name = "ATTENDANCE_ID", referencedColumnName = "ATTENDANCE_ID")
    @ManyToOne
    private Attendance attendanceId;
    @JoinColumn(name = "ORG_PROJECT_CODE", referencedColumnName = "PROJECT_CODE")
    @ManyToOne
    private Project orgProjectCode;

    public Timesheet() {
    }

    public Timesheet(BigDecimal timesheetId) {
        this.timesheetId = timesheetId;
    }

    public BigDecimal getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(BigDecimal timesheetId) {
        this.timesheetId = timesheetId;
    }

    public String getIsbillable() {
        return isbillable;
    }

    public void setIsbillable(String isbillable) {
        this.isbillable = isbillable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getHours() {
        return hours;
    }

    public void setHours(BigInteger hours) {
        this.hours = hours;
    }

    public Attendance getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Attendance attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Project getOrgProjectCode() {
        return orgProjectCode;
    }

    public void setOrgProjectCode(Project orgProjectCode) {
        this.orgProjectCode = orgProjectCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timesheetId != null ? timesheetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
    	boolean isEqual = false;
      	
      	if(object instanceof Timesheet) {
      		
      		Timesheet other = (Timesheet) object;
              
      		if ((this.timesheetId != null && other.timesheetId != null) && (this.timesheetId.equals(other.timesheetId))) {
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
        return "Timesheet[ timesheetId=" + timesheetId + " ]";
    }

}
