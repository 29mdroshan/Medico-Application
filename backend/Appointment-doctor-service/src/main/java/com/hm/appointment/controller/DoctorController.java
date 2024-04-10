package com.hm.appointment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.appointment.Exception.DoctorDoesNotExist;
import com.hm.appointment.model.Doctor;
import com.hm.appointment.service.DoctorInformationService;

@RestController
@RequestMapping("/doctor/register")
//@CrossOrigin(origins= {"http://localhost:4200"})
public class DoctorController {
	
	@Autowired
	DoctorInformationService service;
	
	
	@PostMapping("/permanentDoctor")
	public Doctor saveDoctorInfo(@RequestBody Doctor doctor) {
		return service.saveDoctor(doctor);
	}
	
	@GetMapping
	public List<Doctor> getAllDoctor(){
		return service.getAllDoctor();
	}
	@GetMapping("/{id}")
	public Optional<Doctor> getDoctorById(@PathVariable("id") long id) throws DoctorDoesNotExist {
		return service.findDoctorById(id);
	}
	@PutMapping
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		return service.updateDoctor(doctor);
	}
	
	@GetMapping("/username/{username}")
	public Doctor getDoctorByUsername(@PathVariable("username") String username) {
		return service.getDoctorByUsername(username);
	}

}
