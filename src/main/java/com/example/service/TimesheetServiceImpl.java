package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.Leave;
import com.example.beans.Timesheet;
import com.example.exception.EmployeeNotFoundException;
import com.example.repository.TimesheetRepository;

@Service
public class TimesheetServiceImpl implements ITimesheetService{
	
	@Autowired
	TimesheetRepository dao;

	public List<Timesheet> getTimesheets()
	{
		
		return dao.getTimesheets();
	}
	
	public List<Timesheet> getTimesheet(int id) throws EmployeeNotFoundException
	{
		return dao.getTimesheet(id);
	}
	
	public Boolean addTimesheet(Timesheet timesheet) throws EmployeeNotFoundException
	{
		return dao.addTimesheet(timesheet);
	}
	
	public Boolean submitTimesheet(int id,Timesheet timesheet) throws EmployeeNotFoundException
	{
		return dao.submitTimesheet(id,timesheet);
	}
		
	public Boolean updateTimesheet(int id,String work_description,int hours, String tdate,Timesheet timesheet) throws EmployeeNotFoundException
	{
		return dao.updateTimesheet(id,work_description,hours,tdate,timesheet);
	}
	
	
}
