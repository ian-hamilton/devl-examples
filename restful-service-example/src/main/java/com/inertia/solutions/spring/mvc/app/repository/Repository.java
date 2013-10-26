package com.inertia.solutions.spring.mvc.app.repository;

import java.util.Collection;

public interface Repository<K, T> {

	public Collection<T> findAll();
	
	public T find(K id);
	
	public T save(T obj);
	
	public Boolean delete(K id);
	
}
