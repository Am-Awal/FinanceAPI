package com.tcs.marketpriceapi.models;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Getter;
import yahoofinance.Stock;
import yahoofinance.quotes.stock.StockQuote;

@Getter
@AllArgsConstructor
public class MarketPrice 
{
	//private final Stock stock;
	private final String ticker;
	StockQuote price;
	private final LocalDateTime mostRecent;
	
	public MarketPrice(final Stock stock) 
	{
		
		//this.stock = stock;
		try {
			this.price = stock.getQuote(true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.ticker = stock.getSymbol();
		mostRecent = LocalDateTime.now();
	}

	public String getTicker() {
		return price.getSymbol();
		//return price;
	}
	public String getPrice() {
		BigDecimal dec = price.getPreviousClose();
		return dec.toString();
	}
	
	public LocalDateTime timeOfQuote() {
		return LocalDateTime.now();
	}
}
