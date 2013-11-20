package com.inertia.solutions.patterns.command.singleton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class FileWriterSingletonTest {

	@Before
	public void setup() {
		//this setups the singleton instance away from the tests
		// the test now should use the singleton
		FileWriterSingleton.getInstance();
	}
	
	@Test
	public void testWriting() {
		FileWriterSingleton writer = FileWriterSingleton.getInstance();
		writer.writeToFile("Ian is writing a singleton pattern");
	}
	
	@Test
	public void testWritingDesparant() {
		FileWriterSingleton writer = FileWriterSingleton.getInstance();
		writer.writeToFile("Ian is writing a singleton pattern again with a singleton");
	}
	
	@After
	public void testWritingDestroy() {
		FileWriterSingleton writer = FileWriterSingleton.getInstance();
		writer.destroy();
	}
}
