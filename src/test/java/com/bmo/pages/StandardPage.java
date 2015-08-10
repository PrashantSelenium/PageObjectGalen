package com.bmo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class StandardPage extends Common {

	By Customer_First_Name = By
			.id("guideContainer-rootPanel-accordioncontainer-yourName1434555782280-firstName___widget");
	By Customer_Last_Name = By.id("guideContainer-rootPanel-accordioncontainer-yourName1434555782280-title___widget");
	By Customer_Email = By.cssSelector("[data-type='youWillNeedEmail']");
	By Accept_Label = By.id("costofborrowing_accept_label");
	By Customer_Title = By
			.id("guideContainer-rootPanel-accordioncontainer-yourName1434555782280-title1435439214367___widget");
	By Date = By.id("guideContainer-rootPanel-accordioncontainer-dateOfBirth1434563837348-day___widget");
	By Month = By.id("guideContainer-rootPanel-accordioncontainer-dateOfBirth1434563837348-month___widget");
	By Year = By.id("guideContainer-rootPanel-accordioncontainer-dateOfBirth1434563837348-year___widget");
	By Customer_Social_Address = By.id("guideContainer-rootPanel-accordioncontainer-textfield___widget");
	By Customer_Phone_Number=By.id("guideContainer-rootPanel-accordioncontainer-phoneNumber1434564904495-textfield___widget");
	By Email=By.id("guideContainer-rootPanel-accordioncontainer-email1438104695209___widget");
	By Rent=By.id("guideContainer-rootPanel-accordioncontainer-housingStatus1434565546405___widget");
	By Rent_Mortgage=By.id("guideContainer-rootPanel-accordioncontainer-currentAddressRent1435241383913___widget");
	By Lived_Since_Month=By.id("guideContainer-rootPanel-accordioncontainer-currentAddressLivedSince1435241601308-month___widget");
	By Lived_Since_Year=By.id("guideContainer-rootPanel-accordioncontainer-currentAddressLivedSince1435241601308-year___widget");

	public StandardPage waitForAlert() {
		waitForElement(Accept_Label);
		driver.findElement(Accept_Label).click();
		return new StandardPage();
	}

	public boolean getStandardPageLoaded() {
		WebElement el = driver.findElement(By.id("signIn_link"));
		return el.isDisplayed();
	}

	public StandardPage enterCutomerInformation() throws InterruptedException {
		driver.findElement(Customer_Email).sendKeys("Testing@gmail.com");
		driver.findElement(Customer_First_Name).sendKeys("TestingFirst");
		driver.findElement(Customer_Last_Name).sendKeys("TestingLast");
		driver.findElement(Customer_Title).sendKeys("Mr.");
		driver.findElement(Date).sendKeys("10");
		driver.findElement(Month).sendKeys("January");
		driver.findElement(Year).sendKeys("1987");
		driver.findElement(Customer_Social_Address).sendKeys("M4B 1B7");
		waitForElement(By.xpath(".//*[@id='bmoContainer']/div[5]/div[4]/div[2]/div[1]"));
        driver.findElement(By.xpath(".//*[@id='bmoContainer']/div[5]/div[4]/div[2]/div[1]")).click();
        driver.findElement(Customer_Phone_Number).sendKeys("(121) 123-1231");
        driver.findElement(Email).sendKeys("Test@gmail.com");
        Select dropdown = new Select(driver.findElement(Rent));
        dropdown.selectByValue("1");
        driver.findElement(Rent_Mortgage).sendKeys("30000");
        driver.findElement(Lived_Since_Month).sendKeys("January");
        driver.findElement(Lived_Since_Year).sendKeys("2010");		
        Thread.sleep(3000);
		return new StandardPage();
	}
}
