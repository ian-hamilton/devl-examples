package com.inertia.solutions.patterns.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;



public class EmployeeDisbursementContextTest {

	EmployeeDisbursementContext contextUnderTest = new EmployeeDisbursementContext();
	
	@Test
	public void shouldCalculateHourlyEmployee() throws Exception {
		Employee e = new HourlyEmployee("Ian Hamilton", "Programmer", new Double(20));
		Double result = contextUnderTest.calculateWeeklyDisbursment(e);
		assertNotNull(result);
		assertEquals(new Double(800), result);
	}
	
	@Test
	public void shouldCalculateWeeklySalary() throws Exception {
		Employee e = new SalariedEmployee("Sam Iam", "CEO", new Double(520000));
		Double result = contextUnderTest.calculateWeeklyDisbursment(e);
		assertEquals(new Double(10000), result);
	}

}
