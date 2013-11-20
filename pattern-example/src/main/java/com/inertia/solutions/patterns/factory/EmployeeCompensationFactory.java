package com.inertia.solutions.patterns.factory;

public class EmployeeCompensationFactory {

	public EmployeeCompensation create(Employee e) {
		if(e.getIsHourly())
			return new EmployeeCompensationHourly();
		else 
			return new EmployeeCompensationSalaried();
	}
	
}
