package com.hm.patient.bookapp.service;

import java.util.List;

import com.hm.patient.bookapp.exception.AppointmentByIdNotFound;
import com.hm.patient.bookapp.model.BookAppointment;

public interface BookAppService {
	
	public BookAppointment saveAppointment(BookAppointment bookapp);
	
	public List<BookAppointment> getAllAppointment();
	
	public List<BookAppointment> getAppointmentById(int userId);
	
	public List<BookAppointment> getAppointmentByDoctorId(long doctorId);
	
	public void deleteAppointment(int appId);

}
