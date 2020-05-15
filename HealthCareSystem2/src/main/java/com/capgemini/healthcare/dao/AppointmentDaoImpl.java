package com.capgemini.healthcare.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.capgemini.healthcare.dto.AppointmentDto;
import com.capgemini.healthcare.entity.Appointment;
import com.capgemini.healthcare.entity.DiagnosticCenter;
import com.capgemini.healthcare.entity.Test;
import com.capgemini.healthcare.entity.User;


@Repository
public class AppointmentDaoImpl implements AppointmentDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean makeAppointment(AppointmentDto appointment) {
		// TODO Auto-generated method stub
		DiagnosticCenter center=entityManager.find(DiagnosticCenter.class, appointment.getCenterId());
		Test test=entityManager.find(Test.class, appointment.getTestId());
		User user=entityManager.find(User.class, appointment.getUserId());
		Appointment newAppointment=new Appointment( center, test, user, appointment.getAppointmentDate(), false);
		entityManager.persist(newAppointment);
		return true;
	}

	@Override
	public Appointment viewAppointment(long appointmentId){
		return entityManager.find(Appointment.class, appointmentId);
	}
	
	@Override
	public DiagnosticCenter view(long centerId){
		// TODO Auto-generated method stub
		return entityManager.find(DiagnosticCenter.class, centerId);
	}
	
	@Override
	public List<Appointment> getAppointmentList() {
		// TODO Auto-generated method stub
		String Qstr="SELECT appointment FROM Appointment appointment";
		TypedQuery<Appointment> query=entityManager.createQuery(Qstr,Appointment.class);
		return query.getResultList();
	}

	@Override
	public Test viewTest(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Test.class,id);
	}

	@Override
	public boolean approveAppointment(long id) {
		// TODO Auto-generated method stub
		Appointment appointment=entityManager.find(Appointment.class, id);
		appointment.setApproved(true);
		return true;
	}

	@Override
	public User viewUser(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(User.class,id);
	}

	@Override
	public List<DiagnosticCenter> viewDiagnosticCenterList() {
		// TODO Auto-generated method stub
		String Qstr="SELECT center FROM DiagnosticCenter center";
		TypedQuery<DiagnosticCenter> query=entityManager.createQuery(Qstr,DiagnosticCenter.class);
		return query.getResultList();
	}

}