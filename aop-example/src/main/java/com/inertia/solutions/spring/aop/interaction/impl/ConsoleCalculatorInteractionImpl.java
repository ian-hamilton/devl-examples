package com.inertia.solutions.spring.aop.interaction.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inertia.solutions.spring.aop.calculator.Calculator;
import com.inertia.solutions.spring.aop.interaction.ConsoleCalculatorInteraction;

@Component
public class ConsoleCalculatorInteractionImpl implements ConsoleCalculatorInteraction {
	
	@Autowired
	Calculator calculator;

	@Override
	public String interactWithCalculator(String consoleInput) {
		String[] values = consoleInput.split("(?<=[-+*/])|(?=[-+*/])");//("[-+*/]");
		if(values == null || values.length != 3)
			throw new IllegalArgumentException("Values must only have two arguments and one operator");
		
		Integer value1 = new Integer(values[0]);
		Integer value2 = new Integer(values[2]);
		String operator = values[1];
		
		Integer result = null;
		if ("+".equals(operator))
			result = calculator.add(value1, value2);
		else if ("-".equals(operator))
			result = calculator.subtract(value1, value2);
		else if ("*".equals(operator))
			result = calculator.multiply(value1, value2);
		else if ("/".equals(operator))
			result = calculator.divide(value1, value2);
		else
			throw new IllegalArgumentException("Operator must be a valid mathmatical operator");
		
		return String.format("Calculation result = %s", result);
	}

}
