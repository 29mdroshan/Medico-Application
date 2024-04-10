package com.hm.patient.bookapp.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hm.patient.bookapp.dto.ErrorResponse;
import com.hm.patient.bookapp.exception.AppointmentByIdNotFound;

@RestControllerAdvice
public class ErrorController {
	
	@ExceptionHandler(value= {AppointmentByIdNotFound.class})
	public ResponseEntity<ErrorResponse> handleAppointmentByIdNotFound(Exception ex,HttpServletRequest request) {
		
		HttpStatus httpStatus= HttpStatus.NOT_FOUND;
		LocalDateTime timestamp=LocalDateTime.now();
		int status = httpStatus.value();
		String error =httpStatus.getReasonPhrase();
		String message=ex.getMessage();
		String path=request.getRequestURI();
		
		ErrorResponse body=new ErrorResponse(timestamp,status,error,message,path);
		return ResponseEntity.status(httpStatus).body(body);
		
	}
	
	
	

}
