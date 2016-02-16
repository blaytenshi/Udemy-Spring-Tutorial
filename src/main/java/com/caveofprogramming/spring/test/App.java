package com.caveofprogramming.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/caveofprogramming/spring/test/beans/beans.xml");

		OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");
		
		Offer updateOffer = new Offer(90, "Claire", "claire@caveofprogramming.com", "Web design to fit any budget!");
		if (offersDao.update(updateOffer)) {
			System.out.println("Object updated.");
		} else {
			System.out.println("Cannot update object");
		}

		try {
			
			Offer offer1 = new Offer("Dave", "dave@caveofprogramming.com", "Coding Java");
			Offer offer2 = new Offer("Karent", "karen@caveofprogramming.com", "Software Testing to order");
			
			if (offersDao.create(offer1)) {
				System.out.println("Created offer object");
			}
			
			if (offersDao.create(offer2)) {
				System.out.println("Created offer object");
			}
			
			offersDao.delete(80);
			
			List<Offer> offers = offersDao.getOffers();

			for (Offer offer : offers) {
				System.out.println(offer);
			}
			
			Offer offer = offersDao.getOffer(2);
			System.out.println("Should be Mike: " + offer);
			
			
			
		} catch (CannotGetJdbcConnectionException ex) {
			System.out.println("Cannot get database connection");
		} catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());

		}

		((ClassPathXmlApplicationContext) context).close();
	}
}
