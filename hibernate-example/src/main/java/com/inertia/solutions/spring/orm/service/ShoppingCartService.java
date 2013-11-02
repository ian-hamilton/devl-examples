package com.inertia.solutions.spring.orm.service;

import java.util.List;

import com.inertia.solutions.spring.orm.bean.Item;
import com.inertia.solutions.spring.orm.bean.ShoppingCart;

public interface ShoppingCartService {

	ShoppingCart startNewShoppingCart(String userName);

	List<Item> getAllItems();

	void saveItem(Item item);

	ShoppingCart addItemToShoppingCart(String userName, Long itemId);

	ShoppingCart getShoppingCart(String userName);

}
