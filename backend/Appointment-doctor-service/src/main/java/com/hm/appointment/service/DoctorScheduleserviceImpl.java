package com.hm.appointment.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.appointment.model.DoctorSchedule;
import com.hm.appointment.repository.DoctorScheduleRepository;

@Service
public class DoctorScheduleserviceImpl implements DoctorScheduleService {
	
	
	@Autowired
	private DoctorScheduleRepository repo;

	@Override
	public DoctorSchedule addSlot(DoctorSchedule slot) {
		
		return repo.save(slot);
	}

	@Override
	public Optional<DoctorSchedule> viewSlotById(int slotId) {
		return repo.findById(slotId);
	}

	@Override
	public void deleteSlotById(int slotId) {
		repo.deleteById(slotId);

	}



	@Override
	public DoctorSchedule changeSlotStatus(DoctorSchedule schedule) {
		DoctorSchedule doctorSch=repo.findBySlotId(schedule.getSlotId());
		doctorSch.setDoctorSlots(schedule.getDoctorSlots());
		return repo.save(doctorSch);
	}

	@Override
	public List<DoctorSchedule> fetchAllSchedule(Long doctorId) {
		return repo.findAllByDoctorId(doctorId);
	}

	@Override
	public DoctorSchedule fetchScheduleByIdAndDate(Long doctorId, LocalDate AppDate) {
		return repo.fetchScheduleByIdAndDate(doctorId, AppDate);
	}
	

	
}
