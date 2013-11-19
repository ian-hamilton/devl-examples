package com.inertia.solutions.scheduling;

import java.io.Console;
import java.util.concurrent.ExecutionException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class Launcher {

	private static final String SCHD_COUNT_INPUT = "\nRunning scheduler after context load (Control C to Quit)";
	private static final String QUIT = "Q";
	
	private Launcher() { }
	
	/*
	 * to execute using the console:
	 * mvn exec:java -Dexec.mainClass="com.inertia.solutions.scheduling.Launcher"
	 */
	public static void main(final String[] args) throws InterruptedException, ExecutionException {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
		
		Console console = System.console();
		String input = console.readLine(SCHD_COUNT_INPUT);
		while (!QUIT.equalsIgnoreCase(input)) {			
		}
		
		((AnnotationConfigApplicationContext) ctx).close();
	}
}
