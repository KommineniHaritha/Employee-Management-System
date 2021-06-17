package com.example;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.EmployeeServiceImpl;

@SpringBootApplication
public class EmsProjectApplication {
	private static Logger Log=Logger.getLogger(EmployeeServiceImpl.class.getName());

	public static void main(String[] args) {
		 BasicConfigurator.configure(); 
		SpringApplication.run(EmsProjectApplication.class, args);
	}

}
