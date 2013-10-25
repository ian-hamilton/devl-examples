package com.inertia.solutions.spring.mvc.app.calculator.command.impl;

import com.inertia.solutions.spring.mvc.app.calculator.Calculator;
import com.inertia.solutions.spring.mvc.app.calculator.command.OperatorCommand;

public class AddCommand implements OperatorCommand{

	private Calculator calculator;
	
	public AddCommand(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public Integer exec(Integer value1, Integer value2) {
		return calculator.add(value1, value2);
	}	
}
