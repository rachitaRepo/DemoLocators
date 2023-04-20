package com.omayo.blogspot.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HiddenElementHandlingByJavaScript {

	WebDriver driver;
	@Test
	
	public void verifyTheHiddenElement() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver=new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		
		//click on getConfirmation button , using javascript 
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		//inspect the disabled /invisibke element and take it attribute id, name  then write in console
		//"document.getElementById('tb2')  enter you will get the html code
		js.executeScript("document.getElementById('tb2').value='ractext';"); 
		
		js.executeScript("document.getElementById('prompt').click();");
		System.out.println("Prompt Clicked");
		
		//input value 
		js.executeScript("document.getElementById(id').value='someValue';");
		
		//CheckBox
		js.executeScript("document.getElementById('enter element id').checked=false;");
		
		//generate alert window
		js.executeScript("alert('Welcome To Selenium Testing');");
		
		//refresh browser history in windlow
		js.executeScript("history.go(0)");
		
		// scroll window
		js.executeScript("window.scrollBy(0,800)");
		
		//to get domain
		String domainName=  js.executeScript("return document.domain;").toString();
		System.out.println(domainName);
		
		//to get url
		String url=  js.executeScript("return document.url;").toString();
		System.out.println(url);
		
		//to get title
		String titleText =  js.executeScript("return document.title;").toString();
		System.out.println(titleText);
	}
}
