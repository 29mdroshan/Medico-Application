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

import com.hm.appointment.model.DoctorPrescription;
import com.hm.appointment.repository.DoctorPrescriptionRepository;

@ExtendWith(MockitoExtension.class)
class DoctorPrescriptionServiceImplUnitTest {

	@InjectMocks
	public DoctorPrescriptionServiceImpl service;
	
	@Mock
	public DoctorPrescriptionRepository repo;
	
	@Test
	void testSavePrescription() {
		DoctorPrescription docPre1= new DoctorPrescription(10,1234L,1001,"Fiza Mariam","Fever","Take Dolo");
		when(repo.save(docPre1)).thenReturn(docPre1);
		assertEquals(docPre1, service.savePrescription(docPre1));
	}

	@Test
	void testViewPresscriptionByUserId() {
		DoctorPrescription docPre1= new DoctorPrescription(10,1234L,1001,"Fiza Mariam","Fever","Take Dolo");
		when(repo.findById(1001)).thenReturn(Optional.of(docPre1));
		assertEquals(Optional.of(docPre1), service.viewPresscriptionByUserId(1001));
		
	}

}
