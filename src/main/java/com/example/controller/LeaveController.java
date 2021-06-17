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
import com.example.exception.EmployeeNotFoundException;
import com.example.service.ILeaveService;

	@CrossOrigin
	@RestController
	public class LeaveController {

		@Autowired
		ILeaveService service;
		
		@RequestMapping("/listLeaves")
		public ResponseEntity<List<Leave>> listLeaves() 
		{
			List<Leave> leaveList = service.getLeaves();
			return new ResponseEntity<List<Leave>>(leaveList,HttpStatus.OK);
		}
		
		@RequestMapping(value="/getLeave/{id}")
		public ResponseEntity<List<Leave>> getLeave(@PathVariable int id) throws EmployeeNotFoundException 
		{
			return new ResponseEntity<List<Leave>>((service.getLeave(id)),HttpStatus.OK);
		}
			
		@ExceptionHandler(EmployeeNotFoundException.class)
		public ResponseEntity<Object> handleException(Exception ex)
		{
			return new ResponseEntity<Object> (ex.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		@RequestMapping(method=RequestMethod.POST,value="/addLeave")
		public ResponseEntity<Boolean> addLeave(@RequestBody Leave leave) throws EmployeeNotFoundException 
		{
			return new ResponseEntity<Boolean>((service.addLeave(leave)),HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.POST,value="/applyLeave/{id}")
		public ResponseEntity<Boolean> applyLeave(@PathVariable int id,@RequestBody Leave leave) throws EmployeeNotFoundException 
		{
			return new ResponseEntity<Boolean>((service.applyLeave(id,leave)),HttpStatus.OK);
		}
		
		@PutMapping("/updateLeave/{id}/{leave_description}/{from_date}/{to_date}")
		public ResponseEntity<Object> updateLeave(@PathVariable int id,@PathVariable String leave_description,@PathVariable String from_date,@PathVariable String to_date,@RequestBody Leave leave) throws EmployeeNotFoundException 
		{
		    return new ResponseEntity<>(service.updateLeave(id,leave_description,from_date,to_date,leave), HttpStatus.OK);
		}
		
	}
