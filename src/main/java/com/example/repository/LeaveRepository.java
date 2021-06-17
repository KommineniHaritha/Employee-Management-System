package com.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.beans.Employee;
import com.example.beans.Leave;

import com.example.exception.EmployeeNotFoundException;
import com.example.query.Queries;

@Repository
public class LeaveRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Leave> getLeaves() {

		String sql = Queries.GET_LEAVES;
		return jdbcTemplate.query(sql, new RowMapper() {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Leave leave= new Leave();
				leave.setId(rs.getInt(1));
				leave.setLeave_description(rs.getString(2));
				leave.setFrom_date(rs.getString(3));
				leave.setTo_date(rs.getString(4));
				leave.setLeave_status(rs.getString(5));
				
				return leave;
			}
				
		});
	}
	
	public List<Leave> getLeave(int id) throws EmployeeNotFoundException {

		String sql= Queries.GET_LEAVE_BY_ID;
		try {
		return jdbcTemplate.query(sql, new RowMapper() {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Leave leave= new Leave();
				leave.setId(rs.getInt(1));
				leave.setLeave_description(rs.getString(2));
				leave.setFrom_date(rs.getString(3));
				leave.setTo_date(rs.getString(4));
				leave.setLeave_status(rs.getString(5));
				
				return leave;
			}
				
		},id);
		}
		catch( DataAccessException e)
		{
			throw new EmployeeNotFoundException ("Employee does not exist with this id");
		}
	}
	
	
	public Boolean addLeave(Leave leave) throws EmployeeNotFoundException {
		
		String sql=Queries.ADD_LEAVE;
		try {
			jdbcTemplate.update(sql,leave.getId(),leave.getLeave_description(),leave.getFrom_date(),leave.getTo_date(),leave.getLeave_status());
			return true;
		}
		catch(DataAccessException ex)
		{
			throw new EmployeeNotFoundException("Employee does not exist/Same data already exists");
		}
	}
	
	public Boolean applyLeave(int id,Leave leave) throws EmployeeNotFoundException {
		
		String sql=Queries.APPLY_LEAVE;
		try {
			jdbcTemplate.update(sql,id,leave.getLeave_description(),leave.getFrom_date(),leave.getTo_date(),leave.getLeave_status());
			return true;
		}
		catch(DataAccessException ex)
		{
			throw new EmployeeNotFoundException("Same data already exists");
		}
	}
	
	public Boolean updateLeave(int id,String leave_description,String from_date, String to_date,Leave leave) throws EmployeeNotFoundException {
	    String sql = Queries.UPDATE_LEAVE;
		int count=jdbcTemplate.update(sql,leave.getLeave_status(),id,leave_description,from_date,to_date);
		if(count==1)
			return true;
		else
			throw new EmployeeNotFoundException ("Employee id does not exist to update");
	}
	
	

}
