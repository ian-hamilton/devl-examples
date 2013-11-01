package com.inertia.solutions.spring.orm;

import java.io.Console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inertia.solutions.spring.orm.interaction.ConsoleShoppingCartInteractionInvoker;
import com.inertia.solutions.spring.orm.interaction.InteractionCommand;

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
		ConsoleShoppingCartInteractionInvoker invoker = ctx.getBean(ConsoleShoppingCartInteractionInvoker.class);
		
		Console console = System.console();
		String input = console.readLine("Please enter from menu (Q to quit)");
		while (!QUIT.equalsIgnoreCase(input)) {	
			String result = new String();
			try {
				InteractionCommand command = invoker.invoke(new Integer(input));
				String commandInput = console.readLine(command.getInteraction());
				result = command.execute(commandInput);
			} catch(RuntimeException ex) {}
			console.format(result);
			input = console.readLine("\nPlease enter from menu (Q to quit)");
		}		
		
		((AnnotationConfigApplicationContext)ctx).close();
	}
	
}
