package com.caveofprogramming.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caveofprogramming.spring.web.dao.Offer;
import com.caveofprogramming.spring.web.dao.OfferDAO;

@Service("offerService")
public class OfferService {
	
	private OfferDAO offerDao;
	
	@Autowired
	public void setOfferDao(OfferDAO offerDao) {
		this.offerDao = offerDao;
	}
	
	public List<Offer> getCurrent() {
		return offerDao.getOffers();
	}
}
