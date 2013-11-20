package com.inertia.solutions.patterns.factory;

public class EmployeeCompensationContext {

	public Double calculateWeeklyDisbursment(Employee e) {
		EmployeeCompensationFactory factory = new EmployeeCompensationFactory();
		EmployeeCompensation compensation = factory.create(e);
		return compensation.calculateWeeklyPay(e.getCompensation());
	}
	
}
