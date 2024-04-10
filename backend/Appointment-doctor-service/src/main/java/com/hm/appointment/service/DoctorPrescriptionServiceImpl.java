package com.hm.appointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.appointment.Exception.PrescriptionNotFound;
import com.hm.appointment.model.DoctorPrescription;
import com.hm.appointment.repository.DoctorPrescriptionRepository;

@Service
public class DoctorPrescriptionServiceImpl implements DoctorPrescriptionService {

	
	@Autowired
	DoctorPrescriptionRepository repo;
	
	
	@Override
	public DoctorPrescription savePrescription(DoctorPrescription presp) {
		return repo.save(presp);
	}

	@Override
	public List<DoctorPrescription> viewPresscriptionByUserId(int userId) throws PrescriptionNotFound{
		if(!repo.existsById(userId)) {
			throw new PrescriptionNotFound("Prescription with ID" +userId+"Does Not Exist");
		}
		return repo.findByUserId(userId);
	}

}
