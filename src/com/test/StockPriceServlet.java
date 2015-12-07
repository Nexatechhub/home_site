package com.test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;


public class StockPriceServlet extends HttpServlet  {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
			Document doc = Jsoup.connect("http://www.bloomberg.com/markets/stocks/world-indexes/").get();
			System.out.println(doc.title());
			StockPriceDAO priceDAO = new StockPriceDAO();
			Elements str = doc.getElementsByClass("name");
			System.out.println("Title : "+str.attr("title")+"\n");
			if(str != null && str.size() > 1) {
				for(int i=1; i<6;i++) {
					System.out.println("\nName : "+str.get(i).child(0).html());
					StockDataObj dataObj = new StockDataObj();
					if(str.get(i).child(0).html()!=null){
						dataObj.setStockName(str.get(i).child(0).html());
					}
					//	for(int j=0; j<=3;j++) {
					//System.out.println(str.get(i).siblingElements().get(j).html());
					if(str.get(i).siblingElements().get(0).html()!=null){
						dataObj.setStockPrice(str.get(i).siblingElements().get(0).html());		
					}
					if(str.get(i).siblingElements().get(1).html()!=null){
						dataObj.setChange(str.get(i).siblingElements().get(1).html());
					}
					if(str.get(i).siblingElements().get(2).html()!=null){
						dataObj.setChangePer(str.get(i).siblingElements().get(2).html());
					}
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					dataObj.setDate(dateFormat.format(date));
					priceDAO.saveObject(dataObj);
					//}
				}
			}
	}
	
	
	
}
