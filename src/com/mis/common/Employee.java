package com.mis.common;

public class Employee
{
	protected static int empId;
	protected static String empNameF;
	protected static String empNameL;
	// constructor
	// default value
	
	public Employee(int id, String fname, String lname)
	{
		empId = id;
		empNameF = fname;
		empNameL = lname;
	}
	
	// all the employee variables can be set but it will be stored on the tempArray storage
	public void setEmpID (int newId) 		  {	empId = newId;}
	public void setEmpNameF (String newNameF) {	empNameL = newNameF;}
	public void setEmpNameL (String newNameL) {	empNameL = newNameL;}
	// the ID and hrs paid will be write only
	// onle the admin can access this both variables
	public int getEmpId() 		{return empId;}
	public String getEmpNameF() { return empNameF; }
	public String getEmpNameL() { return empNameL; }
	
	// temp methods
	@Override
	
	public String toString()
	{
		return "ID#: " + getEmpId();
	}
}
