package com.class03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsCommandDemo2 {
		
		public static final String URL ="http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
		public static void main(String[] args) throws InterruptedException{
			
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get(URL);

			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("helen@123");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			List<WebElement>  links=driver.findElements(By.tagName("a"));
			System.out.println("Size of all Links= "+links.size());
			
			for(WebElement link:links) {
				String allLink=link.getText();
				
				if(!allLink.isEmpty()) {
					System.out.println(allLink);
				}
			}
			
			
		}

	}
	