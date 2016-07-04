package com.mis.common;

public class HoursEmployee extends Employee
{
	private double wages;
	private int hours;
	
	public HoursEmployee(int id, String fname, String lname, double wages, int hours) 
	{
		super(id, fname, lname);
		this.setWages(wages);
		this.setHours(hours);
	}

	public void setWages(double wages)  {	this.wages = wages;	}
	public void setHours(int hours) 	{	this.hours = hours;	}

	public double getWages() {	return wages;	}
	public int getHours() 	 {	return hours;	}
	
}
