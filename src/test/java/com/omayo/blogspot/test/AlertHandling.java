package com.omayo.blogspot.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class AlertHandling {

	WebDriver driver;
	@Test
	public void handleAlert() {
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver=new EdgeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("alert1")).click();
					
				Alert alert =driver.switchTo().alert();
				String text=alert.getText();
				System.out.println(text);
				alert.accept();
	
//	alert.dismiss();
	}
}
