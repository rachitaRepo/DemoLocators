package com.omayo.blogspot.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class JavaScriptExecutor {
	/*    Page scroll from java script executer using chrome console to write window.scrollby(horiz,vert), check there a
	  and accordinly give no in code */
	
	WebDriver driver;
	
	
	@Ignore
	@Test(priority=1)
	public void pageScrollUpDown() {
		
	System.setProperty("webdriver.http.factory", "jdk-http-client");
	driver=new EdgeDriver();
	
	driver.get("https://omayo.blogspot.com/");
	driver.manage().window().maximize();
	
	//Java script executer for scroll windows
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
		js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(400,1000)");  // check from console take ki kitnja value dena hai
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
							js.executeScript("window.scrollBy(-400,-1000)");
							driver.close();
					}
	@Ignore
	@Test(priority=2)
			public void displayAlertonPage() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
				driver=new ChromeDriver();
				driver.get("https://omayo.blogspot.com/");
				driver.manage().window().maximize();
				JavascriptExecutor js=(JavascriptExecutor)driver;
				
				js.executeScript("alert('rachita bhandari')");
			
			}
	@Test
	public void verifyIf_Ok_ButtonIs_NotClickable() {
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver=new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
			WebElement alertButton=driver.findElement(By.id("alert1"));
			
			js.executeScript("arguments[0].click", alertButton);
			System.out.println("Clicked");
			
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		//driver.close();
	}
	
}
