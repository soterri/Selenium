package com.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;
import com.utils.Constants;

/* Navigate to HRMS application
 * Enter UID and PWD
 * Click on LOGIN using mouse
 */

public class ActionsClassDemo extends CommonMethods {

	public static void main (String[] args) throws InterruptedException {
		
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Syntax@123");
		
		//to perform mouse or ketboard operations we need to have an obj of ACTIONS class
		Actions act = new Actions(driver);
		
		//we need to identify an element on which to perform mouse/keyboard click
		//once you find the element STORE IT in WebElement
		WebElement loginBtn=driver.findElement(By.cssSelector("input#btnLogin"));
		
		//to RIGHT CLICK
		act.moveToElement(loginBtn).contextClick().perform();
				
		//move mouse --> to complete action --> .perform();
		act.moveToElement(loginBtn).click().perform();
		
		//to double click
		//act.moveToElement(loginBtn).doubleClick().perform();
		
		
		Thread.sleep(2000);
		
		//hover over the element
		WebElement pimLink=driver.findElement(By.linkText("PIM"));
		act.moveToElement(pimLink).perform();
		
		//to add employee using action class
		//1. identify the element 2. store in webelement 
		WebElement addEmp=driver.findElement(By.linkText("Add Employee"));
		act.click(addEmp).perform();
		
		//act.keyUp(Keys.SHIFT).sendKeys("hello") --> if you perform this on txt box
		// it will hold shift key and type hello in upper case
		
		driver.quit();
		
	}
}
