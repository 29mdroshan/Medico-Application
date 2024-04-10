package com.hm.appointment.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hm.appointment.model.DoctorSchedule;
import com.hm.appointment.model.SlotsStatus;
import com.hm.appointment.model.TimeSlots;

@SpringBootTest
class DoctorScheduleserviceImplTest {
	
	@Autowired
	public DoctorScheduleService service;
	
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
		
		service.addSlot(docSch1);
	}

	@Test
	void testViewSlotById() {
		ts1= new TimeSlots(100,"10:23",SlotsStatus.SLOTBOOKED);
		ts2= new TimeSlots(101,"10:43",SlotsStatus.SLOTNOTBOOKED);
		
		listtimeslot1.add(ts1);
		listtimeslot1.add(ts2);
		
		docSch1=new DoctorSchedule(10,LocalDate.of(2023, 01, 01),listtimeslot1,10001L);
		
		service.addSlot(docSch1);
		service.viewSlotById(10);
		
	}

	@Test
	void testChangeSlotStatus() {
		ts1= new TimeSlots(100,"10:23",SlotsStatus.SLOTBOOKED);
		ts2= new TimeSlots(101,"10:43",SlotsStatus.SLOTNOTBOOKED);
		
		listtimeslot1.add(ts1);
		listtimeslot1.add(ts2);
		
		docSch1=new DoctorSchedule(10,LocalDate.of(2023, 01, 01),listtimeslot1,10001L);
		
		service.addSlot(docSch1);
		List<DoctorSchedule> sch= service.fetchAllSchedule(10001L);
		sch.set(1, docSch1).setDoctorSlots(docSch1.getDoctorSlots());
		
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
		service.fetchScheduleByIdAndDate(1001L,LocalDate.of(2023, 01, 01));
	}

}
