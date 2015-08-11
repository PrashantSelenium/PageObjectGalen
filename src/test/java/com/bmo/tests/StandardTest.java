package com.bmo.tests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bmo.pages.StandardPage;

public class StandardTest extends StandardPage {
	 @Test(dataProvider = "devices")
	public void testApp(TestDevice testDevice) throws InterruptedException, IOException {
		 Reporter.log( testDevice.getName(), true );
		StandardPage standardPage = entryPoint()
									.waitForAlert()
									.enterCutomerInformation()
									.enterFinancialInformation();
		//Assert.assertTrue(standardPage.getStandardPageLoaded(), "Standard Page is not loaded");
	}
}