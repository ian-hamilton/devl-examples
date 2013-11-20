package com.inertia.solutions.patterns.strategy;

public class SalariedEmployee extends Employee {

	private static final Double YEARLY_WEEKS = new Double(52);
	
	public SalariedEmployee(String employeeName, String employeeTitle,
			Double compensation) {
		super(employeeName, employeeTitle, compensation);
	}

	@Override
	public Double calculateWeeklyPay() {
		return this.getCompensation() / YEARLY_WEEKS;
	}

}
