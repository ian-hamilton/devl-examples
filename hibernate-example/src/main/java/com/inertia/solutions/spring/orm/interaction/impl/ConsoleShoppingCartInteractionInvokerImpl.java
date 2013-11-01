package com.inertia.solutions.spring.orm.interaction.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inertia.solutions.spring.orm.interaction.ConsoleShoppingCartInteractionInvoker;
import com.inertia.solutions.spring.orm.interaction.InteractionCommand;
import com.inertia.solutions.spring.orm.service.ShoppingCartService;

@Component("invoker")
public class ConsoleShoppingCartInteractionInvokerImpl 
			implements ConsoleShoppingCartInteractionInvoker{

	Map<Integer, InteractionCommand> commandMap;
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@PostConstruct
	public void init() {
		commandMap = new HashMap<Integer, InteractionCommand>();
		commandMap.put(new Integer(1), new ListItemCommand(shoppingCartService));
		commandMap.put(new Integer(2), new NewShoppingCartCommand(shoppingCartService));
		commandMap.put(new Integer(3), new AddItemToCartCommand(shoppingCartService));
	}
	
	@Override
	public InteractionCommand invoke(Integer input) {
		return commandMap.get(input);
	}

}
