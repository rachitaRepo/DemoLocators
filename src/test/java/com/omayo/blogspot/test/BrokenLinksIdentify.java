package com.omayo.blogspot.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class BrokenLinksIdentify {
	
	WebDriver driver;
	@Test
	public void borkenLinkVerify() {
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver=new EdgeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		for(WebElement link: links) {
			
			String url=link.getAttribute("href");
			System.out.println("-------------");
			System.out.println(url);
			
			if( url==null || url.isEmpty()) {
				System.out.println("URL is empty");
				continue;
			}
			// check the response code if >=400 then URL is broken else url is correct
			
			 HttpURLConnection huc; try { huc = (HttpURLConnection)(new
			 URL(url).openConnection());
			 huc.connect(); 
			 if(huc.getResponseCode()>=400) {
			 System.out.println("Broken Link"); }
			 else {
			 System.out.println("URL is valid"); } } catch (MalformedURLException e) {
			 
			  e.printStackTrace(); } catch (IOException e) {
			
			e.printStackTrace(); }
			 
			
		}

}
}