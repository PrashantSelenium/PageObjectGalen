package com.bmo.common;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;

import com.bmo.pages.StandardPage;
import com.galenframework.testng.GalenTestNgTestBase;

import io.appium.java_client.ios.IOSDriver;

public abstract class GalenTestBase extends GalenTestNgTestBase {

	private static final String ENV_URL = "http://ec2-52-24-99-104.us-west-2.compute.amazonaws.com/content/forms/af/bmo/wl/entry.html";

	@Override
	public WebDriver createDriver(Object[] args) {
		TestDevice device = (TestDevice) args[0];
		if (device.name == "ios") {
			DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("deviceName", "iPhone 6");
	        capabilities.setCapability("platformName", "iOS");
	        capabilities.setCapability("platformVersion", "8.4");
	        capabilities.setCapability("browserName", "safari");
	        IOSDriver<WebElement> dr = null;
			try {
				dr=new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),
		                capabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dr;
		} else {

			WebDriver dr = new FirefoxDriver();
			if (args.length > 0) {
				if (args[0] != null && args[0] instanceof TestDevice) {

					if (device.getScreenSize() != null) {
						dr.manage().window().setSize(device.getScreenSize());
					}
				}
			}

			return dr;
		}
	}

	public void loadUrl(String uri) {
		load(ENV_URL);
	}

	@DataProvider(name = "devices")
	public Object[][] devices() {
		return new Object[][] {
			    { new TestDevice("mobile", new Dimension(450, 800), asList("mobile")) },
				{ new TestDevice("tablet", new Dimension(750, 800), asList("tablet")) },
				{ new TestDevice("desktop", new Dimension(1024, 800), asList("desktop")) }
				};
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
	}

	private static final String Standard_Card = "html/body/form[1]/input[1]";

	public StandardPage entryPoint() {
		getDriver().findElement(By.xpath(Standard_Card)).click();
		return new StandardPage();
	}

	public void checkScreen(String specPath, List<String> includedTags) throws IOException {
		checkLayout(specPath, includedTags);
	}

	@Override
	public WebDriver getDriver() {
		WebDriver driver = this.driver.get();
		if (driver == null) {
			throw new RuntimeException("The driver is not instantiated yet");
		}
		return driver;
	}

}
