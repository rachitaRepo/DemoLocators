package com.omayo.blogspot.test;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RandomAction {
	//code will generate random no while execution one by one 
	
	@Test
	public void selectRandomLink() {
		
	
		System.setProperty("webdriver.http.factory", "jdk-http-client");
			WebDriver driver=new ChromeDriver();
			driver.get("https://omayo.blogspot.com/");
			driver.manage().window().maximize();
			
			
			System.out.println("OKKKKK");
			
			
			/* Code to get random link and clicking on that */
			
			
			 List<WebElement> wbList=driver.findElements(By.xpath("//div[@id='LinkList1']/div/ul/li[*]/a"));
			 
			 int randNumber=generateRandomNumber(wbList.size());
			 System.out.println("Size=" + wbList.size());
			 String product=wbList.get(randNumber).getText();
			 
				System.out.println("random link selected is " + product);
			
			wbList.get(randNumber).click();
			driver.navigate().back();
		
	}
			
	
	public static int generateRandomNumber(int number) {
		
		Random ranNo=new Random();
		int rnum=ranNo.nextInt(number);
		return rnum;
		
	}

}
