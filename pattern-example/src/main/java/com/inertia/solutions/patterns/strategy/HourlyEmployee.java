package com.inertia.solutions.patterns.strategy;

public class HourlyEmployee extends Employee{

	private static final Double HOURS = new Double(40);
	
	public HourlyEmployee(String employeeName, String employeeTitle,
			Double compensation) {
		super(employeeName, employeeTitle, compensation);
	}

	@Override
	public Double calculateWeeklyPay() {
		return HOURS * this.getCompensation();
	}

}
