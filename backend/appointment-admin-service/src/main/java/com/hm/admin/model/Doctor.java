package com.hm.admin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="temporary_doctor")
public class Doctor {
	
	private String doctorName;
	private String doctorEmail;
	private String doctorGender;
	private int doctorAge;
	@Id
	private Long doctorPhone;
	private String doctorAddress;
	private String doctorQualification;
	private String doctorSpeciality;
	private String doctorUsername;
	private String doctorPassword;
	private String doctorImage;

}
