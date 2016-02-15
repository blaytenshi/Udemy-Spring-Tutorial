package com.caveofprogramming.spring.test;

import org.springframework.beans.factory.annotation.Autowired;

public class Logger {
	
	/*
	 * Autowired only works by type!
	 */
	
	@Autowired
	private ConsoleWriter consoleWriter;
	@Autowired
	private FileWriter fileWriter;
	
	/*
	@Autowired
	public Logger(ConsoleWriter consoleWriter, FileWriter fileWriter) {
		this.consoleWriter = consoleWriter;
		this.fileWriter = fileWriter;
	}
	*/

	public void setConsoleWriter(ConsoleWriter writer) {
		this.consoleWriter = writer;
	}
	
	// @Autowired -- You don't even need these set methods!
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
	public void writeFile(String text) {
		fileWriter.write(text);
	}
	
	public void writeConsole(String text) {
		consoleWriter.write(text);
	}
	
}
