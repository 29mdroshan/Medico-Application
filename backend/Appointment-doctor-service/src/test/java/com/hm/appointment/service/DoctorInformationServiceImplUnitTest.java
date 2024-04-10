package com.hm.appointment.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hm.appointment.model.Doctor;
import com.hm.appointment.repository.DoctorInformationRepository;

@ExtendWith(MockitoExtension.class)
class DoctorInformationServiceImplUnitTest {
	

	@InjectMocks
	public DoctorInformationServiceImpl service;
	
	@Mock
	public DoctorInformationRepository repo;

	@Test
	void testSaveDoctor() {
		Doctor doc3=new Doctor(10L,"Yashwanth","yash@gmail.com","male",22,8105935097L,"HSR","MBBS","General Physician","yash","pass123","img3");
		when(repo.save(doc3)).thenReturn(doc3);
		assertEquals(doc3, service.saveDoctor(doc3));
	}

	@Test
	void testGetAllDoctor() {
		Doctor doc3=new Doctor(10L,"Yashwanth","yash@gmail.com","male",22,8105935097L,"HSR","MBBS","General Physician","yash","pass123","img3");
		when(repo.findAll()).thenReturn(List.of(doc3));
		service.saveDoctor(doc3);
		List<Doctor> lis=new ArrayList<>();
		lis.add(doc3);
		assertEquals(lis, service.getAllDoctor());
	}

	@Test
	void testFindDoctorById() {
		Doctor doc3=new Doctor(10L,"Yashwanth","yash@gmail.com","male",22,8105935097L,"HSR","MBBS","General Physician","yash","pass123","img3");
		when(repo.findById(8105935097L)).thenReturn(Optional.of(doc3));
		assertEquals(Optional.of(doc3), service.findDoctorById(8105935097L));
		
	}


	@Test
	void testGetDoctorByUsername() {
		Doctor doc3=new Doctor(10L,"Yashwanth","yash@gmail.com","male",22,8105935097L,"HSR","MBBS","General Physician","yash","pass123","img3");
		when(repo.findByDoctorUsername("Yashwanth")).thenReturn(doc3);
		assertEquals(doc3,service.getDoctorByUsername("Yashwanth"));

	}

}
