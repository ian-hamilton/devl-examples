package com.inertia.solutions.patterns.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class EmployeeCompensationContextTest {

	EmployeeCompensationContext contextUnderTest = new EmployeeCompensationContext();
	
	@Test
	public void shouldReturnHourlyCompensation() throws Exception {
		Employee e = new Employee("Ian", "Programmer", new Double(20), true);
		Double result = contextUnderTest.calculateWeeklyDisbursment(e);
		assertEquals(new Double(800), result);
	}

	@Test
	public void shouldReturnSalariedCompensation() throws Exception {
		Employee e = new Employee("Ian", "CEO", new Double(520000), false);
		Double result = contextUnderTest.calculateWeeklyDisbursment(e);
		assertEquals(new Double(10000), result);
	}
}
