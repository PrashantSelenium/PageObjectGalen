package com.bmo.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bmo.common.BaseTest;
import com.bmo.common.GalenTestBase;
import com.bmo.pages.Common;
import com.bmo.pages.StandardPage;

public class StandardTest extends StandardPage {

	@Test(dataProvider = "devices")
	public void testApp(TestDevice testDevice) throws InterruptedException, IOException {
		Reporter.log(testDevice.getName(), true);
		loadUrl("/");
		StandardPage standardPage = entryPoint().waitForAlert()
				.checkScreen("/specs/welcomePage.spec", testDevice.getTags()).enterCutomerInformation();
		Assert.assertTrue(standardPage.getEditButtonDisplayed(), "Customer Information was not saved");
	}
}