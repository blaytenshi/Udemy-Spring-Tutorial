package com.caveofprogramming.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Logger {

	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;

	@Autowired
	@Qualifier("toconsole")
	/*
	 * Because in beans.xml there is more than one bean that implements ConsoleWriter you'll get a
	 * "expected single matching bean but found 2: consoleWriter,squirrel" error
	 * But by utilising the Qualifier Annotation, we tell beans.xml which method to wire into the context
	 * when the writeConsole method is called by App
	 */
	public void setConsoleWriter(ConsoleWriter writer) {
		this.consoleWriter = writer;
	}

	@Autowired
	@Qualifier("filewriter")
	/*
	 * This is declaring Qualifiers by annotating the Class as opposed to the beans.xml. By annotating the
	 * class, this tells Spring which class to wire in when there is an ambiguity in which class to use when
	 * Spring encounters an interface being wired into the bean and being called by App.
	 */
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

}
