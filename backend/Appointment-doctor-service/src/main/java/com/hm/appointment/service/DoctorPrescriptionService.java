package com.hm.appointment.service;

import java.util.List;
import java.util.Optional;

import com.hm.appointment.Exception.PrescriptionNotFound;
import com.hm.appointment.model.DoctorPrescription;



public interface DoctorPrescriptionService {
	public DoctorPrescription savePrescription(DoctorPrescription presp);
	
	public List<DoctorPrescription> viewPresscriptionByUserId(int userId) throws PrescriptionNotFound;

}
