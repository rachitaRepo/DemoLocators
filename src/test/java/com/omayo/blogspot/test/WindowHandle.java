package com.omayo.blogspot.test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandle {
	WebDriver driver;
	@Test
	
	public void verifyChildWindowSwitch() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
	 driver= new ChromeDriver();
	 driver.get("https://omayo.blogspot.com/");
	 driver.manage().window().maximize();
	
	//for parent win
	String parWin=driver.getWindowHandle();
	System.out.println(driver.getTitle());
	
	Set <String> childWin= driver.getWindowHandles();
	
	for (String allchildwin:childWin) {
		if (!allchildwin.equalsIgnoreCase(parWin)) {
			driver.switchTo().window(allchildwin);
		System.out.println("child win:" + driver.getTitle());
			
	}
	}
	 
	}
}

