package com.inertia.solutions.spring.mvc.web.model;

public class CalculationModel {

	private Integer value1;
	
	private Integer value2;
	
	private String operator;

	public Integer getValue1() {
		return value1;
	}

	public void setValue1(Integer value1) {
		this.value1 = value1;
	}

	public Integer getValue2() {
		return value2;
	}

	public void setValue2(Integer value2) {
		this.value2 = value2;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}	
}
