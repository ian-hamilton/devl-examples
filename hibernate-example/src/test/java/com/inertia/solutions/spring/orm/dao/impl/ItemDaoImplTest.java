package com.inertia.solutions.spring.orm.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.SimpleExpression;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.inertia.solutions.spring.orm.bean.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemDaoImplTest {

	private static final Long ITEM_ID = new Long(101);

	@Mock
	SessionFactory mockSessionFactory;
	
	@InjectMocks
	ItemDaoImpl daoUnderTest;
	
	@Mock
	Criteria mockCriteria;
	
	@Mock
	Session mockSession;
	
	@Mock
	List<Item> mockCollection;
	
	Item item = new Item();
	
	@Before
	public void setup() {
		Mockito.when(mockSessionFactory.getCurrentSession()).thenReturn(mockSession);
		Mockito.when(mockSession.createCriteria(Item.class)).thenReturn(mockCriteria);
		Mockito.when(mockCriteria.addOrder(Matchers.isA(Order.class))).thenReturn(mockCriteria);
		Mockito.when(mockCriteria.list()).thenReturn(mockCollection);
		Mockito.when(mockCriteria.add(Matchers.isA(SimpleExpression.class))).thenReturn(mockCriteria);
		Mockito.when(mockCriteria.uniqueResult()).thenReturn(item);
	}

	@Test
	public void testFindAll() throws Exception {
		Collection<Item> result = daoUnderTest.findAll();
		assertSame(mockCollection, result);
	}

	@Test
	public void testSave() throws Exception {
		daoUnderTest.save(item);
		
		Mockito.verify(mockSession).save(item);
	}

	@Test
	public void testFind() throws Exception {
		ArgumentCaptor<SimpleExpression> captor = ArgumentCaptor.forClass(SimpleExpression.class);
		
		Item result = daoUnderTest.find(ITEM_ID);
		
		Mockito.verify(mockCriteria).add(captor.capture());
		assertSame(item, result);
		assertEquals("itemId", captor.getValue().getPropertyName());
		assertEquals(ITEM_ID, captor.getValue().getValue());
	}
}
