package com.caveofprogramming.spring.web.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(DataAccessException.class)
	// DataAccessException catches all database exceptions
	public String handleDatabaseException(DataAccessException ex) {
		ex.printStackTrace();
		return "error";
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	// DataAccessException catches all database exceptions
	public String handleAccessException(AccessDeniedException ex) {
		ex.printStackTrace();
		return "denied";
	}
}
