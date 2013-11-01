package com.inertia.solutions.spring.orm.dao;

import java.util.Collection;

import com.inertia.solutions.spring.orm.bean.Item;

public interface ItemDao {
	
	public Collection<Item> findAll();
	
	public void save(Item item);
	
	Item find(Long itemId);
	
}
