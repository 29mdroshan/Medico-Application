package com.hm.patient.bookapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hm.patient.bookapp.model.BookAppointment;

@Repository
public interface BookAppRepo extends JpaRepository<BookAppointment, Integer>{
	
//	@Query("from BookAppointment where userId=:userId")
	public List<BookAppointment> findByUserId(int userId);
	
//	@Query("from BookAppointment where doctorId=:doctorId")
	public List<BookAppointment> findByDoctorId(long doctorId);

}
