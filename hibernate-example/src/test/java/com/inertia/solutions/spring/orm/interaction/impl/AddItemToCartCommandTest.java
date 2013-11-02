package com.inertia.solutions.spring.orm.interaction.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.inertia.solutions.spring.orm.bean.Item;
import com.inertia.solutions.spring.orm.bean.ShoppingCart;
import com.inertia.solutions.spring.orm.service.ShoppingCartService;

@RunWith(MockitoJUnitRunner.class)
public class AddItemToCartCommandTest {
	
	private static final String INTERACTION = "Add User Name, Then Select from the items below (Bob/1)"
										+ "\nItem [itemId=101, itemName=itemName, itemPrice=10.1]";
	
	private static final String EXEC_RESULT = "ShoppingCart [shoppingCartId=null, userName=null, total=null]Collection Size=0";
	
	private static final String INPUT = "Ian/3";
	
	@Mock
	ShoppingCartService shoppingCartService;
	
	AddItemToCartCommand commandUnderTest;
	
	ShoppingCart shoppingCart;
	
	@Before
	public void setup() {
		shoppingCart = new ShoppingCart();
		commandUnderTest = new AddItemToCartCommand(shoppingCartService);
		List<Item> items = new ArrayList<Item>();
		Item item = new Item();
		item.setItemId(new Long(101));
		item.setItemName("itemName");
		item.setItemPrice(new Float(10.10));
		items.add(item);
		
		Mockito.when(shoppingCartService.getAllItems()).thenReturn(items);
		Mockito.when(shoppingCartService.addItemToShoppingCart("Ian", new Long(3))).thenReturn(shoppingCart);
	}

	@Test
	public void testGetInteraction() throws Exception {
		String result = commandUnderTest.getInteraction();
		assertEquals(INTERACTION, result);
	}

	@Test
	public void testExecute() throws Exception {
		String result = commandUnderTest.execute(INPUT);
		assertEquals(EXEC_RESULT, result);
	}

}
