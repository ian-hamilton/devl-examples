package com.inertia.solutions.patterns.strategy;

public abstract class Employee {
	
	private String employeeName;
	
	private String employeeTitle;
	
	private Double compensation;
	
	public Employee(String employeeName, String employeeTitle, Double compensation) {
		this.employeeName = employeeName;
		this.employeeTitle = employeeTitle;
		this.compensation = compensation;
	}
	
	public abstract Double calculateWeeklyPay();

	public String getEmployeeName() {
		return employeeName;
	}

	public String getEmployeeTitle() {
		return employeeTitle;
	}

	public Double getCompensation() {
		return compensation;
	}
	
	
}
