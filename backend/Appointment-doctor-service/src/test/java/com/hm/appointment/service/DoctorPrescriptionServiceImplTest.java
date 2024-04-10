package com.hm.appointment.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hm.appointment.model.DoctorPrescription;

@SpringBootTest
class DoctorPrescriptionServiceImplTest {
	
	@Autowired
	public DoctorPrescriptionService service;

	DoctorPrescription docPre1;
	
	@Test
	void testSavePrescription() {
		docPre1= new DoctorPrescription(10,1234L,1001,"Fiza Mariam","Fever","Take Dolo");
		service.savePrescription(docPre1);
	}

	@Test
	void testViewPresscriptionByUserId() {
		docPre1= new DoctorPrescription(10,1234L,1001,"Fiza Mariam","Fever","Take Dolo");
		service.savePrescription(docPre1);
		service.viewPresscriptionByUserId(10);
	}

}
