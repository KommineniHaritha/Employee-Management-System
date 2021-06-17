package com.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.beans.Leave;
import com.example.beans.Timesheet;
import com.example.exception.EmployeeNotFoundException;
import com.example.query.Queries;

@Repository
public class TimesheetRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Timesheet> getTimesheets() {

		String sql = Queries.GET_TIMESHEETS;
		return jdbcTemplate.query(sql, new RowMapper() {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Timesheet timesheet= new Timesheet();
				timesheet.setId(rs.getInt(1));
				timesheet.setWork_description(rs.getString(2));
				timesheet.setHours(rs.getInt(3));
				timesheet.setTdate(rs.getString(4));
				timesheet.setTimesheet_status(rs.getString(5));
				
				return timesheet;
			}
				
		});
	}
	
	public List<Timesheet> getTimesheet(int id) throws EmployeeNotFoundException {

		String sql =Queries.GET_TIMESHEET_BY_ID;
		try {
		return jdbcTemplate.query(sql, new RowMapper() {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
		Timesheet timesheet= new Timesheet();
		timesheet.setId(rs.getInt(1));
		timesheet.setWork_description(rs.getString(2));
		timesheet.setHours(rs.getInt(3));
		timesheet.setTdate(rs.getString(4));
		timesheet.setTimesheet_status(rs.getString(5));
		
		return timesheet;
			}
				
		},id);
		}
		catch( DataAccessException e)
		{
			throw new EmployeeNotFoundException ("Employee does not exist with this id");
		}
	}
	
	
	public Boolean addTimesheet(Timesheet timesheet) throws EmployeeNotFoundException {
		
		String sql=Queries.ADD_TIMESHEET;
		try {
			jdbcTemplate.update(sql,timesheet.getId(),timesheet.getWork_description(),timesheet.getHours(),timesheet.getTdate(),timesheet.getTimesheet_status());
			return true;
		}
		catch(DataAccessException ex)
		{
			throw new EmployeeNotFoundException("Employee does not exist/Same data already exists");
		}
	}
	
	public Boolean submitTimesheet(int id,Timesheet timesheet) throws EmployeeNotFoundException {
		
		String sql=Queries.SUBMIT_TIMESHEET;
		try {
			jdbcTemplate.update(sql,id,timesheet.getWork_description(),timesheet.getHours(),timesheet.getTdate(),timesheet.getTimesheet_status());
			return true;
		}
		catch(DataAccessException ex)
		{
			throw new EmployeeNotFoundException("Same data already exists");
		}
	}
	
	public Boolean updateTimesheet(int id,String work_description,int hours,String tdate,Timesheet timesheet) throws EmployeeNotFoundException {
	    String sql = Queries.UPDATE_TIMESHEET;
		int count=jdbcTemplate.update(sql,timesheet.getTimesheet_status(),id,work_description,hours,tdate);
		if(count==1)
			return true;
		else
			throw new EmployeeNotFoundException ("Employee id does not exist to update");
	}
	
	
}
