package com.inertia.solutions.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public interface LoggingAspect {

	public abstract void logBefore(JoinPoint joinPoint);

	public abstract void logAfter(JoinPoint joinPoint);

}