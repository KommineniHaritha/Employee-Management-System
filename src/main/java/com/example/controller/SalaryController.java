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
import com.example.beans.Salary;
import com.example.exception.EmployeeNotFoundException;
import com.example.service.ISalaryService;

@CrossOrigin
@RestController
public class SalaryController {

		@Autowired
		ISalaryService service;
		
		@RequestMapping("/listSalaries")
		public ResponseEntity<List<Salary>> listalaries() 
		{
			List<Salary> salList = service.getSalaries();
			return new ResponseEntity<List<Salary>>(salList,HttpStatus.OK);
		}
		
		@RequestMapping(value="/getSalary/{id}")
		public ResponseEntity<List<Salary>> displaySalary(@PathVariable int id) throws EmployeeNotFoundException 
		{
			return new ResponseEntity<List<Salary>>((service.getSalary(id)),HttpStatus.OK);
		}
		
		@RequestMapping(value="/getByMonth/{sal_month}")
		public ResponseEntity<List<Salary>> searchByMonth (@PathVariable String sal_month) throws EmployeeNotFoundException 
		{
			return new ResponseEntity<List<Salary>>((service.getByMonth(sal_month)),HttpStatus.OK);
		}
		
		@ExceptionHandler(EmployeeNotFoundException.class)
		public ResponseEntity<Object> handleException(Exception ex)
		{
			return new ResponseEntity<Object> (ex.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		@RequestMapping(method=RequestMethod.POST,value="/addSalary")
		public ResponseEntity<Boolean> addNewSalary(@RequestBody Salary salary) throws EmployeeNotFoundException 
		{
			return new ResponseEntity<Boolean>((service.addSalary(salary)),HttpStatus.OK);
		}
		
		@PutMapping("/updateSalary/{id}")
		public ResponseEntity<Object> updateUser(@PathVariable int id,@RequestBody Salary salary) throws EmployeeNotFoundException 
		{
		    return new ResponseEntity<>(service.updateUser(id,salary), HttpStatus.OK);
		}
		
		
	
}
