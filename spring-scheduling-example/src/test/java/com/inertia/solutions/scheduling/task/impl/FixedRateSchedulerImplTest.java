package com.inertia.solutions.scheduling.task.impl;

import org.junit.Test;


public class FixedRateSchedulerImplTest {

	FixedRateSchedulerImpl underTest = new FixedRateSchedulerImpl();
	
	@Test
	public void testRunSchedule() throws Exception {
		underTest.runSchedule();
	}

}
