package com.inertia.solutions.spring.orm.interaction.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.inertia.solutions.spring.orm.bean.Item;
import com.inertia.solutions.spring.orm.service.ShoppingCartService;

@RunWith(MockitoJUnitRunner.class)
public class ListItemCommandTest {

	private static final String EXEC_STRING = "\nItem [itemId=101, itemName=itemName, itemPrice=10.1]";
	
	@Mock
	ShoppingCartService shoppingCartService;
	
	ListItemCommand commandUnderTest;
	
	@Before
	public void setup() {
		commandUnderTest = new ListItemCommand(shoppingCartService);
		
		List<Item> items = new ArrayList<Item>();
		Item item = new Item();
		item.setItemId(new Long(101));
		item.setItemName("itemName");
		item.setItemPrice(new Float(10.10));
		items.add(item);
		
		Mockito.when(shoppingCartService.getAllItems()).thenReturn(items);
	}

	@Test
	public void testGetInteraction() throws Exception {
		String result = commandUnderTest.getInteraction();
		assertNull(result);
	}

	@Test
	public void testExecute() throws Exception {
		String result = commandUnderTest.execute(null);
		assertEquals(EXEC_STRING, result);
	}
	
}
