package com.caveofprogramming.spring.test;

import javax.annotation.*;

public class Logger {

	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;

	@Resource
	public void setConsoleWriter(ConsoleWriter writer) {
		this.consoleWriter = writer;
	}
	
	@Resource(name="squirrel")
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public void writeFile(String text) {
		fileWriter.write(text);
	}

	public void writeConsole(String text) {
		if (consoleWriter != null) {
			consoleWriter.write(text);
		}
	}
	
	/*
	 * Run after bean is created. Name of method doesn't matter.
	 */
	@PostConstruct
	public void init() {
		System.out.println("init");
	}
	
	/*
	 * Run before bean is destroyed. Again name of method doesn't matter.
	 * NOTE: where you declare the bean in beans.xml they must be a singleton or default otherwise Spring won't destroy it.
	 */
	@PreDestroy
	public void destroy() {
		System.out.println("destroy");
	}

}
