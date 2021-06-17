package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Leave;
import com.example.beans.Timesheet;
import com.example.exception.EmployeeNotFoundException;
import com.example.service.ITimesheetService;

@CrossOrigin
@RestController
public class TimesheetController {

	@Autowired
	ITimesheetService service;
	
	@RequestMapping("/listTimesheets")
	public ResponseEntity<List<Timesheet>> displayAllTimesheets() 
	{
		List<Timesheet> timeList = service.getTimesheets();
		return new ResponseEntity<List<Timesheet>>(timeList,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getTimesheet/{id}")
	public ResponseEntity<List<Timesheet>> displayTimesheet(@PathVariable int id) throws EmployeeNotFoundException 
	{
		return new ResponseEntity<List<Timesheet>>((service.getTimesheet(id)),HttpStatus.OK);
	}
		
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleException(Exception ex)
	{
		return new ResponseEntity<Object> (ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/submitTimesheet/{id}")
	public ResponseEntity<Boolean> submitTimesheet(@PathVariable int id,@RequestBody Timesheet timesheet) throws EmployeeNotFoundException 
	{
		return new ResponseEntity<Boolean>((service.submitTimesheet(id,timesheet)),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addTimesheet")
	public ResponseEntity<Boolean> addTimesheet(@RequestBody Timesheet timesheet) throws EmployeeNotFoundException 
	{
		return new ResponseEntity<Boolean>((service.addTimesheet(timesheet)),HttpStatus.OK);
	}
	
	@PutMapping("/updateTimesheet/{id}/{work_description}/{hours}/{tdate}")
	public ResponseEntity<Object> updateTimesheet(@PathVariable int id,@PathVariable String work_description,@PathVariable int hours,@PathVariable String tdate,@RequestBody Timesheet timesheet) throws EmployeeNotFoundException 
	{
	    return new ResponseEntity<>(service.updateTimesheet(id,work_description,hours,tdate,timesheet), HttpStatus.OK);
	}
	
}
