package com.hm.patient.bookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PatientBookAppointmnetApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientBookAppointmnetApplication.class, args);
	}

}
