package com.inertia.solutions.spring.orm.interaction.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.inertia.solutions.spring.orm.bean.Item;
import com.inertia.solutions.spring.orm.bean.ShoppingCart;
import com.inertia.solutions.spring.orm.interaction.InteractionCommand;
import com.inertia.solutions.spring.orm.service.ShoppingCartService;

public class AddItemToCartCommand implements InteractionCommand{

	ShoppingCartService shoppingCartService;
	
	public AddItemToCartCommand(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}
	
	@Override
	public String getInteraction() {
		List<Item> items = shoppingCartService.getAllItems();
		StringBuilder builder = new StringBuilder("Add User Name, Then Select from the items below (Bob/1)");
		for(Item item:items){
			builder.append("\n").append(item.toString());
		}
		return builder.toString();
	}

	@Override
	public String execute(String input) {
		String[] splits = input.split("/");
		String userName = splits[0];
		String selection = splits[1];
		
		ShoppingCart cart = shoppingCartService.addItemToShoppingCart(userName, new Long(selection));
		return cart.toString();
	}

}
