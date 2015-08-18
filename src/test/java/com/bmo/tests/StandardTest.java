package com.bmo.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bmo.common.GalenTestBase;
import com.bmo.pages.StandardPage;


public class StandardTest extends GalenTestBase{

	@Test(dataProvider = "devices")
	public void testApp(TestDevice testDevice) throws InterruptedException, IOException {
		Reporter.log(testDevice.getName(), true);
		loadUrl("/");
		StandardPage standardPage = entryPoint().waitForAlert(getDriver());
						checkScreen("/specs/welcomePage.spec", testDevice.getTags());
							//standardPage.enterCutomerInformation(getDriver());
		//Assert.assertTrue(standardPage.getEditButtonDisplayed(getDriver()), "Customer Information was not saved");
	}
}