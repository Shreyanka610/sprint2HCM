package com.capgemini.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcare.dto.AppointmentDto;
import com.capgemini.healthcare.entity.Appointment;
import com.capgemini.healthcare.entity.DiagnosticCenter;
import com.capgemini.healthcare.entity.Test;
import com.capgemini.healthcare.entity.User;
import com.capgemini.healthcare.exception.NullException;
import com.capgemini.healthcare.exception.WrongValueException;
import com.capgemini.healthcare.service.AppointmentService;



@SpringBootApplication
@RestController
@CrossOrigin
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping("/getAllAppointment")
    public ResponseEntity<List<Appointment>> getAllAppointmentDetails() {
		try {
			List<Appointment> listAppointment = appointmentService.viewAppointmentList();
			return new ResponseEntity<List<Appointment>>(listAppointment,HttpStatus.OK);
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
	}
	
	@PutMapping("/approveAppointment/{AppointmentId}")
	@CrossOrigin(origins="http://localhost:4200")
    public String approveAppointment(@PathVariable("AppointmentId") long id) {
		try {
			if(appointmentService.approveAppointment(id)==true) {
				return "Appointment is approved!!!";
			}
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return "Appointment is approved!!!";
	}

	@PostMapping("/addApointment")
	public String addAppointment(@RequestBody AppointmentDto appointment ) 
	{
		 appointmentService.saveAppointment(appointment);
		 return "addedsucessfully!!";
	
		
	}
	/*
	 * try { appointmentService.addAppointment(appointment); } catch(Exception e) {
	 * throw new NullException(e.getMessage()); } return
	 * "Appointment Added SUCESSFULLY!!!"; }
	 */


	@GetMapping("/getAppointment/{AppointmentId}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("AppointmentId") long id) {
		Appointment appointment;
		try {
			appointment = appointmentService.viewAppointment(id);
		}
		catch(Exception e) {
			throw new WrongValueException(e.getMessage());
		}
		return new ResponseEntity<Appointment>(appointment,HttpStatus.OK);
	}
	
	@GetMapping("/getCenter/{centerId}")
    public ResponseEntity<DiagnosticCenter> getCenterById(@PathVariable("centerId") long id) {
		try {
			DiagnosticCenter center = appointmentService.view(id);
			return new ResponseEntity<DiagnosticCenter>(center,HttpStatus.OK);
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
	}
	
	@GetMapping("/getAllCenters")
    public ResponseEntity<List<DiagnosticCenter>> getAllCenters() {
		try {
			List<DiagnosticCenter> centerList = appointmentService.viewDiagnosticCenterList();
			return new ResponseEntity<List<DiagnosticCenter>>(centerList,HttpStatus.OK);
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
	}
	
	@GetMapping("/getTest/{testId}")
    public ResponseEntity<Test> getTestById(@PathVariable("testId") long id) {
		
		Test test= appointmentService.viewTest(id);
		try {
			if(test!=null)
				return new ResponseEntity<Test>(test,HttpStatus.OK);
			}
			catch(Exception e) {
				throw new NullException(e.getMessage());
			}
		return new ResponseEntity<Test>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") long id) {
		User user= appointmentService.viewUser(id);
		try {
			if(user!=null)
				return new ResponseEntity<User>(user,HttpStatus.OK);
			}
			catch(Exception e) {
				throw new NullException(e.getMessage());
			}
		return new ResponseEntity<User>(user,HttpStatus.OK);

	}
}