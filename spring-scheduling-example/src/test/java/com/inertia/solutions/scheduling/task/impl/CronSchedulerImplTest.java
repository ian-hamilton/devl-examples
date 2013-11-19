package com.inertia.solutions.scheduling.task.impl;

import org.junit.Test;


public class CronSchedulerImplTest {
	CronSchedulerImpl underTest = new CronSchedulerImpl();

	@Test
	public void testRunSchedule() throws Exception {
		underTest.runSchedule();
	}

}
