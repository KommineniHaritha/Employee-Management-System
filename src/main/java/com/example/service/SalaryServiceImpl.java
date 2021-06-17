package com.example.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.Leave;
import com.example.beans.Salary;
import com.example.exception.EmployeeNotFoundException;
import com.example.repository.SalaryRepository;

@Service
public class SalaryServiceImpl implements ISalaryService {
	private static Logger Log=Logger.getLogger(SalaryServiceImpl.class.getName());

		@Autowired
		SalaryRepository dao;

		public List<Salary> getSalaries()
		{
			Log.info("Display salary list");
			return dao.getSalaries();
		}
		
		public List<Salary> getSalary(int id) throws EmployeeNotFoundException
		{
			return dao.getSalary(id);
		}
		
		public List<Salary> getByMonth(String sal_month) throws EmployeeNotFoundException
		{
			return dao.getByMonth(sal_month);
		}
		
		public Boolean addSalary(Salary salary) throws EmployeeNotFoundException
		{
			return dao.addSalary(salary);
		}

		public Boolean updateUser(int id,Salary salary) throws EmployeeNotFoundException
		{
			return dao.updateUser(id,salary);
		}
		
}
