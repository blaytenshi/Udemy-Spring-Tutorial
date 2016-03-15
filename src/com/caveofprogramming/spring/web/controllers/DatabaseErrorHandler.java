package com.caveofprogramming.spring.web.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DatabaseErrorHandler {
	
	@ExceptionHandler(DataAccessException.class)
	// DataAccessException catches all database exceptions
	public String handleDatabaseException(DataAccessException ex) {
		ex.printStackTrace();
		return "error";
	}
	
}
