package com.caveofprogramming.spring.test;

public class Logger {
	private LogWriter consoleWriter;
	private LogWriter fileWriter;
	
	
	public Logger(ConsoleWriter consoleWriter, FileWriter fileWriter) {
		this.consoleWriter = consoleWriter;
		this.fileWriter = fileWriter;
	}
	
	/*
	 * These will only enable autowire to wire one of them leaving the other 
	 * unwired and the method call in App will fail with null pointer exception.
	 * 
	public Logger(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	public Logger(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	*/
	
	public void setConsoleWriter(LogWriter writer) {
		this.consoleWriter = writer;
	}
	
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
	public void writeFile(String text) {
		fileWriter.write(text);
	}
	
	public void writeConsole(String text) {
		consoleWriter.write(text);
	}
}
