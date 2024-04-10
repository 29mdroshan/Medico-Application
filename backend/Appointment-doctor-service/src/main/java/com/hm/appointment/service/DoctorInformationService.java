package com.hm.appointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.hm.appointment.Exception.DoctorDoesNotExist;
import com.hm.appointment.model.Doctor;


public interface DoctorInformationService {
	public Doctor saveDoctor(Doctor doctor);
	public List<Doctor> getAllDoctor();
	public Optional<Doctor> findDoctorById(long id) throws DoctorDoesNotExist;
	public Doctor updateDoctor(Doctor doctor);
	public Doctor getDoctorByUsername( String username);
	
	
	

}
