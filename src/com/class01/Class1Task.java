package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class1Task {
	
	public static void main (String[]args) {
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://amazon.com/");
	
	final String expectedTitle = "Amazon.com: Online Shopping for Electronics, "
			+ "Apparel, Computers, Books, DVDs, and more";
	String actualTitle = driver.getTitle();
	
	if(expectedTitle.equals(actualTitle)) {
		System.out.println("The title and actual matches");
	} else {
		System.out.println("Title and actual DO NOT match");

}
}
}