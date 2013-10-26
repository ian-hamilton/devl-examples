package com.inertia.solutions.spring.mvc.app.calculator.command;

public interface CommandInvoker<T, R> {

	public R invoke(T in);
	
}
