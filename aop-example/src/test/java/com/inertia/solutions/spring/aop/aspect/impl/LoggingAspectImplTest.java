package com.inertia.solutions.spring.aop.aspect.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoggingAspectImplTest {

	@Mock
	JoinPoint joinPoint;
	
	@Mock
	Signature signature;
	
	@InjectMocks
	LoggingAspectImpl loggingUnderTest;
	
	@Before
	public void setup() {
		Mockito.when(joinPoint.getSignature()).thenReturn(signature);
		Mockito.when(signature.getName()).thenReturn("mockName");
		Mockito.when(joinPoint.getArgs()).thenReturn(new Object[] { "mockArg" });
	}
	
	@Test
	public void testLogBefore() throws Exception {
		loggingUnderTest.logBefore(joinPoint);
	}

	@Test
	public void testLogAfter() throws Exception {
		loggingUnderTest.logAfter(joinPoint);
	}

	@Test
	public void testLogAfterThrowing() throws Exception {
		loggingUnderTest.logAfterThrowing(joinPoint, new Exception("test"));
	}

	@Test
	public void testLogBeforeAnnotation() throws Exception {
		loggingUnderTest.logBeforeAnnotation(joinPoint);
	}

}
