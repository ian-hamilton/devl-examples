package com.inertia.solutions.spring.orm.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inertia.solutions.spring.orm.bean.ShoppingCartItem;
import com.inertia.solutions.spring.orm.dao.ShoppingCartItemDao;

@Repository("shoppingCartItemDao")
public class ShoppingCartItemDaoImpl implements ShoppingCartItemDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(ShoppingCartItem shoppingCartItem) {
		this.sessionFactory.getCurrentSession().save(shoppingCartItem);		
	}

}
