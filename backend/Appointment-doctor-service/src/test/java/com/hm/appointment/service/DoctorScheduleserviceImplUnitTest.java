package com.hm.appointment.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hm.appointment.model.DoctorSchedule;
import com.hm.appointment.model.SlotsStatus;
import com.hm.appointment.model.TimeSlots;
import com.hm.appointment.repository.DoctorScheduleRepository;

@ExtendWith(MockitoExtension.class)
class DoctorScheduleserviceImplUnitTest {
	
	@InjectMocks
	public DoctorScheduleserviceImpl service;
	
	@Mock
	public DoctorScheduleRepository repo;
	
	DoctorSchedule docSch1;
	TimeSlots ts1,ts2;
	List<TimeSlots> listtimeslot1= new ArrayList<>();

	@Test
	void testAddSlot() {
		ts1= new TimeSlots(100,"10:23",SlotsStatus.SLOTBOOKED);
		ts2= new TimeSlots(101,"10:43",SlotsStatus.SLOTNOTBOOKED);
		
		listtimeslot1.add(ts1);
		listtimeslot1.add(ts2);
		
		docSch1=new DoctorSchedule(10,LocalDate.of(2023, 01, 01),listtimeslot1,10001L);
		
		when(repo.save(docSch1)).thenReturn(docSch1);
		assertEquals(docSch1, service.addSlot(docSch1));
	}

	@Test
	void testViewSlotById() {
		ts1= new TimeSlots(100,"10:23",SlotsStatus.SLOTBOOKED);
		ts2= new TimeSlots(101,"10:43",SlotsStatus.SLOTNOTBOOKED);
		
		listtimeslot1.add(ts1);
		listtimeslot1.add(ts2);
		
		docSch1=new DoctorSchedule(10,LocalDate.of(2023, 01, 01),listtimeslot1,10001L);
		service.viewSlotById(10);
		
	}

	@Test
	void testDeleteSlotById() {
		ts1= new TimeSlots(100,"10:23",SlotsStatus.SLOTBOOKED);
		ts2= new TimeSlots(101,"10:43",SlotsStatus.SLOTNOTBOOKED);
		
		listtimeslot1.add(ts1);
		listtimeslot1.add(ts2);
		
		docSch1=new DoctorSchedule(10,LocalDate.of(2023, 01, 01),listtimeslot1,10001L);
		service.addSlot(docSch1);
		service.deleteSlotById(10);
		
	}

	@Test
	void testFetchAllSchedule() {
		ts1= new TimeSlots(100,"10:23",SlotsStatus.SLOTBOOKED);
		ts2= new TimeSlots(101,"10:43",SlotsStatus.SLOTNOTBOOKED);
		
		listtimeslot1.add(ts1);
		listtimeslot1.add(ts2);
		
		docSch1=new DoctorSchedule(10,LocalDate.of(2023, 01, 01),listtimeslot1,10001L);
		service.addSlot(docSch1);
		
		service.fetchAllSchedule(10001L);
		
	}

	@Test
	void testFetchScheduleByIdAndDate() {
		ts1= new TimeSlots(100,"10:23",SlotsStatus.SLOTBOOKED);
		ts2= new TimeSlots(101,"10:43",SlotsStatus.SLOTNOTBOOKED);
		
		listtimeslot1.add(ts1);
		listtimeslot1.add(ts2);
		
		docSch1=new DoctorSchedule(10,LocalDate.of(2023, 01, 01),listtimeslot1,10001L);
		service.addSlot(docSch1);
		
		service.fetchScheduleByIdAndDate(10001L, LocalDate.of(2023, 01, 01));
		
	}

}
