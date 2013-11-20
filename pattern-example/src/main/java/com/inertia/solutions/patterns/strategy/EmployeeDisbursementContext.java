package com.inertia.solutions.patterns.strategy;

public class EmployeeDisbursementContext {

	public Double calculateWeeklyDisbursment(Employee employee) {
		return employee.calculateWeeklyPay();
	}
	
}
