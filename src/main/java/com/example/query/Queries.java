package com.example.query;

public class Queries {

	public static final String ADMIN_LOGIN= "select id,password from admin where id=? and password=?";
	
	public static final String EMPLOYEE_LOGIN="select id,password from employee where id=? and password=?";
	public static final String FORGOT_PASSWORD="update employee set password=? where id =?";
	public static final String GET_EMPLOYEES="select id,password,fname,lname,email,address,city,state,pincode,designation,phone from employee";
	public static final String GET_EMPLOYEE_BY_ID="select id,password,fname,lname,email,address,city,state,pincode,designation,phone from employee where id=?";
	public static final String ADD_EMPLOYEE="insert into employee values(?,?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_EMPLOYEE= "update employee set password=?,fname=?,lname=?,email=?,address=?,city=?,state=?,pincode=?,designation=?,phone=? where id =?";
	public static final String DELETE_EMPLOYEE="delete from employee where id=?";
	
	public static final String GET_LEAVES="select id,leave_description,from_date,to_date,leave_status from leaves";
	public static final String GET_LEAVE_BY_ID="select id,leave_description,from_date,to_date,leave_status from leaves where id=?";
	public static final String ADD_LEAVE="insert into leaves values(?,?,?,?,?)";
	public static final String UPDATE_LEAVE="update leaves set leave_status=? where id =? and leave_description=? and from_date=? and to_date=?";
	public static final String APPLY_LEAVE="insert into leaves values(?,?,?,?,?)";
	
	public static final String GET_SALARIES="select id,sal_month,sal_year,amount from salary";
	public static final String GET_SALARY_BY_ID="select id,sal_month,sal_year,amount from salary where id=?";
	public static final String GET_SALARY_BY_MONTH="select id,sal_month,sal_year,amount from salary where sal_month=?";
	public static final String ADD_SALARY="insert into salary values(?,?,?,?)";
	public static final String UPDATE_SALARY="update salary set sal_month=?,sal_year=?,amount=? where id =?";
	
	public static final String GET_TIMESHEETS="select id,work_description,hours,tdate,timesheet_status from timesheet";
	public static final String GET_TIMESHEET_BY_ID="select id,work_description,hours,tdate,timesheet_status from timesheet where id=?";
	public static final String ADD_TIMESHEET="insert into timesheet values(?,?,?,?,?)";
	public static final String UPDATE_TIMESHEET="update timesheet set timesheet_status=? where id =? and work_description=? and hours=? and tdate=?";
	public static final String SUBMIT_TIMESHEET="insert into timesheet values(?,?,?,?,?)";
	
}
