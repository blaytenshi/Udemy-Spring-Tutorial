package com.caveofprogramming.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		
		// Creates Spring container that will go fetch beans from the name of the xml file specified
		ApplicationContext context = new ClassPathXmlApplicationContext("com/caveofprogramming/spring/test/beans/beans.xml");
		
		// passing bean id into the getBean method and cast the return type of the object
		Person person = (Person)context.getBean("person");
		
		person.setTaxId(666);

		System.out.println(person);
		
		Address address2 = (Address)context.getBean("address2");
		System.out.println(address2);
		
		((ClassPathXmlApplicationContext) context).close();
	}
}
