package com.omayo.blogspot.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.maven.surefire.shared.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Screenshot {
	WebDriver driver;
	
	@BeforeMethod
	public void atBrowserLaunch() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginScenario() {
		
		driver.findElement(By.id("email1")).sendKeys("rachita123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("1223");
	}

	@AfterMethod
	public void browserClosed(ITestResult result) {
		if(!result.isSuccess()) {
			
			
			//take SS
			
			File sourcScreen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			
			//fine name adding
			Date date=new Date();
			String fileName=result.getMethod().getMethodName()+"_"+ date.toString().replace(" ", "_").replace(":", "_")+".jpg";
			String loc="C:\\AUTOMATION\\DemoOnLocatorsProj\\DemoLocators\\screenShot\\";
			
			String finalPath=loc+fileName;
			
			System.out.println(finalPath);
			
			// obj of destination file 
			
			File destScreen=new File(finalPath);
			try {
				FileUtils.copyFile(sourcScreen, destScreen);
				//FileUtils.moveFile(sourcScreen, destScreen);
			} catch (IOException e) {
					e.printStackTrace();
			}
			
			
			
		}
		
		//driver.close();
	}
}
