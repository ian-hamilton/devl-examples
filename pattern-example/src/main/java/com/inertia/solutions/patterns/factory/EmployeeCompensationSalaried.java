package com.inertia.solutions.patterns.factory;

public class EmployeeCompensationSalaried implements EmployeeCompensation {

	private final static Double YEARLY_WEEKS = new Double(52);
	
	@Override
	public Double calculateWeeklyPay(Double compensation) {
		return compensation / YEARLY_WEEKS;
	}

}
