package com.hm.appointment.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.hm.appointment.model.DoctorSchedule;

public interface DoctorScheduleService {
	public DoctorSchedule addSlot(DoctorSchedule slot);

	public Optional<DoctorSchedule> viewSlotById(int slotId);

	public void deleteSlotById(int slotId);
	
	public List<DoctorSchedule> fetchAllSchedule(Long doctorId);
	
	public DoctorSchedule fetchScheduleByIdAndDate(Long doctorId, LocalDate AppDate);

	public DoctorSchedule changeSlotStatus(DoctorSchedule schedule);
}
