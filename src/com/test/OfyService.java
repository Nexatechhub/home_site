package com.test;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/*
 * Custom Objectify Service
 */
public class OfyService {

	static {
		ObjectifyService.register(StockDataObj.class);
		
    }

    public static Objectify ofy() {       
        return ObjectifyService.begin();  //For objectifiy 3
       // return ObjectifyService.ofy();

    }

    public static ObjectifyFactory factory() {    	
        return ObjectifyService.factory();
    }
}

