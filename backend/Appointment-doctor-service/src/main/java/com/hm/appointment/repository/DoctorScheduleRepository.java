package com.hm.appointment.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.hm.appointment.model.DoctorSchedule;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule,Integer> {

	public List<DoctorSchedule> findAllByDoctorId(long doctorId);
	
	@Query("from DoctorSchedule where doctorId=:doctorId and scheduleDate=:AppDate")
	public DoctorSchedule fetchScheduleByIdAndDate(long doctorId, LocalDate AppDate);
	
	public DoctorSchedule findBySlotId(int slotId);

	
}
