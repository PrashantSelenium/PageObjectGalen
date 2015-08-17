package com.bmo.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.bmo.common.BaseTest;
import com.bmo.common.GalenTestBase;

public class StandardPage extends GalenTestBase {
	
	By Customer_First_Name = By
			.id("guideContainer-rootPanel-accordioncontainer-yourName1434555782280-firstName___widget");
	By Customer_Middle_Name = By
			.id("guideContainer-rootPanel-accordioncontainer-yourName1434555782280-middleInitial___widget");
	By Customer_Last_Name = By.id("guideContainer-rootPanel-accordioncontainer-yourName1434555782280-title___widget");
	By Customer_Email = By.cssSelector("[data-type='youWillNeedEmail']");
	By Accept_Label = By.id("costofborrowing_accept_label");
	By Customer_Title = By
			.id("guideContainer-rootPanel-accordioncontainer-yourName1434555782280-title1435439214367___widget");
	By Date = By.id("guideContainer-rootPanel-accordioncontainer-dateOfBirth1434563837348-day___widget");
	By Month = By.id("guideContainer-rootPanel-accordioncontainer-dateOfBirth1434563837348-month___widget");
	By Year = By.id("guideContainer-rootPanel-accordioncontainer-dateOfBirth1434563837348-year___widget");

	By Customer_Social_Address = By.id("guideContainer-rootPanel-accordioncontainer-textfield___widget");
	By Customer_Phone_Number = By
			.id("guideContainer-rootPanel-accordioncontainer-phoneNumber1434564904495-textfield___widget");
	By Email = By.id("guideContainer-rootPanel-accordioncontainer-email1438104695209___widget");
	By Rent = By.id("guideContainer-rootPanel-accordioncontainer-housingStatus1434565546405___widget");
	By Rent_Mortgage = By.id("guideContainer-rootPanel-accordioncontainer-currentAddressRent1435241383913___widget");
	By Lived_Since_Month = By
			.id("guideContainer-rootPanel-accordioncontainer-currentAddressLivedSince1435241601308-month___widget");
	By Lived_Since_Year = By
			.id("guideContainer-rootPanel-accordioncontainer-currentAddressLivedSince1435241601308-year___widget");

	By SIN = By.id("guideContainer-rootPanel-accordioncontainer-socialInsuranceNumber1434563821255___widget");
	By Customer_home_Address = By.id("guideContainer-rootPanel-accordioncontainer-textfield___widget");
	
	By Home_add_street = By
			.id("guideContainer-rootPanel-accordioncontainer-currentHomeAddress1434564160490-streetNumber___widget");
	By Home_add_street_name = By
			.id("guideContainer-rootPanel-accordioncontainer-currentHomeAddress1434564160490-streetName___widget");
	By Home_add_apt = By.id("guideContainer-rootPanel-accordioncontainer-currentHomeAddress1434564160490-apt___widget");
	By Home_add_city = By
			.id("guideContainer-rootPanel-accordioncontainer-currentHomeAddress1434564160490-city___widget");
	By Home_add_province = By
			.id("guideContainer-rootPanel-accordioncontainer-currentHomeAddress1434564160490-province___widget");
	By Home_add_postcode = By
			.id("guideContainer-rootPanel-accordioncontainer-currentHomeAddress1434564160490-postalCode___widget");
	By Next_button = By.id("guideContainer-rootPanel-accordioncontainer___button_next");

	// Financial information
	By fi_employment_status = By
			.id("guideContainer-rootPanel-accordioncontainer_68159639-employmentStatus1434568111831___widget");
	By fi_occupation = By.id("guideContainer-rootPanel-accordioncontainer_68159639-occupation1434567999785___widget");
	By fi_employer_name = By
			.id("guideContainer-rootPanel-accordioncontainer_68159639-employerName1434568164069___widget");
	By fi_employee_since_month = By
			.id("guideContainer-rootPanel-accordioncontainer_68159639-employedSince1434568305818-month___widget");
	By fi_employee_since_year = By
			.id("guideContainer-rootPanel-accordioncontainer_68159639-employedSince1434568305818-year___widget");
	By fi_work_address_street_number = By
			.id("guideContainer-rootPanel-accordioncontainer_68159639-workAddress1435605731346-streetNumber___widget");
	By fi_work_address_street_name = By
			.id("guideContainer-rootPanel-accordioncontainer_68159639-workAddress1435605731346-streetName___widget");
	By fi_work_address_apt = By
			.id("guideContainer-rootPanel-accordioncontainer_68159639-workAddress1435605731346-apt___widget");
	By fi_work_address_city = By
			.id("guideContainer-rootPanel-accordioncontainer_68159639-workAddress1435605731346-city___widget");
	By fi_work_address_province = By
			.id("guideContainer-rootPanel-accordioncontainer_68159639-workAddress1435605731346-province___widget");
	By fi_work_address_postcode = By
			.id("guideContainer-rootPanel-accordioncontainer_68159639-workAddress1435605731346-postalCode___widget");
	By fi_workphone_number = By.id(
			"guideContainer-rootPanel-accordioncontainer_68159639-workPhoneNumber1434569463060-phoneNumber___widget");
	By fi_workphone_number_ext = By
			.id("guideContainer-rootPanel-accordioncontainer_68159639-workPhoneNumber1434569463060-extension___widget");
	By fi_Employment_income = By
			.id("guideContainer-rootPanel-accordioncontainer_68159639-employmentIncome1434569909512___widget");
	By fi_otherhousehold_income = By.id(
			"guideContainer-rootPanel-accordioncontainer_68159639-namecontainer-otherHouseholdIncome1436198231960___widget");
	By fi_otherhousehold_income_option = By.id(
			"guideContainer-rootPanel-accordioncontainer_68159639-namecontainer-otherHouseholdIncomeSource1436198311861___widget");
	By fi_typeofaccount = By.id(
			"guideContainer-rootPanel-accordioncontainer_68159639-bankingInformation1434570593941-typeOfAccount___widget");
	By fi_bankname = By.id(
			"guideContainer-rootPanel-accordioncontainer_68159639-bankingInformation1434570593941-bankNameOfAccount___widget");
	By fi_termsncondition = By.id("termsNconditionCheck");
	By fi_next_button = By.id("guideContainer-rootPanel-accordioncontainer_68159639___button_next");

	// Additional option
	By additional_option_complete_button = By
			.id("guideContainer-rootPanel-accordioncontainer_292387304___button_complete");

	public StandardPage waitForAlert() {
		// waitForElement(Accept_Label);
		getDriver().findElement(Accept_Label).click();
		return new StandardPage();
	}

	public StandardPage checkScreen(String specPath, List<String> includedTags) throws IOException {
		checkLayout(specPath, includedTags);
		return new StandardPage();
	}

	public boolean getStandardPageLoaded() {
		WebElement el = getDriver().findElement(By.id("signIn_link"));
		return el.isDisplayed();
	}

	public StandardPage enterCutomerInformation() throws InterruptedException {
		// getDriver().findElement(Customer_Email).sendKeys("Testing@gmail.com");
		getDriver().findElement(Customer_First_Name).sendKeys("TestingFirst");
		getDriver().findElement(Customer_Middle_Name).sendKeys("M");
		getDriver().findElement(Customer_Last_Name).sendKeys("TestingLast");
		getDriver().findElement(Customer_Title).sendKeys("Mr.");
		getDriver().findElement(Date).sendKeys("10");
		getDriver().findElement(Month).sendKeys("January");
		getDriver().findElement(Year).sendKeys("1950");
		// getDriver().findElement(Customer_home_Address).sendKeys("M4B 1B7");
		getDriver().findElement(SIN).sendKeys("793 526 914");
		getDriver().findElement(Home_add_street).sendKeys("12");
		getDriver().findElement(Home_add_street_name).sendKeys("street");
		getDriver().findElement(Home_add_apt).sendKeys("34");
		getDriver().findElement(Home_add_city).sendKeys("Toronto");
		getDriver().findElement(Home_add_province).sendKeys("ON");
		getDriver().findElement(Home_add_postcode).sendKeys("M4B 1B7");

		waitForElement(By.xpath(".//*[@id='bmoContainer']/div[5]/div[4]/div[2]/div[1]"));

		getDriver().findElement(By.xpath(".//*[@id='bmoContainer']/div[5]/div[4]/div[2]/div[1]")).click();
		getDriver().findElement(Customer_Phone_Number).sendKeys("(121) 123-1231");
		getDriver().findElement(Email).sendKeys("Test@gmail.com");
		Select dropdown = new Select(getDriver().findElement(Rent));
		dropdown.selectByValue("1");
		getDriver().findElement(Rent_Mortgage).sendKeys("30000");
		getDriver().findElement(Lived_Since_Month).sendKeys("January");
		getDriver().findElement(Lived_Since_Year).sendKeys("2010");
		Thread.sleep(3000);
		getDriver().findElement(Next_button).click();
		Thread.sleep(5000);
		waitForElement(fi_employment_status);
		Thread.sleep(3000);
		return new StandardPage();
	}

	public StandardPage enterFinancialInformation() throws InterruptedException {

		Select dropdown_employment_status = new Select(getDriver().findElement(fi_employment_status));
		dropdown_employment_status.selectByValue("2");
		Select dropdown_fi_occupation = new Select(getDriver().findElement(fi_occupation));
		dropdown_fi_occupation.selectByValue("1");
		getDriver().findElement(fi_employer_name).sendKeys("MyCompany");
		getDriver().findElement(fi_employee_since_month).sendKeys("February");
		getDriver().findElement(fi_employee_since_year).sendKeys("2000");
		getDriver().findElement(fi_work_address_street_number).sendKeys("98");
		getDriver().findElement(fi_work_address_street_name).sendKeys("FrontStreet");
		getDriver().findElement(fi_work_address_apt).sendKeys("3");
		getDriver().findElement(fi_work_address_city).sendKeys("Toronto");
		getDriver().findElement(fi_work_address_province).sendKeys("ON");
		getDriver().findElement(fi_work_address_postcode).sendKeys("M5V 3S8");
		getDriver().findElement(fi_workphone_number).sendKeys("(343) 344-3433");
		getDriver().findElement(fi_workphone_number_ext).sendKeys("765");
		getDriver().findElement(fi_Employment_income).sendKeys("1234");
		getDriver().findElement(fi_otherhousehold_income).sendKeys("876");
		Select dropdown_fi_otherhousehold_income = new Select(getDriver().findElement(fi_otherhousehold_income_option));
		dropdown_fi_otherhousehold_income.selectByValue("1");
		Select dropdown_fi_typeofaccount = new Select(getDriver().findElement(fi_typeofaccount));
		dropdown_fi_typeofaccount.selectByValue("3");
		Select dropdown_fi_bankname = new Select(getDriver().findElement(fi_bankname));
		dropdown_fi_bankname.selectByValue("2");
		getDriver().findElement(fi_termsncondition).click();
		getDriver().findElement(fi_next_button).click();

		Thread.sleep(5000);

		waitForElement(additional_option_complete_button);
		Thread.sleep(5000);

		getDriver().findElement(additional_option_complete_button).click();

		Thread.sleep(5000);

		return new StandardPage();
	}

	public Boolean getEditButtonDisplayed() {
		Boolean editButton = getDriver().findElement(By.id("guideContainer-rootPanel-accordioncontainer___button_next"))
				.isDisplayed();
		return editButton;
	}

}
