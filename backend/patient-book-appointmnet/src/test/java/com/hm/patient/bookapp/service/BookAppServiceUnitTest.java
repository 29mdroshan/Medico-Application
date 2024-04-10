package com.hm.patient.bookapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hm.patient.bookapp.model.BookAppointment;
import com.hm.patient.bookapp.repo.BookAppRepo;

@ExtendWith(MockitoExtension.class)
class BookAppServiceUnitTest {

	@InjectMocks
	public BookAppImpl service;
	
	@Mock
	public BookAppRepo repo;
	
	@Test
	void testSaveAppointment() {
		BookAppointment app1= new BookAppointment(10,101,"chandan","chandan@gmail.com",LocalDate.of(2023, 01, 01),"10:21","fever",1234L,"roshan");
		when(repo.save(app1)).thenReturn(app1);
		assertEquals(app1, service.saveAppointment(app1));
	}

	@Test
	void testGetAllAppointment() {
		BookAppointment app1= new BookAppointment(10,101,"chandan","chandan@gmail.com",LocalDate.of(2023, 01, 01),"10:21","fever",1234L,"roshan");
		when(repo.findAll()).thenReturn(List.of(app1));
		assertEquals(List.of(app1), service.getAllAppointment());
		
	}

	@Test
	void testGetAppointmentById() {
		BookAppointment app1= new BookAppointment(10,101,"chandan","chandan@gmail.com",LocalDate.of(2023, 01, 01),"10:21","fever",1234L,"roshan");
		when(repo.findByUserId(101)).thenReturn(List.of(app1));
		assertEquals(List.of(app1), service.getAppointmentById(101));
	}

	@Test
	void testGetAppointmentByDoctorId() {
		BookAppointment app1= new BookAppointment(10,101,"chandan","chandan@gmail.com",LocalDate.of(2023, 01, 01),"10:21","fever",1234L,"roshan");
		when(repo.findByDoctorId(1234L)).thenReturn(List.of(app1));
		assertEquals(List.of(app1), service.getAppointmentByDoctorId(1234L));
		
	}

	@Test
	void testDeleteAppointment() {
		BookAppointment app1= new BookAppointment(10,101,"chandan","chandan@gmail.com",LocalDate.of(2023, 01, 01),"10:21","fever",1234L,"roshan");
		service.deleteAppointment(10);
	}

}
