package com.inertia.solutions.spring.aop.aspect.impl;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.inertia.solutions.spring.aop.aspect.LoggingAspect;

@Aspect
@Component
public class LoggingAspectImpl implements LoggingAspect {
	private static Logger log = Logger.getLogger(LoggingAspectImpl.class);

	@Override
	@Before("execution(* com.inertia.solutions.spring.aop.calculator..*(..))")
	@Order(0)
	public void logBefore(JoinPoint joinPoint) {
		log.info("The method " + joinPoint.getSignature().getName()
				+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
	}
	
	@Override
	@After("execution(* com.inertia.solutions.spring.aop.calculator..*(..))") 
	public void logAfter(JoinPoint joinPoint) { 
		log.info("The method " + joinPoint.getSignature().getName() + "() ends");
	}
	
	@Override
	@AfterThrowing(pointcut = "execution(* com.inertia.solutions.spring.aop.calculator..*(..))", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		log.error("An exception " + e + " has been thrown in " + joinPoint.getSignature().getName() + "()");
	}

	@Override
	@Before("@annotation(com.inertia.solutions.spring.aop.annotation.ExampleAnnotation)")
	@Order(1)
	public void logBeforeAnnotation(JoinPoint joinPoint) {
		log.info("The annotated method " + joinPoint.getSignature().getName()
				+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
	}

}
