package com.class05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class AlertDemo1 extends CommonMethods {
	
		
		public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";

		public static void main(String[] args) throws InterruptedException {
			
			//The method is opening syntax Practice website using chrome browser
			CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
			Thread.sleep(1000);
			//find the element Alerts & Modals and clicking on it 
			driver.findElement(By.xpath("//a[@href='#' and text()='Alerts & Modals']")).click();
			
			//find JavaScript button and clicking on it 
			driver.findElement(By.linkText("Javascript Alerts")).click();
			
			//find the button and clicking on it 
			driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
			
			
			Alert alert=driver.switchTo().alert();
			Thread.sleep(1000);
			
			System.out.println("Alert text:   "+alert.getText());
			//accept alert - any positive action, could be yes, ok, accept 
			alert.accept();
			Thread.sleep(1000);
	
			
			
			//get the text from the ui or main window
			String text=driver.findElement(By.xpath("//p[text()='Click the button to display an alert box:']")).getText();
			System.out.println(text);
			
			
}

}