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

import com.example.beans.Employee;
import com.example.exception.EmployeeNotFoundException;
import com.example.service.IEmployeeService;


@CrossOrigin
@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService service;
	
	@RequestMapping("/listEmployees")
	public ResponseEntity<List<Employee>> listEmployees() 
	{
		List<Employee> empList = service.getEmployees();
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<String> validateLogin(@RequestBody Employee employee) throws EmployeeNotFoundException
	{
		if(service.validateLogin(employee))
		{
			return new ResponseEntity<String>("Valid Credentials, Employee logged in Successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Invalid Employee",HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/forgetPassword/{id}/{password}", method= RequestMethod.GET)
	public ResponseEntity<Object> updatePassword(@PathVariable int id,@PathVariable String password) throws EmployeeNotFoundException 
	{
	    return new ResponseEntity<>(service.updatePassword(id,password), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) throws EmployeeNotFoundException 
	{
		return new ResponseEntity<Employee>((service.getEmployee(id)),HttpStatus.OK);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleException(Exception ex)
	{
		return new ResponseEntity<Object> (ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addEmployee")
	public ResponseEntity<Boolean> addEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException 
	{
		return new ResponseEntity<Boolean>((service.addEmployee(employee)),HttpStatus.OK);
	}
	
    @PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable int id,@RequestBody Employee employee) throws EmployeeNotFoundException 
	{
	    return new ResponseEntity<>(service.updateUser(id,employee), HttpStatus.OK);
	}
	
	@RequestMapping(value= "/deleteEmployee/{id}", method= RequestMethod.GET)
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException 
	{
				
		return new ResponseEntity<Boolean> (service.deleteUser(id),HttpStatus.OK);
	}
}
