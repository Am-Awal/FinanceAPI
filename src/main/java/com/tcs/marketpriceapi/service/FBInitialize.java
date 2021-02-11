package com.tcs.marketpriceapi.service;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service  
public class FBInitialize 
{  
	@PostConstruct  
	public void initialize() 
	{  
		try 
		{  

			FileInputStream serviceAccount =
					new FileInputStream("./financedb-9cb39-firebase-adminsdk-e377s-520284e5b5.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://financedb-9cb39.firebaseio.com")
					.build();  
					//.setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl("https://chatapp-e6e15.firebaseio.com").build();  

			FirebaseApp.initializeApp(options);

		} 
		catch (Exception e) 
		{  
			e.printStackTrace();  
		}
	}

}  
