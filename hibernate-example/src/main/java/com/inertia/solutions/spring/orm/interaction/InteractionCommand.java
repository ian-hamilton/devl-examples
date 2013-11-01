package com.inertia.solutions.spring.orm.interaction;


public interface InteractionCommand {

	public String getInteraction();
	
	public String execute(String input);
}
