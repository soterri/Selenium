package com.class07;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class PageLoadandImplicitWait extends CommonMethods {
	
	public static void main (String[] args) {
	
	setUp("chrome", "https://cnn.com/");
	
	//page load waits until ALL elements on the page gets fully loaded and if elements wont load 
	//within 30 secs, you will get TimeOutException
	//if you takes too long for the page to get loaded, report to Developer! so they can fix it
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
 
	//tell webdriver to wait for the element before throwing NoSuchElementException
	
	//we will use ImplicitWait
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.name("wrongName")).sendKeys("iPhone");
	
	
	
	driver.quit();
	
	

}
}