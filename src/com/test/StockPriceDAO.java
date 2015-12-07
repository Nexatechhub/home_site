package com.test;

import java.util.logging.Logger;

import com.googlecode.objectify.Objectify;

public class StockPriceDAO {
	
	private static final Logger log = Logger.getLogger(StockPriceDAO.class.getName());
	
	private Objectify obfy = OfyService.ofy();	
	
	public void saveObject(StockDataObj dataObj){	
		obfy.put(dataObj);
	}
}
