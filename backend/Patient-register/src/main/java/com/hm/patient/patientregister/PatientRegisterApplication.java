package com.hm.patient.patientregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PatientRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientRegisterApplication.class, args);
	}

}
