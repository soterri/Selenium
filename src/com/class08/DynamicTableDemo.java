package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class DynamicTableDemo extends CommonMethods{
	
	public static void main(String[] args) throws InterruptedException {
	
	/* navigate to WebOrders
	 * login into WebOrders
	 * click checkbox next to Bob Feather
	 */
	setUp("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
	
			//login
			driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
			driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
			driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	
	//search for Bob Feather
	String expectedValue ="Bob Feather";
	
	//to look for a specific person you have to LOOP
	List<WebElement>rows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
	for (int i=1; i<rows.size(); i++) {
		String rowText=rows.get(i-1).getText();
		//Sysout(rowText);
		System.out.println(rowText);
		if(rowText.contains(expectedValue)) {
			driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+i+"]/td[1]")).click();
		}
	}

	Thread.sleep(4000);
	driver.quit();
}
}
