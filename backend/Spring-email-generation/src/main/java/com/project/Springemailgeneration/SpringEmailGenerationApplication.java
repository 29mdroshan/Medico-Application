package com.project.Springemailgeneration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringEmailGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailGenerationApplication.class, args);
	}

}
