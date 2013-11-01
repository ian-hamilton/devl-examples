package com.inertia.solutions.spring.orm;

import java.io.Console;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inertia.solutions.spring.orm.bean.Item;
import com.inertia.solutions.spring.orm.interaction.ConsoleShoppingCartInteractionInvoker;
import com.inertia.solutions.spring.orm.interaction.InteractionCommand;
import com.inertia.solutions.spring.orm.service.ShoppingCartService;

public class Launcher {
	private static Logger log = Logger.getLogger(Launcher.class);
	
	private static final String MENU = "\nPlease enter from menu (Q to quit)"
			 + "\n 1. List Items "
			 + "\n 2. Start New Shopping Cart "
			 + "\n 3. Added Item to Cart ";
	private static final String QUIT = "Q";

	/*
	 * to run this application in the console execute the following command at the project pom
	 * 
	 * mvn exec:java -Dexec.mainClass="com.inertia.solutions.spring.orm.Launcher"
	 */
	
	/**
	 * Main application execution, which spins up a 
	 * console dialag for the user.
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		ConsoleShoppingCartInteractionInvoker invoker = (ConsoleShoppingCartInteractionInvoker) ctx.getBean("invoker");
		ShoppingCartService shoppingCartService = ctx.getBean(ShoppingCartService.class);
		seedItems(shoppingCartService);
		
		Console console = System.console();
		String input = console.readLine(MENU);
		while (!QUIT.equalsIgnoreCase(input)) {	
			String result = new String();
			try {
				InteractionCommand command = invoker.invoke(new Integer(input));
				String interaction = command.getInteraction();
				String commandInput = null; 
				if(interaction != null)
					commandInput = console.readLine(interaction);
				result = command.execute(commandInput);
			} catch(RuntimeException ex) {
				log.error("error during selection", ex);
			}
			console.format(result);
			input = console.readLine(MENU);
		}		
		
		((AnnotationConfigApplicationContext)ctx).close();
	}
	
	public static void seedItems(ShoppingCartService shoppingCartService) {
		Item item = new Item();
		item.setItemName("Item-3");
		item.setItemPrice(new Float(1.50));
		shoppingCartService.saveItem(item);
		
		item = new Item();
		item.setItemName("Item-1");
		item.setItemPrice(new Float(2.10));
		shoppingCartService.saveItem(item);
		
		item = new Item();
		item.setItemName("Item-2");
		item.setItemPrice(new Float(13.10));
		shoppingCartService.saveItem(item);
	}
}
