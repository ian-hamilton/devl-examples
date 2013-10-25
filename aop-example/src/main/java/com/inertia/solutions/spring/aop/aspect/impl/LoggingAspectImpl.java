package com.inertia.solutions.spring.aop.aspect.impl;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.inertia.solutions.spring.aop.aspect.LoggingAspect;

@Aspect
@Component
public class LoggingAspectImpl implements LoggingAspect {
	private static Logger log = Logger.getLogger(LoggingAspectImpl.class);

	/* (non-Javadoc)
	 * @see com.inertia.solutions.spring.aop.aspect.LoggingAspectI#logBefore(org.aspectj.lang.JoinPoint)
	 */
	@Override
	@Before("execution(* com.inertia.solutions.spring.aop.calculator..*(..))")
	@Order(0)
	public void logBefore(JoinPoint joinPoint) {
		log.info("The method " + joinPoint.getSignature().getName()
				+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
	}
	
	/* (non-Javadoc)
	 * @see com.inertia.solutions.spring.aop.aspect.LoggingAspectI#logAfter(org.aspectj.lang.JoinPoint)
	 */
	@Override
	@After("execution(* com.inertia.solutions.spring.aop.calculator..*(..))") 
	public void logAfter(JoinPoint joinPoint) { 
		log.info("The method " + joinPoint.getSignature().getName() + "() ends");
	}
	
	@AfterThrowing(pointcut = "execution(* com.inertia.solutions.spring.aop.calculator..*(..))", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		log.error("An exception " + e + " has been thrown in " + joinPoint.getSignature().getName() + "()");
	}

	@Before("@annotation(com.inertia.solutions.spring.aop.annotation.ExampleAnnotation)")
	@Order(1)
	public void logBeforeAnnotation(JoinPoint joinPoint) {
		log.info("The annotated method " + joinPoint.getSignature().getName()
				+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
	}

}
