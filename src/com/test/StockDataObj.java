package com.test;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import com.googlecode.objectify.annotation.Entity;


@Entity


public class StockDataObj implements Serializable{
	
	@Id
	private Long id;
	private String stockName;
	private String stockPrice;
	private String date;
	private String change;
	private String changePer;
	public StockDataObj() {
		
	}


	public StockDataObj(Long id, String stockName, String stockPrice, String date,
			String change, String changePer) {
		super();
		this.id = id;
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.date = date;
		this.change = change;
		this.changePer = changePer;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getChangePer() {
		return changePer;
	}

	public void setChangePer(String changePer) {
		this.changePer = changePer;
	}
	
	
	

}
