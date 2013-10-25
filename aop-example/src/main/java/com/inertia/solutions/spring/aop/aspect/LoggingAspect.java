package com.inertia.solutions.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;

public interface LoggingAspect {

	public abstract void logBefore(JoinPoint joinPoint);

	public abstract void logAfter(JoinPoint joinPoint);

	void logAfterThrowing(JoinPoint joinPoint, Throwable e);

	void logBeforeAnnotation(JoinPoint joinPoint);

}