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

	/**
	 * This method is called a joinpoint of any method called in the
	 * Calculator class, then just calls out the method signature.
	 * This has an @Order annotation because the logBeforeAnnotation is also
	 * performing a @Before so both will fire.
	 */
	@Override
	@Before("execution(* com.inertia.solutions.spring.aop.calculator..*(..))")
	@Order(0)
	public void logBefore(JoinPoint joinPoint) {
		log.info("The method " + joinPoint.getSignature().getName()
				+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
	}
	
	/**
	 * This method is called during the joinpoint of any method exiting in the 
	 * Calculator class, and logs out method signature.
	 */
	@Override
	@After("execution(* com.inertia.solutions.spring.aop.calculator..*(..))") 
	public void logAfter(JoinPoint joinPoint) { 
		log.info("The method " + joinPoint.getSignature().getName() + "() ends");
	}
	
	/**
	 * This method is called when any Calculator method throws an exception
	 * and then logs basic information about the session.
	 */
	@Override
	@AfterThrowing(pointcut = "execution(* com.inertia.solutions.spring.aop.calculator..*(..))", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		log.error("An exception " + e + " has been thrown in " + joinPoint.getSignature().getName() + "()");
	}

	/**
	 * This method is called at any joinpoint that is decorated with the 
	 * @ExampleAnnotation annotation. This is ordered because there is more than
	 * one @Before method in this aspect.
	 */
	@Override
	@Before("@annotation(com.inertia.solutions.spring.aop.annotation.ExampleAnnotation)")
	@Order(1)
	public void logBeforeAnnotation(JoinPoint joinPoint) {
		log.info("The annotated method " + joinPoint.getSignature().getName()
				+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
	}

}
