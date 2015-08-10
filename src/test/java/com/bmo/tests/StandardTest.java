package com.bmo.tests;

import org.testng.annotations.Test;

import com.bmo.common.BaseTest;
import com.bmo.pages.Common;
import com.bmo.pages.StandardPage;

public class StandardTest extends BaseTest {
	Common common= new Common();

	 @Test(dataProvider = "devices")
	public void testApp(TestDevice device) throws InterruptedException {
		 System.out.println(device.getTags());
		StandardPage standardPage = common.entryPoint()
									.waitForAlert()
									.enterCutomerInformation();
		//Assert.assertTrue(standardPage.getStandardPageLoaded(), "Standard Page is not loaded");
	}
}
