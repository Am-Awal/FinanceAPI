package com.tcs.marketpriceapi;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.marketpriceapi.models.MarketPrice;
import com.tcs.marketpriceapi.service.PriceService;

@Component
public class Main
{
	@Autowired
	private static PriceService priceService;
	
	public static void main(String [] args)
	{


	MarketPrice stock;
	try {
		stock = priceService.retreiveStock("TSLA");
		System.out.println(stock.getPrice());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
