package com.inertia.solutions.spring.orm.interaction.impl;

import com.inertia.solutions.spring.orm.bean.ShoppingCart;
import com.inertia.solutions.spring.orm.interaction.InteractionCommand;
import com.inertia.solutions.spring.orm.service.ShoppingCartService;

public class NewShoppingCartCommand implements InteractionCommand{

	ShoppingCartService shoppingCartService;
	
	public NewShoppingCartCommand(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}
	
	@Override
	public String getInteraction() {
		return "\nPlease Enter User Name: ";
	}

	@Override
	public String execute(String input) {
		ShoppingCart cart = shoppingCartService.startNewShoppingCart(input);
		return cart.toString();
		
	}

}
