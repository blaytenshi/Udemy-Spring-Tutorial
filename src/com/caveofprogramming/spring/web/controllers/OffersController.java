package com.caveofprogramming.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caveofprogramming.spring.web.dao.Offer;
import com.caveofprogramming.spring.web.service.OfferService;

@Controller
public class OffersController {
	
	private OfferService offerService;
	
	@Autowired
	public void setOfferService(OfferService offerService) {
		this.offerService = offerService;
	}
	
	// If you only supply the value this is what it looks like
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id) {
		
		System.out.println("Id is: " + id);
		
		return "home";
	}
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		
		List<Offer> offers = offerService.getCurrent();
		
		model.addAttribute("offers", offers);
		
		return "offers";
	}
	
	@RequestMapping("/createOffer")
	// When createOffer is called from browser, Model is generated and offer object is added to it. createOffer.jsp is then loaded.
	// Therefore if i create an offer object and fill it with crap, it'll display on the jsp
	public String createOffer(Model model) {
		
		model.addAttribute("offer", new Offer());
		
		return "createOffer";
	}
	
	@RequestMapping(value="/doCreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		// It'll automatically map the input into the Offer object!! :O!!!
		
		if(result.hasErrors()) {
			
			return "createOffer";
		} 
		
		return "offerCreated";
	}
	
}
