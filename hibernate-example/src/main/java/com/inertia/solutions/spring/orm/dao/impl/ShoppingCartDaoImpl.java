package com.inertia.solutions.spring.orm.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inertia.solutions.spring.orm.bean.ShoppingCart;
import com.inertia.solutions.spring.orm.dao.ShoppingCartDao;

@Repository("shoppingCartDao")
public class ShoppingCartDaoImpl implements ShoppingCartDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(ShoppingCart shoppingCart) {
		this.sessionFactory.getCurrentSession().save(shoppingCart);
		
	}

	@Override
	public ShoppingCart find(String userName) {
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(ShoppingCart.class);
		criteria.add(Restrictions.eq("userName", userName));
		return (ShoppingCart) criteria.uniqueResult();
	}

	@Override
	public void update(ShoppingCart shoppingCart) {
		this.sessionFactory.getCurrentSession().update(shoppingCart);
	}

}
