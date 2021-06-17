package com.example.service;

import com.example.beans.Admin;
import com.example.exception.EmployeeNotFoundException;

public interface IAdminService {

	public boolean validateAdminLogin(Admin admin) throws EmployeeNotFoundException;
	
}
