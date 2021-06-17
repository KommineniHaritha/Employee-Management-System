package com.example.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.beans.Employee;
import com.example.exception.EmployeeNotFoundException;

import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
private static Logger Log=Logger.getLogger(EmployeeServiceImpl.class.getName());
	@Autowired
	EmployeeRepository dao;
	
	public boolean validateLogin(Employee employee) throws EmployeeNotFoundException
	{
		Log.info("validateLogin method in service");
		return dao.validateLogin(employee);
	}
	
	public Boolean updatePassword(int id,String password) throws EmployeeNotFoundException
	{
		return dao.updatePassword(id,password);
	}
	
	public List<Employee> getEmployees()
	{
		Log.info("Get all employees");
		return dao.getEmployees();
	}

	public Employee getEmployee(int id) throws EmployeeNotFoundException
	{
		return dao.getEmployee(id);
	}
	
	public Boolean addEmployee(Employee employee) throws EmployeeNotFoundException
	{
		Log.info("Add employee method in service");
		return dao.addEmployee(employee);
	}
	
	public Boolean updateUser(int id,Employee employee) throws EmployeeNotFoundException
	{
		Log.info("Update employee method in service");
		return dao.updateUser(id,employee);
	}
	
	public Boolean deleteUser(int id) throws EmployeeNotFoundException
	{
		Log.info("Delete employee method in service");
		return dao.deleteUser(id);
	}
	
	
}
