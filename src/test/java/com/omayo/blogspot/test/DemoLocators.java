package com.omayo.blogspot.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoLocators {
	WebDriver driver;
	
	@Test
	public void atTest() {
System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver=new ChromeDriver();	
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Test");
		driver.findElement(By.className("classone")).sendKeys("Test");
		driver.findElement(By.linkText("compendiumdev")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().back();
		//inspect elemnet ..>right click> copy selector (value will be copied)
		driver.findElement(By.cssSelector("#sa")).click();
		System.out.println("SameIDName is clicked");
		
		driver.findElement(By.xpath("//*[@id=\"HTML28\"]/div[1]/input")).sendKeys("TEST");
		
	//	driver.quit();
 
	}
}
