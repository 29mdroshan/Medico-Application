package com.hm.patient.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.patient.bookapp.exception.AppointmentByIdNotFound;
import com.hm.patient.bookapp.model.BookAppointment;
import com.hm.patient.bookapp.repo.BookAppRepo;

@Service
public class BookAppImpl implements BookAppService {

	@Autowired
	public BookAppRepo repo;
	
	@Override
	public BookAppointment saveAppointment(BookAppointment bookapp) {
		return repo.save(bookapp);
	}

	@Override
	public List<BookAppointment> getAllAppointment() {
		return repo.findAll();
	}

	@Override
	public List<BookAppointment> getAppointmentById(int userId)throws AppointmentByIdNotFound {
//		if(!repo.existsById(userId)) {
//			throw new AppointmentByIdNotFound("Appointment with "+userId+" Does not exist");
//		}
		return repo.findByUserId(userId);
	}

	@Override
	public List<BookAppointment> getAppointmentByDoctorId(long doctorId) {
		return repo.findByDoctorId(doctorId);
	}
	
	
	@Override
	public void deleteAppointment(int appId) {
		repo.deleteById(appId);
	}

}
