package com.inertia.solutions.spring.orm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inertia.solutions.spring.orm.bean.Item;
import com.inertia.solutions.spring.orm.bean.ShoppingCart;
import com.inertia.solutions.spring.orm.bean.ShoppingCartItem;
import com.inertia.solutions.spring.orm.dao.ItemDao;
import com.inertia.solutions.spring.orm.dao.ShoppingCartDao;
import com.inertia.solutions.spring.orm.dao.ShoppingCartItemDao;
import com.inertia.solutions.spring.orm.service.ShoppingCartService;

@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	ItemDao itemDao;
	
	@Autowired
	ShoppingCartDao shoppingCartDao;
	
	@Autowired
	ShoppingCartItemDao shoppingCartItemDao;
	
	@Override
	@Transactional
	public ShoppingCart startNewShoppingCart(String userName) {
		ShoppingCart cart = new ShoppingCart();
		cart.setUserName(userName);
		cart.setTotal(new Float(0));
		shoppingCartDao.save(cart);
		return shoppingCartDao.find(userName);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Item> getAllItems() {
		return new ArrayList<Item>(itemDao.findAll());
	}
	
	@Override
	@Transactional
	public void saveItem(Item item) {
		itemDao.save(item);
	}

	@Override
	@Transactional
	public ShoppingCart addItemToShoppingCart(String userName, Long itemId) {
		Item item = itemDao.find(itemId);
		
		ShoppingCart shoppingCart = getShoppingCart(userName);
		ShoppingCartItem cartItem = new ShoppingCartItem();
		cartItem.setItem(item);
		cartItem.setShoppingCart(shoppingCart);
		shoppingCartItemDao.save(cartItem);
		
		shoppingCart.getShoppingCartItems().add(cartItem);
		sumShoppingCartTotal(shoppingCart);
		shoppingCartDao.update(shoppingCart);
		
		return getShoppingCart(userName);
	}
	
	private void sumShoppingCartTotal(ShoppingCart shoppingCart) {
		Float total = new Float(0);
		for(ShoppingCartItem cartItem:shoppingCart.getShoppingCartItems()){
			total += cartItem.getItem().getItemPrice();
		}
		shoppingCart.setTotal(total);
	}
	
	@Override
	@Transactional(readOnly=true)
	public ShoppingCart getShoppingCart(String userName) {
		ShoppingCart shoppingCart = shoppingCartDao.find(userName);
		shoppingCart.getShoppingCartItems().size();
		return shoppingCart;
	}

}
