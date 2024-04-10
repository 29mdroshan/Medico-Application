package com.hm.appointment.controller;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hm.appointment.Exception.DoctorDoesNotExist;
import com.hm.appointment.Exception.PrescriptionNotFound;
import com.hm.appointment.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ErrorController {
	@ExceptionHandler(value= {DoctorDoesNotExist.class})
	public ResponseEntity<ErrorResponse> handleDoctorDoesNotExist(Exception ex,HttpServletRequest request) {
		
		HttpStatus httpStatus= HttpStatus.NOT_FOUND;
		LocalDateTime timestamp=LocalDateTime.now();
		int status = httpStatus.value();
		String error =httpStatus.getReasonPhrase();
		String message=ex.getMessage();
		String path=request.getRequestURI();
		
		ErrorResponse body=new ErrorResponse(timestamp,status,error,message,path);
		return ResponseEntity.status(httpStatus).body(body);
		
	}
	
	@ExceptionHandler(value= {PrescriptionNotFound.class})
	public ResponseEntity<ErrorResponse> handlePrescriptionNotFound(Exception ex,HttpServletRequest request) {
		
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
