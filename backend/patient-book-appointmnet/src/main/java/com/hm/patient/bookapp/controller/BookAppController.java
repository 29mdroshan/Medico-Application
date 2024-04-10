package com.hm.patient.bookapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.patient.bookapp.exception.AppointmentByIdNotFound;
import com.hm.patient.bookapp.model.BookAppointment;
import com.hm.patient.bookapp.service.BookAppService;

@RestController
@RequestMapping("/bookapp")
//@CrossOrigin(origins= {"http://localhost:4200"})
public class BookAppController {

	@Autowired
	public BookAppService service;
	
	
	@GetMapping("/{userId}")
	public void sample(@PathVariable("userId") LocalDate userId) {
		System.out.println(userId);
		
	}


	@GetMapping("/appointmentById/{userId}")
	public List<BookAppointment> getAppointmentByUserId(@PathVariable("userId") int userId) {
//		System.out.println("***********");
//		return null;
		return service.getAppointmentById(userId);
	}
	
	@PostMapping("/save")
	public BookAppointment saveAppointment( @RequestBody BookAppointment bookapp) {
		return service.saveAppointment(bookapp);
	}
	
	@GetMapping("/appointmentByDoctorId/{doctorId}")
	public List<BookAppointment> getAppointmentByDoctorId(@PathVariable("doctorId") Long doctorId){
		System.out.println(doctorId);
		return service.getAppointmentByDoctorId(doctorId);
	}
	
	@GetMapping("/allapp")
	public List<BookAppointment> getAllAppointment(){
		return service.getAllAppointment();
	}
	
	@DeleteMapping("{appId}")
	public void deleteAppointment(@PathVariable("appId") int appId) {
		service.deleteAppointment(appId);
	}


}
