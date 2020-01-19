package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LunchChromeBrowser {
	public static String path="";
	public static void main(String[] args) throws InterruptedException {

	String path="";
		// System is a class.  SetProperty(); is a static method
		//how do you know if its static? bc its italic and we didnt create an obj from class name
		//					Key							Value
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//http--> hypertext transfer protocol 
		driver.get("http://google.com");
		
		Thread.sleep(2000);
		
		//browser navagation commands
		
		//it will navigate to a given url
		driver.navigate().to("http://www.syntaxtechs.com");
		//it will navigate back
		driver.navigate().back();
		//navigate forword
		driver.navigate().forward();
		
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		
		driver.close();

	}

}