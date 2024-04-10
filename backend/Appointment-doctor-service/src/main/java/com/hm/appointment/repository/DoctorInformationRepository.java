package com.hm.appointment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hm.appointment.model.Doctor;

@Repository
public interface DoctorInformationRepository extends JpaRepository<Doctor, Long> {

	@Query("from Doctor where doctorId=:doctorId")
	public Doctor updateDoctor(Long doctorId);

	public Doctor findByDoctorUsername(String username);
	 

}
