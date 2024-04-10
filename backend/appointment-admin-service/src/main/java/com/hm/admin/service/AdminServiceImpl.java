package com.hm.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hm.admin.model.Doctor;
import com.hm.admin.model.LoginCredentials;
import com.hm.admin.model.Role;
import com.hm.admin.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private RestTemplate rt;
	
	@Autowired
	public AdminRepository repo;

	@Override
	public Doctor saveTemporaryDoctor(Doctor doctor) {
		return repo.save(doctor);
	}

	@Override
	public List<Doctor> fetchAllTemporaryDoctor() {
	
		return repo.findAll();
	}

	@Override
	public Doctor savePermanentDoctor(Doctor doctor) {
		Doctor doctor1=rt.postForObject("http://APPOINTMENT-DOCTOR-SERVICE/doctor/register/permanentDoctor",doctor, Doctor.class);
		repo.deleteById(doctor.getDoctorPhone());
		LoginCredentials logincr=new LoginCredentials(doctor.getDoctorUsername(),doctor.getDoctorPassword(),Role.DOCTOR);
		rt.postForObject("http://APPOINTMENT-AUTH-SERVICE/authenticate/user", logincr, LoginCredentials.class);
		
		return doctor1;
	}

	@Override
	public void deleteTempDoctor(long doctorPhone) {
		repo.deleteById(doctorPhone);
		
	}
	
	

}
