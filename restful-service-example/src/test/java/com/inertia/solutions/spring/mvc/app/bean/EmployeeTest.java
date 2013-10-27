package com.inertia.solutions.spring.mvc.app.bean;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class EmployeeTest {

	private static final String TITLE = "Title";
	private static final String SS = "123";
	private static final String LAST_NAME = "Iam";
	private static final String FIRST_NAME = "Sam";
	private static final Integer EMPLOYEE_ID = new Integer(101);
	Employee underTest;
	
	@Before
	public void setup() {
		underTest = new Employee();
		underTest.setEmployeeId(EMPLOYEE_ID);
		underTest.setFirstName(FIRST_NAME);
		underTest.setLastName(LAST_NAME);
		underTest.setSocialSecurity(SS);
		underTest.setTitle(TITLE);
	}
	
	@Test
	public void testGetterSetter() {
		assertEquals(EMPLOYEE_ID, underTest.getEmployeeId());
		assertEquals(FIRST_NAME, underTest.getFirstName());
		assertEquals(LAST_NAME, underTest.getLastName());
		assertEquals(SS, underTest.getSocialSecurity());
		assertEquals(TITLE, underTest.getTitle());
	}
	
}
