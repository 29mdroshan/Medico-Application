package com.hm.patient.patientregister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.patient.patientregister.model.Patient;
import com.hm.patient.patientregister.service.PatientService;

@RestController
@RequestMapping("/patient")
//@CrossOrigin(origins= {"http://localhost:4200"})
public class PatientController {
	
	@Autowired
	public PatientService service;
	
	@PostMapping
	public Patient savePatientInfo(@RequestBody Patient patient) {
		return service.savePatient(patient);
	}
	
	@GetMapping("/allPatient")
	public List<Patient> getAllPatient(){
		return service.getAllPatient();
	}
	
	@GetMapping("/getpatient/{username}")
	public Patient getPatientByUsername(@PathVariable("username") String username){
		return service.getPatientByUsername(username);
	}
	
	@PutMapping("/updatepatient")
	public Patient getPatientByUsername(@RequestBody Patient patient){
		return service.updatePatient(patient);
	}
	

	
	

}
