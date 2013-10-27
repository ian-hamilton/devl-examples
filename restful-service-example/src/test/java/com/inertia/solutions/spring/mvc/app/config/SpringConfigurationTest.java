package com.inertia.solutions.spring.mvc.app.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.inertia.solutions.spring.mvc.app.bean.Employee;


public class SpringConfigurationTest {

	SpringConfiguration configUnderTest = new SpringConfiguration();
	
	@Test
	public void testGetEmployeeMemoryDatabase() throws Exception {
		Map<Integer, Employee> result = configUnderTest.getEmployeeMemoryDatabase();
		assertEquals(1, result.values().size());
		assertTrue(result.containsKey(new Integer(101)));
		assertNotNull(result.get(new Integer(101)));
	}

}
