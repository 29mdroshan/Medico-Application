package com.hm.appointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.appointment.Exception.DoctorDoesNotExist;
import com.hm.appointment.model.Doctor;
import com.hm.appointment.repository.DoctorInformationRepository;


@Service
public class DoctorInformationServiceImpl implements DoctorInformationService{
	
	@Autowired
	DoctorInformationRepository repo;

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return repo.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctor() {
		return repo.findAll();
	}

	@Override
	public Optional<Doctor> findDoctorById(long id) throws DoctorDoesNotExist{
		if(!repo.existsById(id)) {
			throw new DoctorDoesNotExist("Doctor With ID "+id+" Does Not exist");
		}
		return repo.findById(id);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		Doctor updateDoc = repo.updateDoctor(doctor.getDoctorId());
		updateDoc.setDoctorName(doctor.getDoctorName());
		updateDoc.setDoctorImage(doctor.getDoctorImage());
		updateDoc.setDoctorGender(doctor.getDoctorGender());
		updateDoc.setDoctorEmail(doctor.getDoctorEmail());
		updateDoc.setDoctorAge(doctor.getDoctorAge());
		updateDoc.setDoctorPhone(doctor.getDoctorPhone());
		updateDoc.setDoctorAddress(doctor.getDoctorAddress());
		updateDoc.setDoctorSpeciality(doctor.getDoctorSpeciality());
		updateDoc.setDoctorQualification(doctor.getDoctorQualification());
		updateDoc.setDoctorImage(doctor.getDoctorImage());
		
		
		
		return repo.save(updateDoc);
	}

	@Override
	public Doctor getDoctorByUsername(String username) {
		
		return repo.findByDoctorUsername(username);
	}
	
	
	
	

}
