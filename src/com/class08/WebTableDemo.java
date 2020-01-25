package com.class08;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class WebTableDemo extends CommonMethods {
	public static void main(String[] args) {
		
		setUp("chrome", Constants.SYNTAX_PRACTICE_URL);
		//navigate to the table we need
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();
		
		//Find how many rows of data table has
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		System.out.println("Number of Rows in the table is ="+rows.size());
		
		System.out.println("Printing Row Data --------------------------");
		Iterator<WebElement> rowsIt=rows.iterator();
		while (rowsIt.hasNext()) {
			String rowData=rowsIt.next().getText();
			System.out.println(rowData);
		}
		
		
		//Find number of COLUMNS
		List<WebElement> columns=driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
		System.out.println("Number of Columns in the table is ="+columns.size());
		System.out.println("Printing column headers -----------------------");
		
		//to get the name 1 by by 1 in columns
		for (WebElement col: columns) {
			String header = col.getText();
			System.out.println(header);
		}
		
		driver.quit();
	}

}
