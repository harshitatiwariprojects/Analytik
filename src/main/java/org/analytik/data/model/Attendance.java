package org.analytik.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ATTENDANCE")
@NamedQuery(name = "Attendance.findAll", query = "SELECT a FROM Attendance a")
@NamedQuery(name = "Attendance.findByAttendanceId", query = "SELECT a FROM Attendance a WHERE a.attendanceId = :attendanceId")
@NamedQuery(name = "Attendance.findByLeaveType", query = "SELECT a FROM Attendance a WHERE a.leaveType = :leaveType")
@NamedQuery(name = "Attendance.findByLoginTime", query = "SELECT a FROM Attendance a WHERE a.loginTime = :loginTime")
@NamedQuery(name = "Attendance.findByLogoutTime", query = "SELECT a FROM Attendance a WHERE a.logoutTime = :logoutTime")
public class Attendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ATTENDANCE_ID")
    private BigDecimal attendanceId;
    @Column(name = "LEAVE_TYPE")
    private String leaveType;
    @Column(name = "LOGIN_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginTime;
    @Column(name = "LOGOUT_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logoutTime;
    @OneToMany(mappedBy = "attendanceId")
    private Collection<Timesheet> timesheetCollection;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employee empId;

    public Attendance() {
    }

    public Attendance(BigDecimal attendanceId) {
        this.attendanceId = attendanceId;
    }

    public BigDecimal getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(BigDecimal attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public Collection<Timesheet> getTimesheetCollection() {
        return timesheetCollection;
    }

    public void setTimesheetCollection(Collection<Timesheet> timesheetCollection) {
        this.timesheetCollection = timesheetCollection;
    }

    public Employee getEmpId() {
        return empId;
    }

    public void setEmpId(Employee empId) {
        this.empId = empId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attendanceId != null ? attendanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	
    	boolean isEqual = false;
    	
    	if(object instanceof Attendance) {
    		
    		Attendance other = (Attendance) object;
            
    		if ((this.attendanceId != null && other.attendanceId != null) && (this.attendanceId.equals(other.attendanceId))) {
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
        return "Attendance[ attendanceId=" + attendanceId + " ]";
    }
    
}
