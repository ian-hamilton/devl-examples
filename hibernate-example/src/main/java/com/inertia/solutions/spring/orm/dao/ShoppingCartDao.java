package com.inertia.solutions.spring.orm.dao;

import com.inertia.solutions.spring.orm.bean.ShoppingCart;

public interface ShoppingCartDao {

	void save(ShoppingCart shoppingCart);
	
	void update(ShoppingCart shoppingCart);
	
	ShoppingCart find(String userName);
}
