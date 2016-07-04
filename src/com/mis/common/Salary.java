package com.mis.common;

public class Salary extends Employee 
{
	private double weeklyPaid;
	
	public Salary(int id, String fname, String lname, double weeklyPaid) 
	{
		super(id, fname, lname);
		this.weeklyPaid = weeklyPaid; 
	}
	
	// setter section s
	public void setWeeklyPaid(double weeklyPaid) {	this.weeklyPaid = weeklyPaid;	}
	
	public double getWeeklyPaid() {	return weeklyPaid;	}
	
	// temp method for the computation
	public void computeTotalPay()
	{
		// computation here
	}
	public void getDeduction()
	{
		// computation for the deduction
	}
	public void computeTotalDeduction()
	{
		// computation for the total deduction
	}	
}
