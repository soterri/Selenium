package com.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class JSExecutorDemo extends CommonMethods {
	
public static void main (String[] args) throws InterruptedException {
		
	/*
	 * navigate to HRMS
	 * enter UN and PW
	 * click login button using JSExecutor
	 * 
	 */
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Syntax@123");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement loginBtn=driver.findElement(By.id("btnLogin"));
		js.executeScript("arguments[0].style.backgroundColor='green'", loginBtn);
		//as a jsExec have to pass an JSscript code and on which element would u like to perform action
		js.executeScript("arguments[0].click();", loginBtn);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,22050)");
		Thread.sleep(2000);
		driver.quit();
	}
}
