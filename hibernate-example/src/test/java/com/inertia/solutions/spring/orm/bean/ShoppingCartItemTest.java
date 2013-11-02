package com.inertia.solutions.spring.orm.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;


public class ShoppingCartItemTest {

	private static final Long SHOPPING_CART_ITEM_ID = new Long(101);
	private static final ShoppingCart SHOPPING_CART = new ShoppingCart();
	private static final Item ITEM = new Item();
	
	ShoppingCartItem underTest = new ShoppingCartItem();
	
	@Before
	public void setup() {
		underTest.setItem(ITEM);
		underTest.setShoppingCart(SHOPPING_CART);
		underTest.setShoppingCartItemId(SHOPPING_CART_ITEM_ID);
	}
	
	@Test
	public void testGetters() {
		assertEquals(SHOPPING_CART_ITEM_ID, underTest.getShoppingCartItemId());
		assertSame(ITEM, underTest.getItem());
		assertSame(SHOPPING_CART, underTest.getShoppingCart());
	}
}
