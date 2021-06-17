package com.example.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.beans.Leave;
import com.example.exception.EmployeeNotFoundException;
import com.example.repository.LeaveRepository;

@Service
public class LeaveServiceImpl implements ILeaveService{
	private static Logger Log=Logger.getLogger(LeaveServiceImpl.class.getName());

	@Autowired
	LeaveRepository dao;

	public List<Leave> getLeaves()
	{
		Log.info("Displaying all leaves");
		return dao.getLeaves();
	}

	public List<Leave> getLeave(int id) throws EmployeeNotFoundException
	{
		
		return dao.getLeave(id);
	}
	
	public Boolean addLeave(Leave leave) throws EmployeeNotFoundException
	{
		Log.info("Add leave method");
		return dao.addLeave(leave);
	}
	
	public Boolean applyLeave(int id,Leave leave) throws EmployeeNotFoundException
	{
		Log.info("Apply Leave method");
		return dao.applyLeave(id,leave);
	}
	
	public Boolean updateLeave(int id, String leave_description,String from_date, String to_date,Leave leave) throws EmployeeNotFoundException
	{
		return dao.updateLeave(id,leave_description,from_date,to_date,leave);
	}
	
	
}
