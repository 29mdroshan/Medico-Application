package com.project.Springemailgeneration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Springemailgeneration.model.EmailDetails;
import com.project.Springemailgeneration.service.EmailService;
import com.project.Springemailgeneration.service.EmailServiceImpl;

@RestController
//@CrossOrigin(origins= {"http://localhost:4200"})
public class EmailController {

	@Autowired 
	private EmailServiceImpl emailService;

	@PostMapping("/sendMail")
	public String sendMail(@RequestBody EmailDetails details)
	{
		String status = emailService.sendSimpleMail(details);
		return status;
	}
}

