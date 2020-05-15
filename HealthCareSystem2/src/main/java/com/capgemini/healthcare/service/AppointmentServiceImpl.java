package com.capgemini.healthcare.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.healthcare.dao.AppointmentDao;
import com.capgemini.healthcare.dto.AppointmentDto;
import com.capgemini.healthcare.entity.Appointment;
import com.capgemini.healthcare.entity.DiagnosticCenter;
import com.capgemini.healthcare.entity.Test;
import com.capgemini.healthcare.entity.User;
import com.capgemini.healthcare.exception.InvalidException;
import com.capgemini.healthcare.exception.NullException;
import com.capgemini.healthcare.exception.WrongValueException;

@Transactional
@Service
public class AppointmentServiceImpl implements AppointmentService{
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Override
	public boolean addAppointment(AppointmentDto appointment) {
		// TODO Auto-generated method stub
		if(appointmentDao.makeAppointment(appointment)) {
			return true;
		}
		else {
			throw new NullException("Check again your input data!!!");
		}
	}


	@Override
	public Appointment viewAppointment(long appointmentId) {
		if(appointmentDao.viewAppointment(appointmentId)!=null) {
			return appointmentDao.viewAppointment(appointmentId);
		}
		else {
			throw new WrongValueException("Wrong Appointment ID!!!");
		}
	}

	@Override
	public List<Appointment> viewAppointmentList() {
		// TODO Auto-generated method stub
		if( appointmentDao.getAppointmentList()!=null) {
			return appointmentDao.getAppointmentList();
		}
		else {
			throw new NullException("Appointment List is empty!!!");
		}
	
	}

	@Override
	public DiagnosticCenter view(long centerId) {
		if(appointmentDao.view(centerId)!=null) {
			return appointmentDao.view(centerId);
		}
		else {
			throw new NullException("Wrong CenterID!!!");
		}
		
	}

	@Override
	public Test viewTest(long id) {
		// TODO Auto-generated method stub
		if(appointmentDao.viewTest(id)!=null) {
			return appointmentDao.viewTest(id);
		}
		else {
			throw new NullException("Wrong TestID!!!");
		}
	}

	@Override
	public boolean approveAppointment(long id) {
		// TODO Auto-generated method stub
		if(appointmentDao.approveAppointment(id)) {
			return appointmentDao.approveAppointment(id);
		}
		else {
		throw new InvalidException("Appointment is already approved!!!");
		}
	}


	@Override
	public User viewUser(long id) {
		// TODO Auto-generated method stub
		if(appointmentDao.viewUser(id)!=null) {
			return appointmentDao.viewUser(id);
		}
		else {
			throw new NullException("Wrong UserID!!!");
		}
	}


	@Override
	public List<DiagnosticCenter> viewDiagnosticCenterList() {
		// TODO Auto-generated method stub
		return appointmentDao.viewDiagnosticCenterList();
	}


	
	public void  saveAppointment(AppointmentDao appointment) {
		// TODO Auto-generated method stub
		return appointmentDao.save(appointment);
		
	}

}