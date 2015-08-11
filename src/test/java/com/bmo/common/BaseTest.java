package com.bmo.common;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import net.mindengine.galen.api.Galen;
import net.mindengine.galen.reports.TestReport;
import net.mindengine.galen.reports.model.LayoutReport;

public class BaseTest {

	public static WebDriver driver;
	ThreadLocal<TestReport> report = new ThreadLocal<TestReport>();

	public void checkLayout(WebDriver driver, String specPath, List<String> includedTags) throws IOException {
		String title = "Check layout " + specPath;
		LayoutReport layoutReport = Galen.checkLayout(driver, specPath, includedTags, null, new Properties(), null);
		report.get().layout(layoutReport, title);
		if (layoutReport.errors() > 0) {
			throw new RuntimeException("Incorrect layout: " + title);
		}
	}

	@BeforeMethod
	public void initReport(Method method) {
		report.set(GalenReportsContainer.get().registerTest(method));
	}

	@BeforeMethod
	public void createDriver(Object[] args) {
		driver = new ChromeDriver();
		driver.get("http://ec2-52-24-99-104.us-west-2.compute.amazonaws.com/content/forms/af/bmo/wl/entry.html");
		if (args.length > 0) {
			if (args[0] != null && args[0] instanceof TestDevice) {
				TestDevice device = (TestDevice) args[0];
				if (device.getScreenSize() != null) {
					System.out.println("*****" + device.name);
					driver.manage().window().setSize(device.getScreenSize());
				}
			}
		}
	}

	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}

	@DataProvider(name = "devices")
	public Object[][] devices() {
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
		return driver.findElement(by);

	}
}
