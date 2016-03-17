package com.caveofprogramming.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.caveofprogramming.spring.web.dao.Offer;
import com.caveofprogramming.spring.web.dao.OfferDao;

@Service("offerService")
public class OfferService {
	
	private OfferDao offerDao;
	
	@Autowired
	public void setOfferDao(OfferDao offerDao) {
		this.offerDao = offerDao;
	}
	
	public List<Offer> getCurrent() {
		return offerDao.getOffers();
	}

	// The curly brace allows you to add a list of roles :)
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public void create(Offer offer) {
		offerDao.create(offer);
	}

}
