package com.class07;

	import org.openqa.selenium.By;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.utils.CommonMethods;
	import com.utils.Constants;

	public class ExplicitWaitDemo extends CommonMethods{
	/*
	 * Navigate to the page
	 * click on others
	 * select dynamic data loading
	 * click Get new User
	 * verify/validate that First Name element is displayed
	 * */
		
		//first we will need main method and than extends to common methods
		//setUp
		//our method will initialize our driver than maximize window and than set up for pageload
		//and implcit wait and nav. to URL
		
		public static void main (String[] args) throws InterruptedException {
			setUp("chrome", Constants.SYNTAX_PRACTICE_URL);
			driver.findElement(By.linkText("Others")).click();
			driver.findElement(By.linkText("Dynamic Data Loading")).click();
			driver.findElement(By.id("save")).click();
			
			//WebDriver Wait aka Explicit Wait - to wait specific element to appear on the page 
			//how will it work? it will wait until expected condition is met OR the specified time
			//WebDriver wait is a CLASS
			
			WebDriverWait wait = new WebDriverWait(driver, 30); //will have to pass argument
			//getting the obj/vari of web driver type/wait
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[starts-with(text(), 'First Name')]")));
			
			boolean displayed=driver.findElement(By.xpath("//p[starts-with(text(), 'First Name')]")).isDisplayed();
			if(displayed) {
				System.out.println("Pass");
			}else {
				System.out.println("Failed");
			}
			
			Thread.sleep(2000);
			driver.quit();
		}
}
