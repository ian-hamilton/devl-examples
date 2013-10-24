package com.inertia.solutions.spring.aop;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inertia.solutions.spring.aop.calculator.Calculator;

public class Launcher {
	private static Logger logger =  Logger.getLogger(Launcher.class);

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		Calculator calculator = ctx.getBean(Calculator.class);
		
		Integer result = calculator.add(5, 5);
		logger.info("result of 5 + 5 = " + result);
	}
	
}
