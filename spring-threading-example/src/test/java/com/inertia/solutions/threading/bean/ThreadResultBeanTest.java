package com.inertia.solutions.threading.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;



public class ThreadResultBeanTest {

	private static final Long SLEEP_TIME = new Long(1111);
	final Date BEFORE = new Date();	
	final Date AFTER = new Date();
	final Integer TASK_COUNT = new Integer(101);
	final Long THREAD_ID = new Long(1001);
	
	ThreadResultBean beanUnderTest = new ThreadResultBean();
	
	@Before
	public void setup() {
		beanUnderTest.setDateAfterExecution(AFTER);
		beanUnderTest.setDateBeforeExecution(BEFORE);
		beanUnderTest.setTaskCountId(TASK_COUNT);
		beanUnderTest.setThreadId(THREAD_ID);
		beanUnderTest.setSleepTime(SLEEP_TIME);
	}
	
	@Test
	public void testGetterSetter() {
		assertEquals(AFTER, beanUnderTest.getDateAfterExecution());
		assertEquals(BEFORE, beanUnderTest.getDateBeforeExecution());
		assertEquals(TASK_COUNT, beanUnderTest.getTaskCountId());
		assertEquals(THREAD_ID, beanUnderTest.getThreadId());
		assertEquals(SLEEP_TIME, beanUnderTest.getSleepTime());
	}
	
	@Test
	public void testToString() {
		String result = beanUnderTest.toString();
		assertNotNull(result);
	}
}
