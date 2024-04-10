package com.hm.appointment.model;

import java.sql.Array;
import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name="doctor_schedule")
public class DoctorSchedule {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int slotId;
	private LocalDate scheduleDate;
	@OneToMany(cascade = CascadeType.ALL)
	private List<TimeSlots> doctorSlots;
//	@ManyToOne(cascade = CascadeType.PERSIST)
	private Long doctorId;
	
//	private Doctor doctor;
	

}
