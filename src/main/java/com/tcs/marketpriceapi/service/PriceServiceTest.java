package com.tcs.marketpriceapi.service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.boot.test.context.SpringBootContextLoader;

import com.tcs.marketpriceapi.models.MarketPrice;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class )
public class PriceServiceTest 
{
	@Autowired
	private  PriceService priceService;
	
	@Test
	public void invoke()
	{
		
		//System.out.println("Before try-catch block");
		try {
			final MarketPrice pr = priceService.retreiveStock("TTM");
			try {
				priceService.savePrice(pr);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("The stock object is: ");
			
			System.out.println(pr.getTicker() +": "+ pr.getPrice());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
