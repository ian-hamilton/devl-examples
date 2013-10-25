package com.inertia.solutions.spring.mvc.app.calculator.command;


public interface OperatorCommand {
	public Integer exec(Integer value1, Integer value2);
}
