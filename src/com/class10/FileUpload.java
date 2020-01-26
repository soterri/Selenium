package com.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class FileUpload extends CommonMethods {
	
	/* navigate to "https://the-internet.herokuapp.com/upload"
	 * upload the file
	 * verify file is uploaded
	 */
	public static void main (String[] args) {
	
		setUp("chrome", "https://the-internet.herokuapp.com/upload");
		
		//to upload file we can use sendKeys method and provide full path to the xfile
		//have to specifiy the path to the file in sendKeys
		//full path -- path + fileName +file extension
		//for windows --> use \\ or / 
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\User\\Desktop\\sophy.JPG");
		
		//clicking on upload btn 
		driver.findElement(By.id("file-submit")).click();
		
		WebElement uploaded=driver.findElement(By.xpath("//div[@id='uploaded-files']/preceding-sibling::h3"));
		if(uploaded.isDisplayed()) {
			System.out.println("File successfully uploaded");
		}else {
			System.out.println("File upload unsucessful");
		}
		
		driver.quit();
	}
}
