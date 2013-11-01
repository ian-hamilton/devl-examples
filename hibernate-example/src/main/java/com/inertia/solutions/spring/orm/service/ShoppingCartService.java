package com.inertia.solutions.spring.orm.service;

import com.inertia.solutions.spring.orm.bean.ShoppingCart;

public interface ShoppingCartService {

	public ShoppingCart startNewShoppingCart();
	
	public ShoppingCart getShoppingCart(String name);
	
}
