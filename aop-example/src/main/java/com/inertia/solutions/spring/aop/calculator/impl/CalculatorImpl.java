package com.inertia.solutions.spring.aop.calculator.impl;

import org.springframework.stereotype.Service;

import com.inertia.solutions.spring.aop.annotation.ExampleAnnotation;
import com.inertia.solutions.spring.aop.calculator.Calculator;

@Service
public class CalculatorImpl implements Calculator{

	@ExampleAnnotation
	public Integer add(Integer value1, Integer value2) {
		return value1 + value2;
	}

	@ExampleAnnotation
	public Integer subtract(Integer value1, Integer value2) {
		return value1 - value2;
	}

	@ExampleAnnotation
	public Integer multiply(Integer value1, Integer value2) {
		return value1 * value2;
	}

	@ExampleAnnotation
	public Integer divide(Integer value1, Integer value2) {
		return value1 / value2;
	}

}
