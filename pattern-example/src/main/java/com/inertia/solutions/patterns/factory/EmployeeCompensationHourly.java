package com.inertia.solutions.patterns.factory;

public class EmployeeCompensationHourly implements EmployeeCompensation {

	private final static Double WEEKLY_HOURS = new Double(40);
	
	@Override
	public Double calculateWeeklyPay(Double compensation) {
		return WEEKLY_HOURS * compensation;
	}

}
