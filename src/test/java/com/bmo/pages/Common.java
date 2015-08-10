package com.bmo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bmo.common.BaseTest;

public class Common extends BaseTest{

	private static final String Standard_Card = "html/body/form[1]/input[1]";

	public StandardPage entryPoint(){
		driver.findElement(By.xpath(Standard_Card)).click();
		return new StandardPage();
	}
	
	public void waitForElement(By by){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));		
	}
	
	
}
