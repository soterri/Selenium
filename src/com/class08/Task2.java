package com.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Task2 extends CommonMethods {
	public static void main(String[] args) {
		
		/* task 2 - VERIFY ELEMENT IS CLICKABLE
		 * 1. Open Chrome Browser
		 * 2. Go to https://the-internet.herokuapp.com/
		 * 3. Click on "Click the DYNAMIC CONTROLS linl
		 * 4. Select CheckBox and click remove
		 * 5. Click on Add Button and verify IT'S BACK! text is displayed
		 * 6. Close the Browser
		 */

		setUp("chrome", "https://the-internet.herokuapp.com/"); //initializing webdriver and nav to page
		driver.findElement(By.xpath("//a[text()='Dynamic Controls']")).click(); //clicking on link

		driver.findElement(By.xpath("//input[@type='checkbox']")).click(); //click on checkbox

		driver.findElement(By.xpath("//button[text()='Remove']")).click(); //click on remove

		WebDriverWait wait = new WebDriverWait(driver, 30); //calling our explicitWait
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@id='message']")));
		//works w/ expected cond. until visibility of element is located
		
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		
		String expectedText="It's back!";
		String actualText = driver.findElement(By.xpath("//p[@id='message']")).getText();
		System.out.println(actualText);
		
		if (actualText.equals(expectedText)) { 
			System.out.println("pass");
		} else {
			System.out.println("failed");
		}
	}
}