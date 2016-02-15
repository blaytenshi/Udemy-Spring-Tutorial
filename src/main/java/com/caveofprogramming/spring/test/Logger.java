package com.caveofprogramming.spring.test;

import org.springframework.beans.factory.annotation.Autowired;

public class Logger {

	private ConsoleWriter consoleWriter;
	private FileWriter fileWriter;

	@Autowired(required = false)
	/*
	 * Even though the Autowired annotation is declared here, even if it is not declared in the bean.xml, Spring will not crash.
	 */
	public void setConsoleWriter(ConsoleWriter writer) {
		this.consoleWriter = writer;
	}

	@Autowired
	public void setFileWriter(FileWriter fileWriter) {
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

}
