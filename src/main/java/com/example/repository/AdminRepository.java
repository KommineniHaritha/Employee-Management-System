package com.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.beans.Admin;
import com.example.exception.EmployeeNotFoundException;
import com.example.query.Queries;

@Repository
public class AdminRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean validateAdminLogin(Admin admin) throws EmployeeNotFoundException
	{
		String sql=Queries.ADMIN_LOGIN;
		try {
			Admin user1=(Admin) jdbcTemplate.queryForObject(sql,new RowMapper() {

				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							
							Admin admin = new Admin();
							admin.setId(rs.getInt(1));
							admin.setPassword(rs.getString(2));
							
							return admin;
						}
			},admin.getId(),admin.getPassword());
			
			return true;
		}
		catch(DataAccessException ex)
		{
			throw new EmployeeNotFoundException("Invalid Login Credentials");
		}
	}
}
