package com.inertia.solutions.spring.rest.web.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.inertia.solutions.spring.rest.web.controller.EmployeeWebController;


public class EmployeeWebControllerTest {

	EmployeeWebController controllerUnderTest = new EmployeeWebController();
	
	@Test
	public void testGet() throws Exception {
		String result = controllerUnderTest.get();
		assertEquals("edit", result);
	}

}
