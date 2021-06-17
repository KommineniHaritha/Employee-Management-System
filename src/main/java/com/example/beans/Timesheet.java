package com.example.beans;

public class Timesheet {

	private int id;
	private String work_description;
	private int hours;
	private String tdate;
	private String timesheet_status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWork_description() {
		return work_description;
	}
	public void setWork_description(String work_description) {
		this.work_description = work_description;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	public String getTimesheet_status() {
		return timesheet_status;
	}
	public void setTimesheet_status(String timesheet_status) {
		this.timesheet_status = timesheet_status;
	}
	
	
}
