package com.inertia.solutions.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;

/**
 * 
 * Interface for aspect logging component
 *
 */
public interface LoggingAspect {

	public void logBefore(JoinPoint joinPoint);

	public void logAfter(JoinPoint joinPoint);

	public void logAfterThrowing(JoinPoint joinPoint, Throwable e);

	public void logBeforeAnnotation(JoinPoint joinPoint);

}