package com.omayo.blogspot.test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ClickonAllLinks {
	
	WebDriver driver;
	@Test
	public void atClickonAllLinks() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver=new EdgeDriver();
		
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		//driver.wait(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement>  lstofLinks= driver.findElements(By.xpath("//div[@id='LinkList1']/div/ul/li[*]/a"));
		lstofLinks.size();
		for (int i=0;i<lstofLinks.size();i++) {
			String URL=	lstofLinks.get(i).getAttribute("href");
			String LinkName=lstofLinks.get(i).getText();
			
		System.out.println(LinkName + "is linkname" + "URL is : " +URL);
		
		lstofLinks.get(i).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(URL + "is clicked , now backnavogating");
		driver.navigate().back();
		//to avoid the stale exception
		lstofLinks= driver.findElements(By.xpath("//div[@id='LinkList1']/div/ul/li[*]/a"));
		}
		
		driver.quit();
	}}
	
	/*for (int i=0;i< wbList.size();i++) {
		 
		String URL=wbList.get(i).getAttribute("href");
		wbList.get(i).click();
		driver.navigate().back();
	}
	
	
//	System.out.println("Random No:" + randNumber);
*/			

