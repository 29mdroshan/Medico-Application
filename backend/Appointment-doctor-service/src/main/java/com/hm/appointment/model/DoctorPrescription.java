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
@NoArgsConstructor
@Entity
@Table(name="doctor_prescription")
public class DoctorPrescription {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Long doctorId;
	private int userId;
	private String userName;
	private String disease;
	
	private String prescription;
	
}
