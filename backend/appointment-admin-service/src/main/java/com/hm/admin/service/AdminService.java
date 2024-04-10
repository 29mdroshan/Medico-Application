package com.hm.admin.service;

import java.util.List;

import com.hm.admin.model.Doctor;


public interface AdminService {
	public Doctor saveTemporaryDoctor(Doctor doctor);
	
	public void deleteTempDoctor(long doctorPhone);
	
	public List<Doctor> fetchAllTemporaryDoctor();
	
	public Doctor savePermanentDoctor(Doctor doctor);
	
	
	


}
