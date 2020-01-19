package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class URLVerificationTask {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.syntaxtechs.com");
		
		driver.navigate().to("https://www.google.com");
		driver.navigate().back();
		driver.navigate().refresh();
		
		String expectedUrl = "https://syntaxtechs.com/";
		String actualUrl = driver.getCurrentUrl();
		//System.out.println(actualUrl);
		
		if (expectedUrl.equals(actualUrl)) {
			System.out.println("url matches");
		}else {
			System.err.println("url does not match");
	}
		driver.close();
	}
}
