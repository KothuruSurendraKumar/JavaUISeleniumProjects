package com.selenium;


import java.util.HashMap;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v122.emulation.Emulation;

/*
 * Got requirement to run the application in different time zone
 * consider any location and get the co-ordinates(longitude and latitude)
 * take location ohio (40.4173° N, 82.9071° W)
 */
public class TimeZoneTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
//		HashMap<String,Double> cordinates = new HashMap<>();
//		cordinates.put("latitude", 40.4173);
//		cordinates.put("longitude", -82.9071);
//		cordinates.put("accuracy", 1.0);
		DevTools dev = ((ChromeDriver) driver).getDevTools();
		//dev.createSession();
		
		try {
			dev.createSession();
			HashMap<String,Double> cordinates = new HashMap<>();
			cordinates.put("latitude", 40.4173);
			cordinates.put("longitude", -82.9071);
			cordinates.put("accuracy", 1.0);
			dev.send(Emulation.setGeolocationOverride(
					Optional.of(cordinates.get("latitude")),
					Optional.of(cordinates.get("longitude")),
					Optional.of(cordinates.get("accuracy"))
					));
			driver.get("www.youtube.com");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//driver.executeCdpCommand("Emulation.setGeolocationOverride", cordinates);
		

	}

}
