package com.hm.patient.bookapp.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="book_appointment")
public class BookAppointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int appId;
	
	private int userId;
	
	private String userName;
	
	private String userEmail;
	
	private LocalDate appDate;
	
	private String appTime;
	
	private String userSymptoms;
	
	private long doctorId;
	
	private String doctorName;

}
