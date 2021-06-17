package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.Admin;
import com.example.exception.EmployeeNotFoundException;
import com.example.repository.AdminRepository;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	AdminRepository dao;
	
	public boolean validateAdminLogin(Admin admin) throws EmployeeNotFoundException
	{
		return dao.validateAdminLogin(admin);
	}
}
