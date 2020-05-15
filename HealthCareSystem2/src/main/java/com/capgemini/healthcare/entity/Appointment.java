package com.capgemini.healthcare.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="APPOINTMENT")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Appointment implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
    @SequenceGenerator(sequenceName = "appointment_seq", allocationSize = 1, name = "appointment_seq")
	private long appointmentId;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE}, optional = false)
	@JoinColumn(name = "CENTER_ID", nullable = false)
	private DiagnosticCenter center;
		
	@ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE}, optional = false)
	@JoinColumn(name = "testId",nullable = false)
	private Test test;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE}, optional = false)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;
	
	private LocalDate datetime;
	
	private boolean approved;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public DiagnosticCenter getCenter() {
		return center;
	}
	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDate datetime) {
		this.datetime = datetime;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public Appointment() {
		super();
	}
	public Appointment(DiagnosticCenter center, Test test, User user, LocalDate datetime,
			boolean approved) {
		super();
		this.center = center;
		this.test = test;
		this.user = user;
		this.datetime = datetime;
		this.approved = approved;
	}

	


}