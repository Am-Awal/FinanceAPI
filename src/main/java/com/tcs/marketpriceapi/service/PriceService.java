package com.tcs.marketpriceapi.service;

import java.io.IOException;
//import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.tcs.marketpriceapi.models.MarketPrice;

import lombok.AllArgsConstructor;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@AllArgsConstructor
@Service
public class PriceService {

	public MarketPrice retreiveStock(String ticker) throws IOException {
		 //final String COL_NAME="users";  

		
		try 
		{
			System.out.println("Retrieving stock... ");
			
			Stock stock = YahooFinance.get(ticker);

			System.out.println("Retrieved stock... ");
			//stock.print();
			MarketPrice pr = new MarketPrice(stock);			
			return pr;
		}
		catch (IOException e) 
		{
			System.out.println("Failed to retrieve stock: ");
			e.printStackTrace();
		}
		return null;
	}
	

	public String savePrice(MarketPrice pr) throws InterruptedException, ExecutionException {  
	 Firestore dbFirestore = FirestoreClient.getFirestore();  
	 ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Prices").document().set(pr);
	 
	 return collectionsApiFuture.get().getUpdateTime().toString();  
	 }  
}
