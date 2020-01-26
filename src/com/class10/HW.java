package com.class10;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class HW extends CommonMethods {
	
	/*1. open chrome browser
	 * 2. go to https://www.aa.com/homePage.do
	 * 3. Enter FROM & TO
	 * 4. Select DEPARTURE as of May 14, 2020
	 * 5. Select ARRIVAL as November 8, 2020 
	 * 6. Verify "choose flights" texts is displayed
	 * 7. Close Browser
	 */

	public static void main (String[] args) throws InterruptedException {
		
		setUp("chrome", "https://www.aa.com/homePage.do");
		
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).clear();
		
		//select depature and destination
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).sendKeys("LAX");
		driver.findElement(By.id("reservationFlightSearchForm.destinationAirport")).sendKeys("TIA");
		driver.findElement(By.id("aa-leavingOn")).click();
		
		boolean flag = false;
		while(!flag) {
			String departMonth = driver.findElement(By.xpath("//div[contains(@class, 'ui-corner-left')]/div")).getText();
			System.out.println(departMonth);
			if(departMonth.equals("May 2020")) {
				List<WebElement> daysOfMonth =driver.findElements(By.xpath("//div[contains(@class, 'ui-corner-left')]/following-sibling::table/tbody/tr/td"));

		for(WebElement days:daysOfMonth) {
			String dayText = days.getText();
			
			if (dayText.equals("14")) {
				days.click();
				flag = true;
				break;
			}
		}

	} else {
		driver.findElement(By.xpath("//a[@title='Next']")).click();
	}

}
// select return date
driver.findElement(By.id("aa-returningFrom")).click();
flag = false;
while (!flag) {
	String retMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	System.out.println(retMonth);
	if (retMonth.equals("November")) {
		List<WebElement> daysOfMonth = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement days : daysOfMonth) {
			String dayText = days.getText();
			if (dayText.equals("8")) {
				days.click();
				flag = true;
				break;
			}
		}

	} else {
		driver.findElement(By.xpath("//a[@title='Next']")).click();
	}

}
Thread.sleep(2000);
// click search
TakesScreenshot ts = (TakesScreenshot) driver;
File screen = ts.getScreenshotAs(OutputType.FILE);
try {
	FileUtils.copyFile(screen, new File("screenshots/HW-Class-9/AA-SS.png"));
} catch (IOException e) {
	e.printStackTrace();
}
Thread.sleep(8000);
driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();

Thread.sleep(5000);
//WebDriverWait wait=new WebDriverWait(driver,30);	
//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//img[@alt='American Airlines - homepage']"))));
//
Thread.sleep(5000);
// get the ss of the loaded page
String visibleText = driver.findElement(By.id("aa-pageTitle")).getText();

// verification of the text shown
if (visibleText.equals("Choose flights")) {
	System.out.println("test Case Passed");
} else {
	System.out.println("test Case Failed");
}
driver.quit();
}
		
				
			
	}
