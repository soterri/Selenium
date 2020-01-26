package com.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;

public class Recap extends CommonMethods {

	/*why do we need CommonMethods? bc we have an access to the WebDriver 
	*we have different methods to perform different functions
	*
	*navigate to google and search for specific item
	*/
	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", "https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("iPhone 11 pro", Keys.ENTER);
		
		//in which case would we go for Action class?
		Actions act = new Actions(driver);
		
		//identify an element 
		WebElement button=driver.findElement(By.name("btnK"));
		
		//1 way - move to desired element and perform click
		//act.moveToElement(button).click().perform();
		
		//2 way - click and specify element on which to click
		act.click().perform();
		
		Thread.sleep(2000);
		driver.quit();
	}
	
}
