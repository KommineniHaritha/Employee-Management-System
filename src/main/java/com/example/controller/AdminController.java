package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Admin;
import com.example.exception.EmployeeNotFoundException;
import com.example.service.IAdminService;

@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	IAdminService service;
	
	@RequestMapping(value="/adminlogin", method=RequestMethod.POST)
	public ResponseEntity<String> validateAdminLogin(@RequestBody Admin admin) throws EmployeeNotFoundException
	{
		if(service.validateAdminLogin(admin))
		{
			return new ResponseEntity<String>("Valid Credentials, Admin logged in Successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Invalid Employee",HttpStatus.NOT_FOUND);
		}
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleException(Exception ex)
	{
		return new ResponseEntity<Object> (ex.getMessage(),HttpStatus.NOT_FOUND);
	}
}
