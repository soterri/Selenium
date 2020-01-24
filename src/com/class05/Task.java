package com.class05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class Task extends CommonMethods {

	public static final String SYNTAX_PRACTICE_URL = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";

	public static void main(String[] args) throws InterruptedException {
		
		//The method is opening syntax Practice website using chrome browser
		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		
		Thread.sleep(2000);
		//find the element Alerts and Modals and clicking on it
		driver.findElement(By.xpath("//a[@href='#' and text()='Alerts & Modals']")).click();
		
		//finding Javascript Alerts and clicking on it
		driver.findElement(By.linkText("Javascript Alerts")).click();
		
		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
		Thread.sleep(2000);
		
		Alert alert=driver.switchTo().alert();
		System.out.println("Text Box Alert: "+alert.getText());
		
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		
		Alert alert1 = driver.switchTo().alert();
		
		System.out.println("JavaScript Alert: "+alert1.getText());
		
		
		
}
}
