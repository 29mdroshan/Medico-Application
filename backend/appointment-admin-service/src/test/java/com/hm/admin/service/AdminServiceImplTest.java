package com.hm.admin.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hm.admin.model.Doctor;

@SpringBootTest
class AdminServiceImplTest {
	
	@Autowired
	public AdminService service;
	
	Doctor doc1,doc2,doc3;

	@Test
	void testSaveTemporaryDoctor() {
		Doctor doc3=new Doctor("Yashwanth","yash@gmail.com","male",22,8105935097L,"HSR","MBBS","General Physician","yash","pass123","img3");
		service.saveTemporaryDoctor(doc3);
		
	}

	@Test
	void testFetchAllTemporaryDoctor() {
		assertNotNull(service.fetchAllTemporaryDoctor());
	}

	

}
