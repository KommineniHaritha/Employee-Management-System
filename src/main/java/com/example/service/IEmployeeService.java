package com.example.service;

import java.util.List;

import com.example.beans.Employee;
import com.example.exception.EmployeeNotFoundException;

public interface IEmployeeService {

	public List<Employee> getEmployees();

	public boolean validateLogin(Employee employee) throws EmployeeNotFoundException;

	public Employee getEmployee(int id) throws EmployeeNotFoundException;

	public Boolean addEmployee(Employee employee) throws EmployeeNotFoundException;

	public Object updateUser(int id, Employee employee) throws EmployeeNotFoundException;

	public Boolean deleteUser(int id) throws EmployeeNotFoundException;

	public Object updatePassword(int id, String password) throws EmployeeNotFoundException;


}
