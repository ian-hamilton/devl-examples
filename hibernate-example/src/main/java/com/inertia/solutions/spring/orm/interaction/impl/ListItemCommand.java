package com.inertia.solutions.spring.orm.interaction.impl;

import java.util.List;

import com.inertia.solutions.spring.orm.bean.Item;
import com.inertia.solutions.spring.orm.interaction.InteractionCommand;
import com.inertia.solutions.spring.orm.service.ShoppingCartService;

public class ListItemCommand implements InteractionCommand{

	ShoppingCartService shoppingCartService;	
	
	public ListItemCommand(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}
	
	@Override
	public String getInteraction() {
		return null;
	}

	@Override
	public String execute(String input) {
		List<Item> items = shoppingCartService.getAllItems();
		StringBuilder builder = new StringBuilder();
		for(Item item:items){
			builder.append("\n").append(item.toString());
		}
		return builder.toString();
	}

}
