package com.hm.appointment.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hm.appointment.model.Doctor;


@SpringBootTest
class DoctorInformationServiceImplTest {
	
	@Autowired
	public DoctorInformationService service;
	
	Doctor doc3;

	@Test
	void testSaveDoctor() {
		doc3=new Doctor(10L,"Yashwanth","yash@gmail.com","male",22,8105935097L,"HSR","MBBS","General Physician","yash","pass123","img3");
		service.saveDoctor(doc3);
	}

	@Test
	void testGetAllDoctor() {
		service.getAllDoctor();
	}

	@Test
	void testFindDoctorById() {
		doc3=new Doctor(10L,"Yashwanth","yash@gmail.com","male",22,8105935097L,"HSR","MBBS","General Physician","yash","pass123","img3");
		service.saveDoctor(doc3);
		service.findDoctorById(10L);
	}

	@Test
	void testUpdateDoctor() {
		Doctor doc4=new Doctor(11L,"roshan","roshan@gmail.com","male",22,8105935098L,"HSR","MBBS","General Physician","roshan","pass123","img3");
		service.saveDoctor(doc4);
		service.findDoctorById(11L);
		doc4.setDoctorName("Roshan");
		doc4.setDoctorEmail("Roshan@gmail.com");
		doc4.setDoctorGender("Male");
		doc4.setDoctorAge(23);
		doc4.setDoctorPhone(8105935067L);
		doc4.setDoctorAddress("BTM");
		doc4.setDoctorSpeciality("Pediatrition");
		doc4.setDoctorQualification("MD");
		doc4.setDoctorImage("img5");
		service.saveDoctor(doc4);
		
	}

}
