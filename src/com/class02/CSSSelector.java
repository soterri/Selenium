package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelector {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.get("http://166.62.36.207/Syntax_HRM/symfony/web/index.php/auth/login");
		
		driver.findElement(By.cssSelector("input[name='txtUsername']")).sendKeys("Admin");
		//syntax of CSSSelector
		//input[name='txtusername']
		
		//input#txtusername only for ID attribute
		
		// input.button  dot (.) use for class. 
		//if there is space in class value, then replace it with (.)
		
		// input[name^='txt']  starts with CSS Selector
		
		// input[name$='name']  $ represents ends with
		
		// input[id*='nL']   * keyword represents contains
		
		

	}

}
