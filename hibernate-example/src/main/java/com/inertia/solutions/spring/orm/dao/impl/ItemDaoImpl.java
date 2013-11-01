package com.inertia.solutions.spring.orm.dao.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inertia.solutions.spring.orm.bean.Item;
import com.inertia.solutions.spring.orm.dao.ItemDao;

@Repository("itemDao")
public class ItemDaoImpl implements ItemDao{

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Item> findAll() {
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(Item.class);
		
		return criteria.addOrder(Property.forName("itemName").asc()).list();
	}

	@Override
	public void save(Item item) {
		this.sessionFactory.getCurrentSession().save(item);
	}

	@Override
	public Item find(Long itemId) {
		Criteria criteria  = this.sessionFactory.getCurrentSession()
					.createCriteria(Item.class);
		criteria.add(Restrictions.eq("itemId", itemId));
		return (Item) criteria.uniqueResult();
	}

}
