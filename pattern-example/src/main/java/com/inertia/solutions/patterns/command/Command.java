package com.inertia.solutions.patterns.command;

public interface Command<T,A> {
	
	public T execute(A action);
}
