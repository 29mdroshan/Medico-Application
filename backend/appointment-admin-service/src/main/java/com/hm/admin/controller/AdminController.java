package com.hm.admin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.admin.model.Doctor;
import com.hm.admin.service.AdminService;

@RestController
@RequestMapping("/admin")
//@CrossOrigin(origins= {"http://localhost:4200"})
public class AdminController {
	@Autowired
	public AdminService service;
	
	@PostMapping("/saveDoctors")
	public Doctor saveTemporaryDoctor(@RequestBody Doctor doctor) {
		return service.saveTemporaryDoctor(doctor);
	}
	@GetMapping("/getDoctors")
	public List<Doctor> getDoctor() {
		return service.fetchAllTemporaryDoctor();
	}
	
	@DeleteMapping("/deleteDoctor/{doctorPhone}")
	public void deleteDoctor(@PathVariable("doctorPhone") long doctorPhone){
		
		
		service.deleteTempDoctor(doctorPhone);
		
	}
	
	@PostMapping("/savePermanentDoctors")
	public Doctor savePermanentDoctor(@RequestBody Doctor doctor){
		return service.savePermanentDoctor(doctor);
		
	}
	
	
	

}
