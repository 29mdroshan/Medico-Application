package com.hm.patient.patientregister.service;

import java.util.List;

import com.hm.patient.patientregister.model.Patient;

public interface PatientService {
	
	public Patient savePatient(Patient patient);
	
	public List<Patient> getAllPatient();
	
	public Patient getPatientByUsername(String username);
	
	public Patient updatePatient(Patient patient);

	Patient savePatient1(Patient patient);
	
}
