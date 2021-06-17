package com.example.service;

import java.util.List;

import com.example.beans.Timesheet;
import com.example.exception.EmployeeNotFoundException;

public interface ITimesheetService {

	public List<Timesheet> getTimesheets();

	public List<Timesheet> getTimesheet(int id) throws EmployeeNotFoundException;

	public Boolean addTimesheet(Timesheet timesheet)throws EmployeeNotFoundException;

	public Boolean submitTimesheet(int id,Timesheet timesheet) throws EmployeeNotFoundException;

	public Object updateTimesheet(int id, String work_description, int hours, String tdate, Timesheet timesheet) throws EmployeeNotFoundException;

}
