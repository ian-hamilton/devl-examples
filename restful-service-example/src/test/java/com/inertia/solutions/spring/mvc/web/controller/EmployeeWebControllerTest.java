package com.inertia.solutions.spring.mvc.web.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class EmployeeWebControllerTest {

	EmployeeWebController controllerUnderTest = new EmployeeWebController();
	
	@Test
	public void testGet() throws Exception {
		String result = controllerUnderTest.get();
		assertEquals("edit", result);
	}

}
