package com.inertia.solutions.spring.aop;

import java.io.Console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inertia.solutions.spring.aop.interaction.ConsoleCalculatorInteraction;
import com.inertia.solutions.spring.aop.interaction.impl.ConsoleCalculatorInteractionImpl;

public class Launcher {
	private static final String QUIT = "Q";

	/*
	 * to run this application in the console execute the following command at the project pom
	 * 
	 * mvn exec:java -Dexec.mainClass="com.inertia.solutions.spring.aop.Launcher"
	 */
	
	/**
	 * Main application execution, which spins up a 
	 * console dialag for the user.
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		ConsoleCalculatorInteraction consoleCalculatorInteraction = ctx.getBean(ConsoleCalculatorInteractionImpl.class);
		
		Console console = System.console();
		String input = console.readLine("Please enter calculation (Q to quit)");
		while (!QUIT.equalsIgnoreCase(input)) {	
			String result = new String();
			try {
				result = consoleCalculatorInteraction.interactWithCalculator(input);
			} catch(RuntimeException ex) {}
			console.format(result);
			input = console.readLine("\nPlease enter calculation (Q to quit)");
		}		
		
		((AnnotationConfigApplicationContext)ctx).close();
	}
	
}
