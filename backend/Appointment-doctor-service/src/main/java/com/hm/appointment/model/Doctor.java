package com.hm.appointment.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name="doctor_information")
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long doctorId;
	private String doctorName;
	private String doctorEmail;
	private String doctorGender;
	private int doctorAge;
	private Long doctorPhone;
	private String doctorAddress;
	private String doctorQualification;
	private String doctorSpeciality;
	private String doctorUsername;
	private String doctorPassword;
	private String doctorImage;
}
