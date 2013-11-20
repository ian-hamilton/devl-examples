package com.inertia.solutions.patterns.command.singleton;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriterSingleton {
	private static volatile FileWriterSingleton INSTANCE = null;
	
	private static final String FILE_PATH = "target/singleton.log";
	
	PrintWriter writer;
	
	private FileWriterSingleton() {
		if(INSTANCE!=null)
			throw new IllegalStateException("Singleton class alread insantiated");
		
		try {
			writer = new PrintWriter(FILE_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static FileWriterSingleton getInstance() {
		if(INSTANCE==null)
			synchronized(FileWriterSingleton.class) {
				INSTANCE = new FileWriterSingleton();
			}
		return INSTANCE;
	}
	
	public void writeToFile(String text) {
		writer.append(text);
	}
	
	public void destroy() {
		writer.close();
	}
}
