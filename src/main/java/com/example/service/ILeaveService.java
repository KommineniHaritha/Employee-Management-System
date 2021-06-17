package com.example.service;

import java.util.List;

import com.example.beans.Leave;
import com.example.exception.EmployeeNotFoundException;

public interface ILeaveService {

	public List<Leave> getLeaves();

	public List<Leave> getLeave(int id) throws EmployeeNotFoundException;

	public Boolean addLeave(Leave leave) throws EmployeeNotFoundException;

	public Object updateLeave(int id,String leave_description, String from_date, String to_date, Leave leave) throws EmployeeNotFoundException;

	public Boolean applyLeave(int id, Leave leave) throws EmployeeNotFoundException;

	
}
