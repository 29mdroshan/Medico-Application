package com.hm.appointment.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hm.appointment.model.DoctorSchedule;
import com.hm.appointment.service.DoctorScheduleService;

@RestController
@RequestMapping("/doctor/schedule")
//@CrossOrigin(origins= {"http://localhost:4200"})
public class DoctorScheduleController {
	@Autowired
	private DoctorScheduleService service;
	
	@PostMapping("/saveschedule")
	public DoctorSchedule addSlot(@RequestBody DoctorSchedule slot) {
		return service.addSlot(slot);
	}
	
	@GetMapping("/getSchedule/{id}")
	public Optional<DoctorSchedule> viewBySlotId(@PathVariable("id") int slotId){
		return service.viewSlotById(slotId);
	}
	
	@DeleteMapping("/deleteSchedule/{id}")
	public void deleteById (@PathVariable("id") int slotId){
		service.deleteSlotById(slotId);
	}
	
	@GetMapping("/fetchSchedule/{id}")
	public List<DoctorSchedule> viewDoctorSlots(@PathVariable("id") long doctorId){
		return service.fetchAllSchedule(doctorId);
	}
	
	@GetMapping("/fetch/{doctorId}/{appDate}")
	public DoctorSchedule fetchScheduleByIdAndDate(@PathVariable("doctorId") long doctorId,@PathVariable("appDate") LocalDate appDate) {
//		System.out.println(doctorId);
//		return null;
		return service.fetchScheduleByIdAndDate(doctorId, appDate);
	}
	
	
	@PutMapping("/slot")
	public DoctorSchedule changeSlotStatus(@RequestBody DoctorSchedule schedule) {
		
		return service.changeSlotStatus(schedule);
	}
	

}
