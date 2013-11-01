package com.inertia.solutions.spring.orm;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringConfigurationTest {

	@Ignore("should ignore, this test is just to ensure context wire is working")
	@Test
	public void testLoadContext() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
	}
	
}
