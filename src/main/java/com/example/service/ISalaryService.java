package com.example.service;

import java.util.List;

import com.example.beans.Salary;
import com.example.exception.EmployeeNotFoundException;

public interface ISalaryService {

	public List<Salary> getSalaries();

	public List<Salary> getSalary(int id) throws EmployeeNotFoundException;

	public Boolean addSalary(Salary salary) throws EmployeeNotFoundException;

	public Object updateUser(int id, Salary salary) throws EmployeeNotFoundException;

	public List<Salary> getByMonth(String sal_month) throws EmployeeNotFoundException;

}
