package com.healthcare.controller;



import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.healthcare.exceptions.ExceptionResponse;



@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse>Exception(Exception e,WebRequest webr){
    	
    	ExceptionResponse exceptionResponse=new ExceptionResponse();
    	exceptionResponse.setDescription(webr.getDescription(false));
    	exceptionResponse.setLocalDateTime(LocalDateTime.now());
    	exceptionResponse.setMessage(e.getMessage());
    	return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
		
		
		
	}
 
}
