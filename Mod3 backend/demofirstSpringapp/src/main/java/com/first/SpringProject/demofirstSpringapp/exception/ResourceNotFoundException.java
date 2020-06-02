package com.first.SpringProject.demofirstSpringapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//handle error for pretty error handleing 
@ResponseStatus(value=HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends Exception {
	private static final long serialVersionUID =1L;
	
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	

}
