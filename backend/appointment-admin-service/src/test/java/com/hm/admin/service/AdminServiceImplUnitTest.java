package com.hm.admin.service;

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

import com.hm.admin.model.Doctor;
import com.hm.admin.repository.AdminRepository;

@ExtendWith(MockitoExtension.class)
class AdminServiceImplUnitTest {
	
	@InjectMocks
	public AdminServiceImpl service;
	
	@Mock
	public AdminRepository repo;

	@Test
	void testSaveTemporaryDoctor() {
		Doctor doc1=new Doctor("Yashwanth","yash@gmail.com","male",22,8105935097L,"HSR","MBBS","General Physician","yash","pass123","img3");
		when(repo.save(doc1)).thenReturn(doc1);
		assertEquals(doc1, service.saveTemporaryDoctor(doc1));
	}

	@Test
	void testFetchAllTemporaryDoctor() {
		Doctor doc1=new Doctor("Yashwanth","yash@gmail.com","male",22,8105935097L,"HSR","MBBS","General Physician","yash","pass123","img3");
		when(repo.findAll()).thenReturn(List.of(doc1));
		service.saveTemporaryDoctor(doc1);
		List<Doctor> lis=new ArrayList<>();
		lis.add(doc1);
		assertEquals(lis, service.fetchAllTemporaryDoctor());
	}

}
