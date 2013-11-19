package com.inertia.solutions.scheduling.task.impl;

import org.junit.Test;


public class ConfigurationBasedSchedulerImplTest {

	ConfigurationBasedSchedulerImpl underTest = new ConfigurationBasedSchedulerImpl();
	
	@Test
	public void testRunSchedule() throws Exception {
		underTest.runSchedule();
	}

}
