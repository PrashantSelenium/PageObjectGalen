package com.bmo.common;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.galenframework.api.Galen;
import com.galenframework.reports.TestReport;
import com.galenframework.reports.model.LayoutReport;
import com.galenframework.support.GalenReportsContainer;

public class BaseTest{

	public String ENV_URL = "http://ec2-52-24-99-104.us-west-2.compute.amazonaws.com/content/forms/af/bmo/wl/entry.html";

	@BeforeMethod
	public WebDriver createDriver(Object[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get(ENV_URL);
		if (args.length > 0) {
			if (args[0] != null && args[0] instanceof TestDevice) {
				TestDevice device = (TestDevice) args[0];
				if (device.getScreenSize() != null) {
					driver.manage().window().setSize(device.getScreenSize());
				}
			}
		}
		return driver;
	}

	public void loadUrl(String uri) {
		//getDriver().get(ENV_URL);
		 loadUrl(ENV_URL + uri);
	}


	@DataProvider(name = "devices")
	public static Object[][] devices() {
		return new Object[][] { { new TestDevice("mobile", new Dimension(450, 800), asList("mobile")) },
				{ new TestDevice("tablet", new Dimension(750, 800), asList("tablet")) },
				{ new TestDevice("desktop", new Dimension(1024, 1000), asList("desktop")) } };
	}

	public static class TestDevice {
		private final String name;
		private final Dimension screenSize;
		private final List<String> tags;

		public TestDevice(String name, Dimension screenSize, List<String> tags) {
			this.name = name;
			this.screenSize = screenSize;
			this.tags = tags;
		}

		public String getName() {
			return name;
		}

		public Dimension getScreenSize() {
			return screenSize;
		}

		public List<String> getTags() {
			return tags;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[PlatForm=").append(name).append(", ScreenSize=").append(screenSize).append("]");
			return builder.toString();
		}
	}

}
