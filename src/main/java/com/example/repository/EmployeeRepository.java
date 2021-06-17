package com.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.beans.Admin;
import com.example.beans.Employee;

import com.example.exception.EmployeeNotFoundException;
import com.example.query.Queries;

@Repository
public class EmployeeRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean validateLogin(Employee employee) throws EmployeeNotFoundException
	{
		String sql=Queries.EMPLOYEE_LOGIN;
		try {
			Employee user1=(Employee) jdbcTemplate.queryForObject(sql,new RowMapper() {

				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						
							Employee employee = new Employee();
							employee.setId(rs.getInt(1));
							employee.setPassword(rs.getString(2));
							
							return employee;
						}
			},employee.getId(),employee.getPassword());
			
			return true;
		}
		catch(DataAccessException ex)
		{
			throw new EmployeeNotFoundException("Invalid Credentials");
		}
	}
	
	public Boolean updatePassword(int id,String password) throws EmployeeNotFoundException {
		
	    String sql = Queries.FORGOT_PASSWORD;
		int count=jdbcTemplate.update(sql,password,id);
		if(count==1)
			return true;
		else
			throw new EmployeeNotFoundException ("Employee id does not exist to update password");
	}
		
	public List<Employee> getEmployees() {

		String sql =Queries.GET_EMPLOYEES;
		return jdbcTemplate.query(sql, new RowMapper() {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setPassword(rs.getString(2));
				employee.setFname(rs.getString(3));
				employee.setLname(rs.getString(4));
				employee.setEmail(rs.getString(5));
				employee.setAddress(rs.getString(6));
				employee.setCity(rs.getString(7));
				employee.setState(rs.getString(8));
				employee.setPincode(rs.getInt(9));
				employee.setDesignation(rs.getString(10));
				employee.setPhone(rs.getString(11));
				return employee;
			}
				
		});
	}

	public Employee getEmployee(int id) throws EmployeeNotFoundException {

		String sql = Queries.GET_EMPLOYEE_BY_ID;
		Employee employee;
		try
		{
			employee= (Employee) jdbcTemplate.queryForObject(sql, new RowMapper() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setPassword(rs.getString(2));
				employee.setFname(rs.getString(3));
				employee.setLname(rs.getString(4));
				employee.setEmail(rs.getString(5));
				employee.setAddress(rs.getString(6));
				employee.setCity(rs.getString(7));
				employee.setState(rs.getString(8));
				employee.setPincode(rs.getInt(9));
				employee.setDesignation(rs.getString(10));
				employee.setPhone(rs.getString(11));
				return employee;
					}
						
				},id);
		}
		catch( DataAccessException e)
		{
			throw new EmployeeNotFoundException ("Employee does not exist with this id");
		}
		return employee;
	}
	
	public Boolean addEmployee(Employee employee) throws EmployeeNotFoundException {
		
		String sql=Queries.ADD_EMPLOYEE;
		try {
			jdbcTemplate.update(sql,employee.getId(),employee.getPassword(),employee.getFname(),employee.getLname(),employee.getEmail(),
					employee.getAddress(),employee.getCity(),employee.getState(),employee.getPincode(),employee.getDesignation(),employee.getPhone());
			return true;
		}
		catch(DataAccessException ex)
		{
			throw new EmployeeNotFoundException("Employee already exists with this id");
		}
	}
	
	public Boolean updateUser(int id,Employee employee) throws EmployeeNotFoundException {
		
	    String sql = Queries.UPDATE_EMPLOYEE;
		int count=jdbcTemplate.update(sql,employee.getPassword(),employee.getFname(),employee.getLname(),employee.getEmail(),
				employee.getAddress(),employee.getCity(),employee.getState(),employee.getPincode(),employee.getDesignation(),employee.getPhone(),id);
		if(count==1)
			return true;
		else
			throw new EmployeeNotFoundException ("Employee id does not exist to update");
	}
	
		
	public Boolean deleteUser(int id) throws EmployeeNotFoundException {
	
		String sql=Queries.DELETE_EMPLOYEE;
		int count=jdbcTemplate.update(sql,id);
		if(count==1)
			return true;
		else
			throw new EmployeeNotFoundException("Employee id does not exist to delete");
		
	}

}
