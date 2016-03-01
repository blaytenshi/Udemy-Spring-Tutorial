package com.caveofprogramming.spring.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caveofprogramming.spring.web.dao.Offer;
import com.caveofprogramming.spring.web.service.OfferService;

@Controller
public class OffersController {
	
	private OfferService offerService;
	
	@Autowired
	public void setOfferService(OfferService offerService) {
		this.offerService = offerService;
	}
	
	
	@RequestMapping("/")
	public String showHome(Model model) {
		
		List<Offer> offers = offerService.getCurrent();
		
		model.addAttribute("offers", offers);
		
		return "home";
	}
	
}
