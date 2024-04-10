package com.hm.patient.patientregister.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hm.patient.patientregister.model.Patient;
@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

	Patient findByUserName1(String username);

	Patient findByUserId(int userId);

}
