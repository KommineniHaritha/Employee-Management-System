package com.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.beans.Leave;
import com.example.beans.Salary;
import com.example.exception.EmployeeNotFoundException;
import com.example.query.Queries;

@Repository
public class SalaryRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Salary> getSalaries() {

		String sql = Queries.GET_SALARIES;
		return jdbcTemplate.query(sql, new RowMapper() {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Salary salary = new Salary();
				salary.setId(rs.getInt(1));
				salary.setSal_month(rs.getString(2));
				salary.setSal_year(rs.getInt(3));
				salary.setAmount(rs.getInt(4));
				
				return salary;
			}
				
		});
	}
	
	public List<Salary> getSalary(int id) throws EmployeeNotFoundException {
		
		String sql = Queries.GET_SALARY_BY_ID;
		try {
		return jdbcTemplate.query(sql, new RowMapper() {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Salary salary = new Salary();
				salary.setId(rs.getInt(1));
				salary.setSal_month(rs.getString(2));
				salary.setSal_year(rs.getInt(3));
				salary.setAmount(rs.getInt(4));
				
				return salary;
			}
				
		},id);
		}
		catch( DataAccessException e)
		{
			throw new EmployeeNotFoundException ("Employee does not exist with this id");
		}
	}
	
	public List<Salary> getByMonth(String sal_month) throws EmployeeNotFoundException {
		
		String sql = Queries.GET_SALARY_BY_MONTH;
		try {
		return jdbcTemplate.query(sql, new RowMapper() {

		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
				Salary salary = new Salary();
				salary.setId(rs.getInt(1));
				salary.setSal_month(rs.getString(2));
				salary.setSal_year(rs.getInt(3));
				salary.setAmount(rs.getInt(4));
				
				return salary;
			}
				
		},sal_month);
		}
		catch( DataAccessException e)
		{
			throw new EmployeeNotFoundException ("Employee does not exist with this id");
		}
	}
	
	public Boolean addSalary(Salary salary) throws EmployeeNotFoundException {
		
		String sql=Queries.ADD_SALARY;
		try {
			jdbcTemplate.update(sql,salary.getId(),salary.getSal_month(),salary.getSal_year(),salary.getAmount());
			return true;
		}
		catch(DataAccessException ex)
		{
			throw new EmployeeNotFoundException("Employee does not exist/Same data already exists");
		}
	}
	
	public Boolean updateUser(int id,Salary salary) throws EmployeeNotFoundException {
	    String sql = Queries.UPDATE_SALARY;
		int count=jdbcTemplate.update(sql,salary.getSal_month(),salary.getSal_year(),salary.getAmount(),id);
		if(count==1)
			return true;
		else
			throw new EmployeeNotFoundException ("Employee id does not exist to update");
	}

}
