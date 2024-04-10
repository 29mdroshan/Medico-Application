package com.hm.appointment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.appointment.Exception.PrescriptionNotFound;
import com.hm.appointment.model.DoctorPrescription;
import com.hm.appointment.service.DoctorPrescriptionService;


@RestController
@RequestMapping("/doctor/presp")
//@CrossOrigin(origins= {"http://localhost:4200"})
public class DoctorPrescriptionController {
	
	@Autowired
	private DoctorPrescriptionService service;
	
	@PostMapping
	public DoctorPrescription savePrescription(@RequestBody DoctorPrescription presp) {
		return service.savePrescription(presp);
	}
	
	@GetMapping("/{userId}")
	public List<DoctorPrescription> viewPresscriptionByUserId(@PathVariable("userId") int userId) throws PrescriptionNotFound{
		return service.viewPresscriptionByUserId(userId);
//		System.out.println("************");
//		return null;
	}

}
