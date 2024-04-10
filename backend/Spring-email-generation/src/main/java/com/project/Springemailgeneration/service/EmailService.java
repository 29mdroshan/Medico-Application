package com.project.Springemailgeneration.service;

import com.project.Springemailgeneration.model.EmailDetails;

public interface EmailService {
	String sendSimpleMail(EmailDetails details);

}
