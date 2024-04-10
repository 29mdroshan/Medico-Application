package com.hm.appointment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.andrewoma.dexx.collection.List;
import com.hm.appointment.model.DoctorPrescription;


public interface DoctorPrescriptionRepository  extends JpaRepository<DoctorPrescription,Integer> {

	public java.util.List<DoctorPrescription> findByUserId(int userId);

	

}
