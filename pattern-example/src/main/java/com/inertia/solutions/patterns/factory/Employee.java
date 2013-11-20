package com.inertia.solutions.patterns.factory;

public class Employee {
	
	private String employeeName;
	
	private String employeeTitle;
	
	private Boolean isHourly;
	
	private Double compensation;
	
	public Employee(String employeeName, String employeeTitle, Double compensation, Boolean isHourly) {
		this.employeeName = employeeName;
		this.employeeTitle = employeeTitle;
		this.compensation = compensation;
		this.isHourly = isHourly;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}

	public String getEmployeeTitle() {
		return employeeTitle;
	}

	public Double getCompensation() {
		return compensation;
	}

	public Boolean getIsHourly() {
		return isHourly;
	}

}
