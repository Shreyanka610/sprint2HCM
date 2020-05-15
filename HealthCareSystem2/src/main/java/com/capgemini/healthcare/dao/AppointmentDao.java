package com.capgemini.healthcare.dao;

import java.util.List;

import com.capgemini.healthcare.dto.AppointmentDto;
import com.capgemini.healthcare.entity.Appointment;
import com.capgemini.healthcare.entity.DiagnosticCenter;
import com.capgemini.healthcare.entity.Test;
import com.capgemini.healthcare.entity.User;

public interface AppointmentDao {
	boolean makeAppointment(AppointmentDto appointment);
	Appointment viewAppointment(long appointmnetId);
	List<Appointment> getAppointmentList();
	DiagnosticCenter view(long centerId);
	Test viewTest(long id);
	boolean approveAppointment(long id);
	User viewUser(long id);
	List<DiagnosticCenter> viewDiagnosticCenterList();
	Object save(AppointmentDao appointment);
}