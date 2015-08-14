package com.bmo.common;

import static java.util.Arrays.asList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

import com.bmo.pages.Common;
import com.galenframework.testng.GalenTestNgTestBase;

public class BaseTest extends GalenTestNgTestBase{

	//public static WebDriver driver;
	protected Common common = new Common();
    public String ENV_URL="http://ec2-52-24-99-104.us-west-2.compute.amazonaws.com/content/forms/af/bmo/wl/entry.html";
    
    @Override
    public WebDriver createDriver(Object[] args) {
    	WebDriver driver = new FirefoxDriver();
        if (args.length > 0) {
            if (args[0] != null && args[0] instanceof TestDevice) {
                TestDevice device = (TestDevice)args[0];
                if (device.getScreenSize() != null) {
                    driver.manage().window().setSize(device.getScreenSize());
                }
            }
        }
        return driver;
    }
	   public void loadUrl(String uri) {
	        load(ENV_URL + uri);
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

	public WebElement dr(By by) {
		return getDriver().findElement(by);

	}
}
