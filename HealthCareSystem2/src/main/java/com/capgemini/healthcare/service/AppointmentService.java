package com.capgemini.healthcare.service;

import java.util.List;

import com.capgemini.healthcare.dto.AppointmentDto;
import com.capgemini.healthcare.entity.Appointment;
import com.capgemini.healthcare.entity.DiagnosticCenter;
import com.capgemini.healthcare.entity.Test;
import com.capgemini.healthcare.entity.User;

public interface AppointmentService 
{
	boolean addAppointment(AppointmentDto appointment);

	Appointment viewAppointment(long appointmentId);
	List<Appointment> viewAppointmentList();
	DiagnosticCenter view(long centerId);
	Test viewTest(long id);
	User viewUser(long id);
	boolean approveAppointment(long id);
	List<DiagnosticCenter> viewDiagnosticCenterList();

	void saveAppointment(AppointmentDto appointment);
}