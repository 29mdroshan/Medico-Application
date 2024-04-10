package com.hm.patient.patientregister.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.patient.patientregister.model.Patient;
import com.hm.patient.patientregister.repo.PatientRepo;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	public PatientRepo repo;
	
	@Override
	public Patient savePatient(Patient patient) {
		return repo.save(patient);
	}
	
	@Override
	public Patient savePatient1(Patient patient) {
		
		return patient;
	}

	@Override
	public List<Patient> getAllPatient() {
		return repo.findAll();
	}

	@Override
	public Patient getPatientByUsername(String username) {
		
		return repo.findByUserName1(username);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		Patient p=repo.findByUserId(patient.getUserId());
		p.setUserName(patient.getUserName());
		p.setUserAge(patient.getUserAge());
		p.setUserAddress(patient.getUserAddress());
		p.setUserPhone(patient.getUserPhone());
		p.setUserEmail(patient.getUserEmail());
		p.setUserGender(patient.getUserGender());
		return repo.save(p);
	}

}
