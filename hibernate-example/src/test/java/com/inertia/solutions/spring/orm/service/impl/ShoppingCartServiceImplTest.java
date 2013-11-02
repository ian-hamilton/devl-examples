package com.inertia.solutions.spring.orm.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.inertia.solutions.spring.orm.bean.Item;
import com.inertia.solutions.spring.orm.bean.ShoppingCart;
import com.inertia.solutions.spring.orm.bean.ShoppingCartItem;
import com.inertia.solutions.spring.orm.dao.ItemDao;
import com.inertia.solutions.spring.orm.dao.ShoppingCartDao;
import com.inertia.solutions.spring.orm.dao.ShoppingCartItemDao;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceImplTest {

	private static final String USER_NAME = "Ian";
	private static final Long ITEM_ID = new Long(101);
	
	@Mock
	ItemDao itemDao;
	
	@Mock
	ShoppingCartDao shoppingCartDao;
	
	@Mock
	ShoppingCartItemDao shoppingCartItemDao;
	
	@InjectMocks
	ShoppingCartServiceImpl serviceUnderTest;
	
	ShoppingCart shoppingCart;
	
	Item item;
	
	
	@Before
	public void setup() {
		shoppingCart = new ShoppingCart();
		shoppingCart.setShoppingCartItems(new HashSet<ShoppingCartItem>());
		
		List<Item> items = new ArrayList<Item>();
		item = new Item();
		item.setItemId(new Long(101));
		item.setItemName("itemName");
		item.setItemPrice(new Float(10.10));
		items.add(item);		
		
		Mockito.when(shoppingCartDao.find(USER_NAME)).thenReturn(shoppingCart);
		Mockito.when(itemDao.findAll()).thenReturn(items);
		Mockito.when(itemDao.find(ITEM_ID)).thenReturn(item);
	}

	@Test
	public void testStartNewShoppingCart() throws Exception {
		ArgumentCaptor<ShoppingCart> captor = ArgumentCaptor.forClass(ShoppingCart.class);
		
		ShoppingCart result = serviceUnderTest.startNewShoppingCart(USER_NAME);
		
		Mockito.verify(shoppingCartDao).save(captor.capture());
		assertEquals(USER_NAME, captor.getValue().getUserName());
		assertEquals(new Float(0), captor.getValue().getTotal());
		assertSame(shoppingCart, result);
	}

	@Test
	public void testGetAllItems() throws Exception {
		List<Item> result = serviceUnderTest.getAllItems();
		
		assertEquals(1, result.size());
		assertSame(item, result.get(0));
	}

	@Test
	public void testSaveItem() throws Exception {
		serviceUnderTest.saveItem(item);
		Mockito.verify(itemDao).save(item);
	}

	@Test
	public void testAddItemToShoppingCart() throws Exception {
		ArgumentCaptor<ShoppingCartItem> captor = ArgumentCaptor.forClass(ShoppingCartItem.class);
		ShoppingCart result = serviceUnderTest.addItemToShoppingCart(USER_NAME, ITEM_ID);
		Mockito.verify(shoppingCartItemDao).save(captor.capture());
		assertSame(shoppingCart, result);
		assertSame(item, captor.getValue().getItem());
		assertEquals(item.getItemPrice(), result.getTotal());
	}
}
