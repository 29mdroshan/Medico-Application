package com.hm.patient.bookapp.service;

import java.time.LocalDate;
import java.time.LocalTime;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hm.patient.bookapp.model.BookAppointment;

@SpringBootTest
class BookAppServiceTest {
	
	@Autowired
	public BookAppService service;
	
	BookAppointment app1;
	
	@Test
	void testSaveAppointment() {
		BookAppointment app1= new BookAppointment(10,101,"chandan","chandan@gmail.com",LocalDate.of(2023, 01, 01),"10:21","fever",1234L,"roshan");
		service.saveAppointment(app1);
	}

	@Test
	void testGetAllAppointment() {
		BookAppointment app1= new BookAppointment(10,101,"chandan","chandan@gmail.com",LocalDate.of(2023, 01, 01),"10:21","fever",1234L,"roshan");
		service.saveAppointment(app1);
		service.getAllAppointment();
	}

	@Test
	void testGetAppointmentById() {
		BookAppointment app1= new BookAppointment(10,101,"chandan","chandan@gmail.com",LocalDate.of(2023, 01, 01),"10:21","fever",1234L,"roshan");
		service.saveAppointment(app1);
		service.getAppointmentById(101);
	}

	@Test
	void testGetAppointmentByDoctorId() {
		BookAppointment app1= new BookAppointment(10,101,"chandan","chandan@gmail.com",LocalDate.of(2023, 01, 01),"10:21","fever",1234L,"roshan");
		service.saveAppointment(app1);
		service.getAppointmentByDoctorId(1234);
	}

}
