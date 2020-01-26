package com.class11;

import com.utils.CommonMethods;

public class MethodsTest extends CommonMethods {
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome","https://www.expedia.com");
		
		scrollDown(1000);
		Thread.sleep(2000);
		scrollUp(500);
		Thread.sleep(3000);
		driver.quit();
	}
	
	
}
